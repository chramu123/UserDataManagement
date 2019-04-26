package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MCB_USER_INFO database table.
 * 
 */
@Entity
@Table(name="MCB_USER_INFO")
@Cacheable
@NamedQuery(name="McbUserInfo.findAll", query="SELECT m FROM McbUserInfo m")
public class McbUserInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private long userId;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="PASSWORD_HASH")
	private String passwordHash;

	@Column(name="ROLE_DESCRIPTION")
	private String roleDescription;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	@Column(name="USER_ACTIVE")
	private String userActive;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="USER_ROLE")
	private String userRole;

	//bi-directional many-to-one association to McbUserServiceMapInfo
	@OneToMany(mappedBy="mcbUserInfo")
	private List<McbUserServiceMapInfo> mcbUserServiceMapInfos;

	public McbUserInfo() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUserActive() {
		return this.userActive;
	}

	public void setUserActive(String userActive) {
		this.userActive = userActive;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public List<McbUserServiceMapInfo> getMcbUserServiceMapInfos() {
		return this.mcbUserServiceMapInfos;
	}

	public void setMcbUserServiceMapInfos(List<McbUserServiceMapInfo> mcbUserServiceMapInfos) {
		this.mcbUserServiceMapInfos = mcbUserServiceMapInfos;
	}

	public McbUserServiceMapInfo addMcbUserServiceMapInfo(McbUserServiceMapInfo mcbUserServiceMapInfo) {
		getMcbUserServiceMapInfos().add(mcbUserServiceMapInfo);
		mcbUserServiceMapInfo.setMcbUserInfo(this);

		return mcbUserServiceMapInfo;
	}

	public McbUserServiceMapInfo removeMcbUserServiceMapInfo(McbUserServiceMapInfo mcbUserServiceMapInfo) {
		getMcbUserServiceMapInfos().remove(mcbUserServiceMapInfo);
		mcbUserServiceMapInfo.setMcbUserInfo(null);

		return mcbUserServiceMapInfo;
	}

	@Override
	public String toString() {
		return "McbUserInfo [userId=" + userId + ", createdDate=" + createdDate
				+ ", passwordHash=" + passwordHash + ", roleDescription="
				+ roleDescription + ", updatedDate=" + updatedDate
				+ ", userActive=" + userActive + ", userName=" + userName
				+ ", userRole=" + userRole + ", mcbUserServiceMapInfos="
				+ mcbUserServiceMapInfos + "]";
	}

	

}