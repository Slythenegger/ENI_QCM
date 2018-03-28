/**
 * 
 */
package fr.eni.qcm.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Promo;

/**
 * @author wmodeste2017
 *	28 mars 2018
 */
public class PromoDAOJdbcImpl implements PromoDAO {
private final String SELECT_ALL="select * from PROMOTION";
	
	/* (non-Javadoc)
	 * @see fr.eni.qcm.DAL.PromoDAO#selectAll(int)
	 */
	@Override
	public List<Promo> selectAll() throws BusinessException {
		List<Promo> promos= new ArrayList<>();
		try ( Connection cnx= ConnectionProvider.getConnection()){
			PreparedStatement pst = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
			Promo promo = this.buildPromo(rs);
			promos.add(promo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return promos;
	}

	/**
	 *	Methode servant à  crée un objet promotion à partir du resultset:
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private Promo buildPromo(ResultSet rs) throws SQLException {
		
		Promo promo = new Promo();
		promo.setCodePromo(rs.getString(1));
		promo.setLibellePromo(rs.getString(2));

		return promo;
	}

}
