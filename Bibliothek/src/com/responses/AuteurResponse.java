package com.responses;

import java.util.ArrayList;
import java.util.List;

import com.DAO.pojo.AuteurPojo;

public class AuteurResponse extends AbstractResponse {
	private List<AuteurPojo> auteurs = new ArrayList<AuteurPojo>();
	
	public AuteurResponse() { }

	public List<AuteurPojo> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<AuteurPojo> auteurs) {
		this.auteurs = auteurs;
	}
}
