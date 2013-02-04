package com.adsandboards.web.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "tblAppUser")
public class User extends BaseModel {

	private String username;
	private String password;
	private String address;
	private String city;
	private String country;
	private String postal_code;
	private String province;
	private String email;
	private String first_name;
	private String last_name;
	private String password_hint;
	private String website;
	private boolean account_expired;
	private boolean account_locked;
	private boolean credentials_expired;
	private boolean account_enabled;
	private int version;
	private Organization organization;
	private Account account;
	private List<Role> roleList;

	public User(String username, String password, String address, String city,
			String country, String postal_code, String province, String email,
			String first_name, String last_name, String password_hint,
			String website, boolean account_expired, boolean account_locked,
			boolean credentials_expired, boolean account_enabled, int version,
			Organization organization, Account account, List<Role> roleList) {
		this.username = username;
		this.password = password;
		this.address = address;
		this.city = city;
		this.country = country;
		this.postal_code = postal_code;
		this.province = province;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password_hint = password_hint;
		this.website = website;
		this.account_expired = account_expired;
		this.account_locked = account_locked;
		this.credentials_expired = credentials_expired;
		this.account_enabled = account_enabled;
		this.version = version;
		this.organization = organization;
		this.account = account;
		this.roleList = roleList;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	@ManyToMany
	@JoinTable(name = "tblUserRole", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "roleId") })
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 150)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(length = 50)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(length = 50)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(length = 15)
	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword_hint() {
		return password_hint;
	}

	public void setPassword_hint(String password_hint) {
		this.password_hint = password_hint;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public boolean isAccount_expired() {
		return account_expired;
	}

	public void setAccount_expired(boolean account_expired) {
		this.account_expired = account_expired;
	}

	public boolean isAccount_locked() {
		return account_locked;
	}

	public void setAccount_locked(boolean account_locked) {
		this.account_locked = account_locked;
	}

	public boolean isCredentials_expired() {
		return credentials_expired;
	}

	public void setCredentials_expired(boolean credentials_expired) {
		this.credentials_expired = credentials_expired;
	}

	public boolean isAccount_enabled() {
		return account_enabled;
	}

	public void setAccount_enabled(boolean account_enabled) {
		this.account_enabled = account_enabled;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@ManyToOne
	@JoinColumn(name = "organizationId")
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@ManyToOne
	@JoinColumn(name = "accountId")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
