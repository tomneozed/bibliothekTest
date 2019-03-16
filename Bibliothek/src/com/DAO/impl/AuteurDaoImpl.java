package com.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import com.DAO.exceptions.DaoException;
import com.DAO.interfaces.AuteurDao;
import com.DAO.pojo.AuteurPojo;

public class AuteurDaoImpl extends AbstractDao implements AuteurDao{
	
	public AuteurDaoImpl() {
		super();
	}
	
	@Override
    public AuteurPojo findById(int id) throws DaoException {

        return (AuteurPojo)super.find(AuteurPojo.class, id);
    }

    /* (non-Javadoc)
	 * @see com.DAO.impl.AuteurDao#create(com.DAO.pojo.AuteurPojo)
	 */
    @Override
    public int create(AuteurPojo auteurPojo) throws DaoException{
        super.update(auteurPojo);
        return auteurPojo.getId();
    }

    /* (non-Javadoc)
	 * @see com.DAO.impl.AuteurDao#delete(com.DAO.pojo.AuteurPojo)
	 */
    @Override
    public void delete(AuteurPojo auteurPojo) throws DaoException{
        super.delete(auteurPojo);
    }

    /* (non-Javadoc)
	 * @see com.DAO.impl.AuteurDao#update(com.DAO.pojo.AuteurPojo)
	 */
    @Override
    public void update(AuteurPojo auteurPojo) throws DaoException{
        super.update(auteurPojo);
    }

    @Override
    public List findAll() throws DaoException{

        return super.findAll(AuteurPojo.class);
    }

    /**
     * Returns all auteurs from specified ouvrage
     * @param ouvrageId
     * @return
     */
    @Override
    public List<AuteurPojo> findAllByOuvrageId(int ouvrageId){
//        List<AuteurOuvragePojo> tousLesOuvrages = super.findAll(AuteurOuvragePojo.class);
        List<AuteurPojo> auteurPojos = new ArrayList<>();
//
//        for (int i=0; i< tousLesOuvrages.size(); i++ )
//        {
//            if(tousLesOuvrages.get(i).getOuvrageId() == ouvrageId)
//            {
//                auteurPojos.add((AuteurPojo)super.find(AuteurPojo.class, tousLesOuvrages.get(i).getAuteurId()));
//            }
//        }
        return auteurPojos;
    }
	
}
