package fr.eni.qcm.BLL;

import java.util.List;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Test;
import fr.eni.qcm.DAL.DAOFactory;
import fr.eni.qcm.DAL.TestDAO;

public class TestManager {
	private TestDAO dao;
	
	public TestManager() {
		this.dao = DAOFactory.getTestDAO();
	}
	
	public List<Test> getAll() throws BusinessException {
		return this.dao.selectAll();
	}
	
	public Test getById(int id) throws BusinessException {
		return this.dao.getById(id);
	}
	
}
