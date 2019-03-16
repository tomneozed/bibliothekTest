package com.responses;

import java.util.ArrayList;
import java.util.List;

import com.DAO.pojo.PretPojo;

public class PretResponse extends AbstractResponse {
	
	private List<PretPojo> prets = new ArrayList<PretPojo>();
	
	public PretResponse() {
		super();
	}

	public PretResponse(List<PretPojo> prets) {
		super();
		this.prets = prets;
	}

	public List<PretPojo> getPrets() {
		return prets;
	}

	public void setPrets(List<PretPojo> prets) {
		this.prets = prets;
	}
}
