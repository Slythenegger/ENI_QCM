package fr.eni.qcm.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import fr.eni.qcm.BusinessError;
import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Epreuve;

public class EpreuveDAOJdbcImpl implements EpreuveDAO {

	private final String GET_USER_EPREUVE = "select * from EPREUVE where idUtilisateur = ?";
	
	// Construit un object Epreuve depuis un ResultSet
	private Epreuve buildEpreuve(ResultSet rs) throws SQLException {
		Epreuve epr = new Epreuve();
		
		epr.setIdEpreuve(rs.getInt(1));
		epr.setDebut(rs.getTimestamp(2).toInstant());
		epr.setFin(rs.getTimestamp(3).toInstant());
		epr.setTempsEcoule(rs.getInt(4));
		epr.setEtat(rs.getString(5));
		epr.setNoteObtenue(rs.getInt(6));
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
			
			while(rs.next()) {
				Epreuve epr = this.buildEpreuve(rs);
				epreuves.add(epr);				
			}			
		} 
		catch (SQLException e) {
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}
		
		return epreuves;
	}

}
