package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MCB_SERVICES_INFO database table.
 * 
 */
@Entity
@Table(name="MCB_SERVICES_INFO")
@Cacheable
@NamedQuery(name="McbServicesInfo.findAll", query="SELECT s FROM McbServicesInfo s")
public class McbServicesInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SERVICE_ID")
	private long serviceId;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="MCB_SERVICE")
	private String mcbService;

	@Column(name="MCB_SERVICE_DESC")
	private String mcbServiceDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	//bi-directional many-to-one association to McbUserServiceMapInfo
	@OneToMany(mappedBy="mcbServicesInfo")
	private List<McbUserServiceMapInfo> mcbUserServiceMapInfos;

	public McbServicesInfo() {
	}

	public long getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getMcbService() {
		return this.mcbService;
	}

	public void setMcbService(String mcbService) {
		this.mcbService = mcbService;
	}

	public String getMcbServiceDesc() {
		return this.mcbServiceDesc;
	}

	public void setMcbServiceDesc(String mcbServiceDesc) {
		this.mcbServiceDesc = mcbServiceDesc;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<McbUserServiceMapInfo> getMcbUserServiceMapInfos() {
		return this.mcbUserServiceMapInfos;
	}

	public void setMcbUserServiceMapInfos(List<McbUserServiceMapInfo> mcbUserServiceMapInfos) {
		this.mcbUserServiceMapInfos = mcbUserServiceMapInfos;
	}

	public McbUserServiceMapInfo addMcbUserServiceMapInfo(McbUserServiceMapInfo mcbUserServiceMapInfo) {
		getMcbUserServiceMapInfos().add(mcbUserServiceMapInfo);
		mcbUserServiceMapInfo.setMcbServicesInfo(this);

		return mcbUserServiceMapInfo;
	}

	public McbUserServiceMapInfo removeMcbUserServiceMapInfo(McbUserServiceMapInfo mcbUserServiceMapInfo) {
		getMcbUserServiceMapInfos().remove(mcbUserServiceMapInfo);
		mcbUserServiceMapInfo.setMcbServicesInfo(null);

		return mcbUserServiceMapInfo;
	}

}