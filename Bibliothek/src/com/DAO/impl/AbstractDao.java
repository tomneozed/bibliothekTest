package com.DAO.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.DAO.HibernateFactory;
import com.DAO.exceptions.DaoException;
import com.DAO.pojo.AuteurPojo;
import com.DAO.pojo.OuvragePojo;

public class AbstractDao {
	
	protected Session session;
	private Transaction transaction;
	
	public AbstractDao() {
		HibernateFactory.buildIfNeeded();
	}

	protected void update(Object object) {
		try {
			startOperation();
			session.saveOrUpdate(object);
			transaction.commit();
		}catch(HibernateException e) {
			handleException(e);
		}finally {
			HibernateFactory.close(session);
		}
	}
	
	/**
     * CRUD's Create method
     * @param objec
     * @return
     */
    protected Integer save(Object object){
        Integer id = -1;
        try{
            startOperation();
            id = (Integer)session.save(object);
            transaction.commit();
            if(id == -1)
            {
                throw new DaoException("Saving object " + object.toString() + " failed");
            }
        }catch(HibernateException e)
        {
            handleException(e);
        }finally{
            HibernateFactory.close(session);
        }
        return id;
    }

    /**
     * CRUD's Delete method
     * @param object
     */
    protected void delete(Object object) {
        try{
            startOperation();
            session.delete(object);
            transaction.commit();
        }catch(HibernateException e)
        {
            handleException(e);
        }finally{
            HibernateFactory.close(session);
        }
    }

    /**
     * CRUD's Read method
     * @param clazz
     * @param id
     * @return
     */
    protected Object find(Class clazz, int id) throws DaoException{
        Object object = null;
        try{
            startOperation();
            object = session.get(clazz, id);
            if(object == null)
            {
                throw new DaoException("The id " + id +" doesn't seems to correspond to any object from the table " + clazz.getName());
            }
            transaction.commit();
        }catch(HibernateException e)
        {
            handleException(e);
        }finally{
            HibernateFactory.close(session);
        }
        return object;
    }

    /**
     * Returns all the objects from specified class
     * @param clazz
     * @return
     */
    protected List findAll(Class clazz) throws DaoException {
        List<Class> objects = null;
        String className = parsePojo(clazz.getName());
        try{
            startOperation();
            objects = session.createQuery("from " + clazz.getName()).getResultList();
            if(objects == null)
            {
                throw new DaoException("There is no object from " + clazz.getName() + " in the database" );
            }
            transaction.commit();
        }catch(HibernateException e)
        {
            handleException(e);
        }finally{
            HibernateFactory.close(session);
        }
        return objects;
    }


    protected Object findByPseudo(String pseudo) throws DaoException
    {
        Object object = null;
        try{
            startOperation();
            object = session.createQuery("from utilisateur where pseudo = :pseudo").setParameter("pseudo", pseudo).getSingleResult();
            if(object == null)
            {
                throw new DaoException("Pseudo " + pseudo +" doesn't seems to correspond to any object from the database " );
            }
            transaction.commit();
        }catch(HibernateException e)
        {
            handleException(e);
        }finally{
            HibernateFactory.close(session);
        }
        return object;
    }

//    protected List<PretPojo> findAllPretByUtilisateur(UtilisateurPojo util) throws DaoException
//    {
//        List<PretPojo> pretPojos = null;
//        try{
//            startOperation();
//            pretPojos = session.createQuery("from pret where idUtilisateur = :idUtil").setParameter("idUtil", util.getId()).getResultList();
//            if(pretPojos.isEmpty())
//            {
//                throw new DaoException("There is no loan for the user : " + util.getNom()+ " " + util.getPrenom()) ;
//            }
//            transaction.commit();
//        }catch(HibernateException e)
//        {
//            handleException(e);
//        }finally{
//            HibernateFactory.close(session);
//        }
//        return pretPojos;
//    }

//    protected List<OuvragePojo> findAllByParam(String param) throws DaoException{
//        List<OuvragePojo> ouvragePojos = new ArrayList<>();
//        List<OuvragePojo> ouvragePojosByTitre ;
//        List<AuteurPojo> auteurPojoList;
//        String params[] = param.split(" ");
//
//
//        try{
//            startOperation();
//
//            for(int i = 0; i< params.length; i++)
//            {
//                params[i] = params[i].toLowerCase();
//                params[i] = "%"+params[i]+"%";
//                ouvragePojosByTitre = session.createQuery("from ouvrage where lower(titre) like :param").setParameter("param", params[i]).getResultList();
//                auteurPojoList = session.createQuery("from auteur where lower(nom) like :param or lower(prenom) like :param").setParameter("param", params[i]).getResultList();
//
//                ouvragePojos = addList(ouvragePojos, ouvragePojosByTitre, auteurPojoList);
//            }
//
//
//            if(ouvragePojos.isEmpty())
//            {
//                throw new DaoException(param + " doesn't seems to correspond to any object from the database" ) ;
//            }
//            transaction.commit();
//        }catch(HibernateException e)
//        {
//            handleException(e);
//        }finally{
//            HibernateFactory.close(session);
//        }
//        return ouvragePojos;
//    }


    /**
     * Rollbaks current Transaction and throws DaoException
     * @param e
     * @throws DaoException
     */
    protected void handleException(HibernateException e) throws DaoException{
        HibernateFactory.rollback(transaction);
        throw new DaoException(e);
    }

    /**
     * Opens Session and begins Transaction
     * @throws HibernateException
     */
    protected void startOperation() throws HibernateException{
        session = HibernateFactory.openSession();
        transaction = session.beginTransaction();
    }

//    private List<OuvragePojo> addList(List<OuvragePojo> ouvragePojoARetourner, List<OuvragePojo> ouvragePojoList, List<AuteurPojo> auteurPojoList)
//    {
//        if(!auteurPojoList.isEmpty())
//        {
//            for(int i = 0; i < auteurPojoList.size(); i++)
//            {
//                for(int j = 0; j < auteurPojoList.get(i).getOuvragePojos().size(); j++)
//                {
//                    if(!ouvragePojoARetourner.isEmpty()){
//
//                        if(!ouvragePojoARetourner.contains(auteurPojoList.get(i).getOuvragePojos().get(j)))
//                        {
//                            ouvragePojoARetourner.add(auteurPojoList.get(i).getOuvragePojos().get(j));
//                        }
//                    }else{
//                        ouvragePojoARetourner.add(auteurPojoList.get(i).getOuvragePojos().get(j));
//                    }
//
//                }
//            }
//        }
//
//        if(!ouvragePojoList.isEmpty())
//        {
//            for(int i = 0; i < ouvragePojoList.size(); i++)
//            {
//                if(!ouvragePojoARetourner.isEmpty())
//                {
//                    if(!ouvragePojoARetourner.contains(ouvragePojoList.get(i)))
//                    {
//                        ouvragePojoARetourner.add(ouvragePojoList.get(i));
//                    }
//                }else{
//                    ouvragePojoARetourner.add(ouvragePojoList.get(i));
//                }
//            }
//        }
//
//        return ouvragePojoARetourner;
//    }


    private String parsePojo(String str)
    {
        String value ="";
        for(int i =0 ; i < str.length() -4; i++)
        {
            value += str.charAt(i);
        }
        return value;
    }
	
}
