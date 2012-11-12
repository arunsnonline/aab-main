package com.adsandboards.web.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "tblRole")
public class Role extends BaseModel {

	private String description;
	private String name;
	private String permissions;
	private List<User> userList;

	public Role(String description, String name, String permissions,
			List<User> userList) {
		this.description = description;
		this.name = name;
		this.permissions = permissions;
		this.userList = userList;
	}

	public Role() {
		// TODO Auto-generated constructor stub
	}

	@ManyToMany(mappedBy = "roleList")
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roleId")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 64)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 5)
	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

}
