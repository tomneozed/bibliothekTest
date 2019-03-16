package com.DAO.interfaces;

import java.util.List;

import com.DAO.exceptions.DaoException;
import com.DAO.pojo.OuvragePojo;

public interface OuvrageDao {

	List findAll() throws DaoException;

	OuvragePojo findById(int id) throws DaoException;

	int create(OuvragePojo ouvrage) throws DaoException;

	void update(OuvragePojo ouvrage) throws DaoException;

	void delete(OuvragePojo ouvrage) throws DaoException;

}