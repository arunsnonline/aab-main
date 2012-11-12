package com.adsandboards.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tblBoardType")
public class BoardType extends BaseModel {

	private String name;

	public BoardType() {
		// Empty Constructor
	}

	public BoardType(String name) {
		this.name = name;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "boardTypeId")
	public Long getId() {
		return super.getId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
