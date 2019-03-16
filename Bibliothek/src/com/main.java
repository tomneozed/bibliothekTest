package com;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;

import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.DAO.exceptions.DaoException;
import com.DAO.impl.AuteurDaoImpl;
import com.DAO.interfaces.AuteurDao;
import com.DAO.interfaces.PretDao;
import com.DAO.pojo.AuteurPojo;
import com.responses.AbstractResponse;
import com.responses.AuteurResponse;
import com.responses.PretResponse;

public class main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("/resources/spring.xml");
		AuteurDao auteurDao = (AuteurDao) context.getBean("auteurDAO");
		
		List<AuteurPojo> auteurs = new ArrayList<AuteurPojo>();
		
		auteurs = auteurDao.findAll();
		
		System.out.println(auteurs);
		
		AuteurPojo auteur = (AuteurPojo) context.getBean("auteurPojo");
		
		AuteurResponse AR = (AuteurResponse) context.getBean("auteurResponse");
		
		PretResponse PR = (PretResponse) context.getBean("pretResponse");
		
		PretDao pretDao = (PretDao) context.getBean("pretDAO");
		
		//PR.setPrets(pretDao.findAll());
		
		try {
			PR.setPrets(pretDao.findAll());
		}catch(DaoException e) {
			AR.setErrorMessage(e.getMessage());
		}
		
//		try {
//			auteur = auteurDao.findById(0);
//			AR.getAuteurs().add(auteur);
//		}catch(DaoException e) {
//			AR.setErrorMessage(e.getMessage());
//		}
		
		System.out.println(PR.getPrets());
	}
}
