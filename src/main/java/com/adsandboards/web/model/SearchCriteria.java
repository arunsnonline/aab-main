package com.adsandboards.web.model;

public class SearchCriteria {

	private AdBoard adboard;
	private boolean available;

	public SearchCriteria() {

	}

	public AdBoard getAdboard() {
		return adboard;
	}

	public void setAdboard(AdBoard adboard) {
		this.adboard = adboard;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
