package com.adsandboards.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "tblAccount")
public class Account extends BaseModel {

	private String accountName;
	private String phone;
	private String fax;
	private String email;
	private String websiteUrl;
	private String address;
	private String contactPerson;
	private String contactPersonMobile;
	private Organization organization;

	public Account(String accountName, String phone, String fax, String email,
			String websiteUrl, String address, String contactPerson,
			String contactPersonMobile) {
		this.accountName = accountName;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
		this.websiteUrl = websiteUrl;
		this.address = address;
		this.contactPerson = contactPerson;
		this.contactPersonMobile = contactPersonMobile;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accountId")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Column(length = 20)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 20)
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(length = 100, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 100)
	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	@Column(length = 150)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "contactPerson")
	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Column(name = "contactPersonMobile")
	public String getContactPersonMobile() {
		return contactPersonMobile;
	}

	public void setContactPersonMobile(String contactPersonMobile) {
		this.contactPersonMobile = contactPersonMobile;
	}

	@ManyToOne
	@JoinColumn(name = "organizationId")
	public Organization getOrganization() {
		if (organization == null) {
			organization = new Organization();
		}
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}
