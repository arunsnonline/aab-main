package com.adsandboards.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tblOrganization")
public class Organization extends BaseModel {

	private String organizationName;

	public Organization(String organizationName) {
		this.organizationName = organizationName;
	}

	public Organization() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = " organizationId")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 100)
	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
}
