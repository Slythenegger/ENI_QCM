package fr.eni.qcm.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.qcm.BusinessError;
import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Test;

public class TestDAOJdbcImpl implements TestDAO {

	private final String SELECT_ALL = "select * from TEST";
	
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
			
			while(rs.next()) {
				Test test = this.buildTest(rs);
				tests.add(test);
			}
		} 
		catch (SQLException e) {
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}
		
		return tests;
	}

}
