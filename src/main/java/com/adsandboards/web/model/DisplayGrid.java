package com.adsandboards.web.model;

import java.util.List;

public class DisplayGrid<T> {

	private Long iTotalRecords;
	private Long iTotalDisplayRecords;
	private List<T> aaData;

	public DisplayGrid(Long iTotalRecords, Long iTotalDisplayRecords,
			List<T> aaData) {
		super();
		this.iTotalRecords = iTotalRecords;
		this.iTotalDisplayRecords = iTotalDisplayRecords;
		this.aaData = aaData;
	}

	public Long getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(Long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public Long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public List<T> getAaData() {
		return aaData;
	}

	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}

}
