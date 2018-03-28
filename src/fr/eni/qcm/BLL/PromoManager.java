/**
 * 
 */
package fr.eni.qcm.BLL;

import java.util.List;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Promo;
import fr.eni.qcm.DAL.DAOFactory;
import fr.eni.qcm.DAL.PromoDAO;

/**
 * @author wmodeste2017
 *	28 mars 2018
 */
public class PromoManager {
	private PromoDAO promoDAO;
	
public PromoManager() {
	this.promoDAO=DAOFactory.getPromoDAO();
}

public List<Promo> getAll()throws BusinessException{
	return this.promoDAO.selectAll();
}
}
