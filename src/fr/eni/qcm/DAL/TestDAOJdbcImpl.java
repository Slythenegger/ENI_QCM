package fr.eni.qcm.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.qcm.BusinessError;
import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Question;
import fr.eni.qcm.BO.Reponse;
import fr.eni.qcm.BO.Section;
import fr.eni.qcm.BO.Test;

public class TestDAOJdbcImpl implements TestDAO {

	private final String SELECT_ALL = "select * from TEST";
	private final String SELECT_BY_ID = "select * from TEST where idTest = ?";
	private final String SELECT_SECTIONS = "select * from SECTION_TEST where idTest= ?";
	private final String SELECT_QUESTIONS = "select top (?) * from QUESTION q, THEME th, SECTION_TEST s, TEST te where te.idTest=s.idTest and s.idTheme=th.idTheme and th.idTheme=q.idTheme and s.idTheme = ? order by NEWID()";
	private final String SELECT_REPONSES = "select * from PROPOSITION  where idQuestion= ?";

	private Test buildTest(ResultSet rs) throws SQLException {
		Test test = new Test();

		test.setIdTest(rs.getInt(1));
		test.setLibelle(rs.getString(2));
		test.setDescription(rs.getString(3));
		test.setDuree(rs.getInt(4));
		test.setSeuilHaut(rs.getFloat(5));
		test.setSeuilBas(rs.getFloat(6));

		return test;
	}

	@Override
	public List<Test> selectAll() throws BusinessException {
		List<Test> tests = new ArrayList<Test>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Test test = this.buildTest(rs);
				tests.add(test);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}

		return tests;
	}

	@Override
	public Test getById(int id) throws BusinessException {
		Test test = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(SELECT_BY_ID);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				test = this.buildTest(rs);
			}
		} catch (SQLException e) {
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}

		return test;
	}
	
	@Override
	public void insert(Test test) throws BusinessException {
		String query = "insert into TEST(libelle, description, duree, seuil_haut, seuil_bas) values(?,?,?,?,?);";
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, test.getLibelle());
			pst.setString(2, test.getDescription());
			pst.setInt(3, test.getDuree());
			pst.setFloat(4, test.getSeuilHaut());
			pst.setFloat(5, test.getSeuilBas());
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			rs.next();
			test.setIdTest(rs.getInt(1));			
		} 
		catch (SQLException e) {
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}
	}


	/**
	 * Méthode en charge de récupérer la lsite des questions/réponses d'un test
	 * 
	 * @param idTest
	 * @return
	 * @throws BusinessException
	 * @see fr.eni.qcm.DAL.TestDAO#selectQuesRepByIdTest(int)
	 */
	@Override
	public List<Question> selectQuesRepByIdTest(int idTest) throws BusinessException {

		List<Section> sections = new ArrayList<>();
		List<Question> questions = new ArrayList<>();

	

		ResultSet rs = null;
		PreparedStatement pst = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			cnx.setAutoCommit(false);

			// On récupère la listes des sections du test

			pst = cnx.prepareStatement(SELECT_SECTIONS);
			pst.setInt(1, idTest);
			rs = pst.executeQuery();

			while (rs.next()) {
				Section section = new Section();
				section.setNbQuestions(rs.getInt("nbQuestionsATirer"));
				section.setIdTest(rs.getInt(idTest));
				section.setIdTheme(rs.getInt("idTheme"));

				sections.add(section);				
			}

			rs.close();
			pst.close();
			// on récupère la liste des questions des sections du test

			for (Section sec : sections) {
				pst = cnx.prepareStatement(SELECT_QUESTIONS);
				
				pst.setInt(1, sec.getNbQuestions());
				pst.setInt(2, sec.getIdTheme());
				rs = pst.executeQuery();

				while (rs.next()) {
					Question ques = new Question();

					ques.setIdQuestion(rs.getInt("idQuestion"));
					ques.setEnonce(rs.getString("enonce"));
					ques.setMedia(rs.getString("media"));
					ques.setPoints(rs.getInt("points"));
					ques.setEstMulti(rs.getBoolean("estMultichoix"));
					ques.setIdTheme(rs.getInt("idTheme"));

					questions.add(ques);

				}
				rs.close();
				pst.close();
			}
			rs.close();
			pst.close();

			// on récupère les réponses par rapport aux questions des sections du test

			for (Question ques : questions) {				
				List<Reponse> reponses = new ArrayList<>();
				pst = cnx.prepareStatement(SELECT_REPONSES);
				pst.setInt(1, ques.getIdQuestion());
				rs = pst.executeQuery();

				while (rs.next()) {

					Reponse rep = new Reponse();
					rep.setIdReponse(rs.getInt("idProposition"));
					rep.setEnonce(rs.getString("enonce"));
					rep.setCorrect(rs.getBoolean("estBonne"));
					rep.setIdQuestion(rs.getInt("idQuestion"));

					reponses.add(rep);
				}
			
				ques.setReponses(reponses);

				

			}

			cnx.commit();
			rs.close();
			pst.close();
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}

		return questions;
	}

}
