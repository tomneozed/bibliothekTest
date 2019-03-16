package com.responses;

import java.util.ArrayList;
import java.util.List;

import com.DAO.pojo.OuvragePojo;

public class OuvrageResponse extends AbstractResponse {
	
	private List<OuvragePojo> ouvrages = new ArrayList<OuvragePojo>();

	public List<OuvragePojo> getOuvrages() {
		return ouvrages;
	}

	public void setOuvrages(List<OuvragePojo> ouvrages) {
		this.ouvrages = ouvrages;
	}
}
