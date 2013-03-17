package com.adsandboards.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author arun
 * 
 */
@Entity(name = "tblAdboard")
public class AdBoard extends BaseModel {

	private String street;
	private float locationLatitude;
	private float locationLongitude;
	private String detailedLocation;
	private Integer contractDays;
	private Date contractStartDate;
	private Integer length;
	private Integer breadth;
	private String uom;
	private BoardType boardType;
	private City city;
	private Account account;

	public AdBoard() {
		// Empty Constructor
	}

	public AdBoard(String street, float locationLatitude,
			float locationLongitude, String detailedLocation,
			Integer contractDays, Date contractStartDate, Integer length,
			Integer breadth, String uom, BoardType boardType, City city,
			Account account) {
		super();
		this.street = street;
		this.locationLatitude = locationLatitude;
		this.locationLongitude = locationLongitude;
		this.detailedLocation = detailedLocation;
		this.contractDays = contractDays;
		this.contractStartDate = contractStartDate;
		this.length = length;
		this.breadth = breadth;
		this.uom = uom;
		this.boardType = boardType;
		this.city = city;
		this.account = account;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "adboardId")
	public Long getId() {
		return super.getId();
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "locLat")
	public float getLocationLatitude() {
		return locationLatitude;
	}

	public void setLocationLatitude(float locationLatitude) {
		this.locationLatitude = locationLatitude;
	}

	@Column(name = "locLong")
	public float getLocationLongitude() {
		return locationLongitude;
	}

	public void setLocationLongitude(float locationLongitude) {
		this.locationLongitude = locationLongitude;
	}

	public String getDetailedLocation() {
		return detailedLocation;
	}

	public void setDetailedLocation(String detailedLocation) {
		this.detailedLocation = detailedLocation;
	}

	@ManyToOne
	@JoinColumn(name = "accountId")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(nullable = true)
	public Integer getContractDays() {
		return contractDays;
	}

	public void setContractDays(Integer contractDays) {
		this.contractDays = contractDays;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@ManyToOne
	@JoinColumn(name = "cityId", nullable = false)
	public City getCity() {
		return city;
	}

	@ManyToOne
	@JoinColumn(name = "boardTypeId")
	public BoardType getBoardType() {
		return boardType;
	}

	public void setBoardType(BoardType boardType) {
		this.boardType = boardType;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getBreadth() {
		return breadth;
	}

	public void setBreadth(Integer breadth) {
		this.breadth = breadth;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

}
