package com.DAO.impl;

import java.util.List;

import com.DAO.exceptions.DaoException;
import com.DAO.interfaces.OuvrageDao;
import com.DAO.pojo.OuvragePojo;

public class OuvrageDaoImpl extends AbstractDao implements OuvrageDao{
	
	public OuvrageDaoImpl() { }
	
	@Override
	public List findAll() throws DaoException {
		return super.findAll(OuvragePojo.class);
	}
	
	@Override
	public OuvragePojo findById(int id) throws DaoException {
		return (OuvragePojo) super.find(OuvragePojo.class, id);
	}
	
	@Override
	public int create(OuvragePojo ouvrage) throws DaoException {
		super.update(ouvrage);
		return ouvrage.getId();
	}
	
	@Override
	public void update(OuvragePojo ouvrage) throws DaoException {
		super.update(ouvrage);
	}
	
	@Override
	public void delete(OuvragePojo ouvrage) throws DaoException {
		super.delete(ouvrage);
	}
	
//	public List<OuvragePojo> findAllByParam(String param) throws DaoException {
//		return super.findAllByParam(param);
//	}
	
	
	

}
