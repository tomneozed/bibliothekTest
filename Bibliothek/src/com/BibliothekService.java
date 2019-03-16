package com;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.DAO.exceptions.DaoException;
import com.DAO.impl.AuteurDaoImpl;
import com.DAO.interfaces.AuteurDao;
import com.DAO.interfaces.OuvrageDao;
import com.DAO.interfaces.PretDao;
import com.DAO.pojo.AuteurPojo;
import com.DAO.pojo.OuvragePojo;
import com.DAO.pojo.PretPojo;
import com.responses.AbstractResponse;
import com.responses.AuteurResponse;
import com.responses.OuvrageResponse;
import com.responses.PretResponse;

@WebService(name="bibliothek")
public class BibliothekService {

	ApplicationContext context;
	private AuteurResponse auteurResponse;
	private AuteurDao auteurDao;
	private AuteurPojo auteur;
	
	private OuvrageResponse ouvrageResponse;
	private OuvrageDao ouvrageDao;
	private OuvragePojo ouvragePojo;
	
	private PretResponse pretResponse;
	private PretDao pretDao;
	private PretPojo pretPojo;
	
	/* AUTEUR CRUD */
	//Create auteur
	@WebMethod
	public int createAuteur(AuteurPojo auteur) {
		initBeans();
		int id = 0;
		try {
			id = auteurDao.create(auteur);
		}catch(DaoException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	//Get all the auteurs
	@WebMethod
	public AuteurResponse allAuteurs() {
		initBeans();
		auteurResponse.setAuteurs(auteurDao.findAll());
		return auteurResponse;
	}
	
	//Get the specified auteur
	@WebMethod
	public AuteurResponse getAuteur(int id) {
		initBeans();
		try {
			auteur = auteurDao.findById(id);
			auteurResponse.getAuteurs().add(auteur);
		}catch(DaoException e) {
			auteurResponse.setErrorMessage(e.getMessage());
			auteurResponse.setErrorType(2);
		}catch(Exception e) {
			auteurResponse.setErrorMessage(e.getMessage());
			auteurResponse.setErrorType(1);
		}
		return auteurResponse;
	}
	
	//Update auteur
	@WebMethod
	public void updateAuteur(AuteurPojo auteur) {
		initBeans();
		try {
			auteurDao.update(auteur);
		}catch(DaoException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Update auteur
	@WebMethod
	public void deleteAuteur(AuteurPojo auteur) {
		initBeans();
		try {
			auteurDao.delete(auteur);
		}catch(DaoException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Get all the ouvrages
	@WebMethod
	public OuvrageResponse allOuvrages() {
		initBeans();
		ouvrageResponse.setOuvrages(ouvrageDao.findAll());
		return ouvrageResponse;
	}
	
	@WebMethod
	public PretResponse allPrets() {
		initBeans();
		pretResponse.setPrets(pretDao.findAll());
		return pretResponse;
	}
	
	private void initBeans() {
		context = new ClassPathXmlApplicationContext("/resources/spring.xml");
		
		auteurResponse = (AuteurResponse) context.getBean("auteurResponse");
		auteurDao = (AuteurDao) context.getBean("auteurDAO");
		auteur = (AuteurPojo) context.getBean("auteurPojo");
		
		ouvrageResponse = (OuvrageResponse) context.getBean("ouvrageResponse");
		ouvrageDao = (OuvrageDao) context.getBean("ouvrageDAO");
		ouvragePojo = (OuvragePojo) context.getBean("ouvragePojo");
		
		pretResponse = (PretResponse) context.getBean("pretResponse");
		pretDao = (PretDao) context.getBean("pretDAO");
		pretPojo = (PretPojo) context.getBean("pretPojo");
	}
}
