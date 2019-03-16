package com.DAO.interfaces;

import java.util.List;

import com.DAO.exceptions.DaoException;
import com.DAO.pojo.AuteurPojo;

public interface AuteurDao {
	
	AuteurPojo findById(int id) throws DaoException;

	int create(AuteurPojo auteurPojo) throws DaoException;

	void delete(AuteurPojo auteurPojo) throws DaoException;

	void update(AuteurPojo auteurPojo) throws DaoException;

	List findAll() throws DaoException;

	List<AuteurPojo> findAllByOuvrageId(int ouvrageId);

}