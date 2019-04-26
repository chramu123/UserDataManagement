package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the MCB_USER_SERVICE_MAP_INFO database table.
 * 
 */
@Entity
@Table(name="MCB_USER_SERVICE_MAP_INFO")
@Cacheable
@NamedQuery(name="McbUserServiceMapInfo.findAll", query="SELECT mi FROM McbUserServiceMapInfo mi")
public class McbUserServiceMapInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private McbUserServiceMapInfoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="HAS_ACCESS")
	private String hasAccess;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	//bi-directional many-to-one association to McbServicesInfo
	@ManyToOne
	@JoinColumn(name="SERVICE_ID")
	private McbServicesInfo mcbServicesInfo;

	//bi-directional many-to-one association to McbUserInfo
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private McbUserInfo mcbUserInfo;

	public McbUserServiceMapInfo() {
	}

	public McbUserServiceMapInfoPK getId() {
		return this.id;
	}

	public void setId(McbUserServiceMapInfoPK id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getHasAccess() {
		return this.hasAccess;
	}

	public void setHasAccess(String hasAccess) {
		this.hasAccess = hasAccess;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public McbServicesInfo getMcbServicesInfo() {
		return this.mcbServicesInfo;
	}

	public void setMcbServicesInfo(McbServicesInfo mcbServicesInfo) {
		this.mcbServicesInfo = mcbServicesInfo;
	}

	public McbUserInfo getMcbUserInfo() {
		return this.mcbUserInfo;
	}

	public void setMcbUserInfo(McbUserInfo mcbUserInfo) {
		this.mcbUserInfo = mcbUserInfo;
	}

	@Override
	public String toString() {
		return "McbUserServiceMapInfo [id=" + id + ", createdDate="
				+ createdDate + ", hasAccess=" + hasAccess + ", updatedDate="
				+ updatedDate + ", mcbServicesInfo=" + mcbServicesInfo
				+ ", mcbUserInfo=" + mcbUserInfo + "]";
	}

}