package com.DAO.impl;

import java.util.List;

import com.DAO.exceptions.DaoException;
import com.DAO.interfaces.PretDao;
import com.DAO.pojo.PretPojo;

public class PretDaoImpl extends AbstractDao implements PretDao {
	
	public PretDaoImpl() {
		super();
	}
	
	@Override
	public PretPojo findById(int id) throws DaoException {
		return (PretPojo)super.find(PretPojo.class, id);
	}
	
	@Override
	public int create(PretPojo pretPojo) throws DaoException {
		return super.save(pretPojo);
	}
	
	@Override
	public void delete(int id) throws DaoException {
		super.delete(id);
	}
	
	@Override
	public void update(PretPojo pretPojo) throws DaoException {
		super.update(pretPojo);
	}
	
	@Override
	public List findAll() throws DaoException {
		return super.findAll(PretPojo.class);
	}
	
//	public List<PretPojo> findAllByUser(UtilisateurPojo utilisateur) throws DaoException{
//		return super.findAllPretByUtilisateur(utilisateur);
//	}

}
