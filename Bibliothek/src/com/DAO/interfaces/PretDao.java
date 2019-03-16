package com.DAO.interfaces;

import java.util.List;

import com.DAO.exceptions.DaoException;
import com.DAO.pojo.PretPojo;

public interface PretDao {

	PretPojo findById(int id) throws DaoException;

	int create(PretPojo pretPojo) throws DaoException;

	void delete(int id) throws DaoException;

	void update(PretPojo pretPojo) throws DaoException;

	List findAll() throws DaoException;

}