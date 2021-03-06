package fr.eni.qcm.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import fr.eni.qcm.BusinessError;
import fr.eni.qcm.BusinessException;
import fr.eni.qcm.CodeEtatEpreuve;
import fr.eni.qcm.BO.Epreuve;
import fr.eni.qcm.BO.EpreuveCandidat;
import fr.eni.qcm.BO.ReponseUser;
import fr.eni.qcm.BO.Resultat;

public class EpreuveDAOJdbcImpl implements EpreuveDAO {

	private final String GET_USER_EPREUVE = "select * from EPREUVE where idUtilisateur = ?";
	private final String CREATE_USER_EPREUVE = "insert into EPREUVE(dateDebutValidite, dateFinValidite,etat, idTest, idUtilisateur) values (?,?,?,?,?)";
	private final String FIND_USER_EPREUVE = "select e.etat, e.note_obtenue, e.niveau_obtenu, e.idTest, t.libelle, e.dateDebutValidite, e.idEpreuve, e.idTest, e.idUtilisateur from EPREUVE e, TEST t where e.idTest = t.idTest and idUtilisateur = ?";
	private final String SELECT_REPONSE = "select * from REPONSE_TIRAGE where idQuestion = ? and idEpreuve = ?";
	private final String INSERT_REPONSE = "insert into REPONSE_TIRAGE (idProposition, idQuestion, idEpreuve) values (?, ?, ?) ";
	private final String UPDATE_REPONSE = "update REPONSE_TIRAGE set idProposition = ? where idQuestion = ? and idEpreuve = ?";
	private final String DELETE_REPONSE = "delete from REPONSE_TIRAGE where idProposition = ? and idQuestion = ? and idEpreuve = ?";
	private final String SELECT_REPONSES_USER = "select * from REPONSE_TIRAGE where  idEpreuve = ?";

	// Construit un object Epreuve depuis un ResultSet
	private Epreuve buildEpreuve(ResultSet rs) throws SQLException {
		Epreuve epr = new Epreuve();

		epr.setIdEpreuve(rs.getInt(1));
		epr.setDebut(rs.getTimestamp(2).toInstant());
		epr.setFin(rs.getTimestamp(3).toInstant());
		epr.setTempsEcoule(rs.getInt(4));
		epr.setEtat(rs.getString(5));
		epr.setNoteObtenue(rs.getFloat(6));
		epr.setNiveauObtenu(rs.getString(7));
		epr.setIdTest(rs.getInt(8));
		epr.setIdUtilisateur(rs.getInt(9));

		return epr;
	}

	@Override
	public List<Epreuve> getUserEpreuve(int userID) throws BusinessException {
		List<Epreuve> epreuves = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(GET_USER_EPREUVE);
			pst.setInt(1, userID);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Epreuve epr = this.buildEpreuve(rs);
				epreuves.add(epr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}

		return epreuves;
	}

	public Boolean Create(Instant dateDebut, Instant dateFin, int idTest, int idUser) throws BusinessException {
		boolean bool = false;
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pst = cnx.prepareStatement(CREATE_USER_EPREUVE);
			pst.setTimestamp(1, Timestamp.from(dateDebut));
			pst.setTimestamp(2, Timestamp.from(dateFin));
			pst.setString(3, CodeEtatEpreuve.PLANNFIE);
			pst.setInt(4, idTest);
			pst.setInt(5, idUser);
			bool = pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}

