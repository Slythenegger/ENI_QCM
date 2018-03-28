/**
 * 
 */
package fr.eni.qcm.DAL;

import java.util.List;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Promo;


/**
 * @author wmodeste2017
 *	28 mars 2018
 */
public interface PromoDAO {
	public List<Promo> selectAll() throws BusinessException;
}
