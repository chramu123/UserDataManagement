package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the MCB_USER_MANAGEMENT database table.
 * 
 */
@Entity
@Table(name="MCB_USER_MANAGEMENT")
@Cacheable
@NamedQuery(name="McbUserManagement.findAll", query="SELECT m FROM McbUserManagement m")
public class McbUserManagement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_NAME")
	private String userName;

	private String active;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	private String description;

	@Column(name="PASSWORD_HASH")
	private String passwordHash;

	@Column(name="\"ROLE\"")
	private String role;

	@Column(name="SERVICE_CARD_INFO")
	private String serviceCardInfo;

	@Column(name="SERVICE_CARD_LIST")
	private String serviceCardList;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	public McbUserManagement() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getServiceCardInfo() {
		return this.serviceCardInfo;
	}

	public void setServiceCardInfo(String serviceCardInfo) {
		this.serviceCardInfo = serviceCardInfo;
	}

	public String getServiceCardList() {
		return this.serviceCardList;
	}

	public void setServiceCardList(String serviceCardList) {
		this.serviceCardList = serviceCardList;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "McbUserManagement [userName=" + userName + ", active=" + active
				+ ", createdDate=" + createdDate + ", description="
				+ description + ", passwordHash=" + passwordHash + ", role="
				+ role + ", serviceCardInfo=" + serviceCardInfo
				+ ", serviceCardList=" + serviceCardList + ", updatedDate="
				+ updatedDate + "]";
	}

}