		return bool;
	}

	@Override
	public List<Resultat> getResultatForTest(int testID) throws BusinessException {
		String query = "select * from EPREUVE as e left join UTILISATEUR as u "
				+ "on e.idUtilisateur = u.idUtilisateur " + "where e.idTest = ?";

		List<Resultat> resultats = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(query);
			pst.setInt(1, testID);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Resultat res = new Resultat();

				res.setIdEpreuve(rs.getInt(1));
				res.setDebut(rs.getTimestamp(2).toInstant());
				res.setFin(rs.getTimestamp(3).toInstant());
				res.setTempsEcoule(rs.getInt(4));
				res.setEtat(rs.getString(5));
				res.setNoteObtenue(rs.getFloat(6));
				res.setNiveauObtenu(rs.getString(7));
				res.setIdTest(rs.getInt(8));
				res.setIdUtilisateur(rs.getInt(9));
				res.setNom(rs.getString(11));
				res.setPrenom(rs.getString(12));

				resultats.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}

		return resultats;
	}

	/**
	 * Méthode en charge de récupérer les épreuves d'un candidat ainsi que le nom du
	 * test associé
	 * 
	 * @param userId
	 * @return
	 * @throws BusinessException
	 * @see fr.eni.qcm.DAL.EpreuveDAO#getUserTest(int)
	 */
	@Override
	public List<EpreuveCandidat> getUserTest(int userId) throws BusinessException {

		List<EpreuveCandidat> epreuves = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(FIND_USER_EPREUVE);
			pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				EpreuveCandidat ec = new EpreuveCandidat();
				ec.setEtat(rs.getString(1));
				ec.setNoteObtenue(rs.getInt(2));
				ec.setNiveauObtenu(rs.getString(3));
				ec.setIdTest(rs.getInt(4));
				ec.setLibelleTest(rs.getString(5));
				ec.setDebut(rs.getTimestamp(6).toInstant());
				ec.setIdEpreuve(rs.getInt(7));
				ec.setIdTest(rs.getInt(8));
				ec.setIdUtilisateur(userId);

				epreuves.add(ec);
			}

		} catch (SQLException e) {
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}

		return epreuves;
	}

	/**
	 * Méthode en charge de
	 * 
	 * @throws BusinessException
	 * @see fr.eni.qcm.DAL.EpreuveDAO#ajoutReponse()
	 */
	@Override
	public void ajoutReponseRadio(int idReponse, int idQuestion, int idEpreuve) throws BusinessException {

		PreparedStatement pst;
		try (Connection cnx = ConnectionProvider.getConnection()) {

			cnx.setAutoCommit(false);

			pst = cnx.prepareStatement(SELECT_REPONSE);
			pst.setInt(1, idQuestion);
			pst.setInt(2, idEpreuve);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				pst = cnx.prepareStatement(UPDATE_REPONSE);
				pst.setInt(1, idReponse);
				pst.setInt(2, idQuestion);
				pst.setInt(3, idEpreuve);

				pst.executeUpdate();

			} else {
				pst = cnx.prepareStatement(INSERT_REPONSE);
				pst.setInt(1, idReponse);
				pst.setInt(2, idQuestion);
				pst.setInt(3, idEpreuve);

				pst.executeUpdate();

			}

			cnx.commit();

		} catch (SQLException e) {
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}
	}

	/**
	 * Méthode en charge de récupérer les réponses saisies par l'utilisateur
	 * 
	 * @param idEpreuve
	 * @return
	 * @throws BusinessException
	 * @see fr.eni.qcm.DAL.EpreuveDAO#reponsesUser(int)
	 */
	@Override
	public List<ReponseUser> reponsesUser(int idEpreuve) throws BusinessException {
		List<ReponseUser> reponses = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pst = cnx.prepareStatement(SELECT_REPONSES_USER);
			pst.setInt(1, idEpreuve);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				ReponseUser rep = new ReponseUser();
				rep.setIdReponse(rs.getInt("idProposition"));
				rep.setIdQuestion(rs.getInt("idQuestion"));
				rep.setIdEpreuve(idEpreuve);

				reponses.add(rep);
			}

		} catch (SQLException e) {
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}

		return reponses;
	}

	/**
	 * Méthode en charge de récupérer les réponses saisies par l'utilisateur
	 * 
	 * @param idReponses
	 * @param idQuestion
	 * @param idEpreuve
	 * @throws BusinessException
	 * @see fr.eni.qcm.DAL.EpreuveDAO#ajoutReponseBox(java.util.List, int, int)
	 */
	@Override
	public void ajoutReponseBox(int idReponse, int idQuestion, int idEpreuve) throws BusinessException {
		ResultSet rs;
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pst = cnx.prepareStatement(SELECT_REPONSE);
			pst.setInt(1, idQuestion);
			pst.setInt(2, idEpreuve);
			rs = pst.executeQuery();

			if (!rs.next()) {

				pst = cnx.prepareStatement(INSERT_REPONSE);
				pst.setInt(1, idReponse);
				pst.setInt(2, idQuestion);
				pst.setInt(3, idEpreuve);

				pst.executeUpdate();

			} else {
				System.out.println("on passe dans else ");

				while (rs.next()) {

					System.out.println("on est dans le while");

					if (rs.getInt("idProposition") == idReponse) {
						System.out.println("on passe dans le delete");
						pst = cnx.prepareStatement(DELETE_REPONSE);
						pst.setInt(1, idReponse);
						pst.setInt(2, idQuestion);
						pst.setInt(3, idEpreuve);

						pst.executeUpdate();

					} else {
						System.out.println("on passe dans le deuxième insert");
						pst = cnx.prepareStatement(INSERT_REPONSE);
						pst.setInt(1, idReponse);
						pst.setInt(2, idQuestion);
						pst.setInt(3, idEpreuve);

						pst.executeUpdate();

					}

				}
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}
	}

}
