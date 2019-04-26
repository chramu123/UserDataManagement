package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MCB_USER_SERVICE_MAP_INFO database table.
 * 
 */
@Embeddable
public class McbUserServiceMapInfoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="USER_ID", insertable=false, updatable=false)
	private long userId;

	@Column(name="SERVICE_ID", insertable=false, updatable=false)
	private long serviceId;

	public McbUserServiceMapInfoPK() {
	}
	public long getUserId() {
		return this.userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getServiceId() {
		return this.serviceId;
	}
	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof McbUserServiceMapInfoPK)) {
			return false;
		}
		McbUserServiceMapInfoPK castOther = (McbUserServiceMapInfoPK)other;
		return 
			(this.userId == castOther.userId)
			&& (this.serviceId == castOther.serviceId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.userId ^ (this.userId >>> 32)));
		hash = hash * prime + ((int) (this.serviceId ^ (this.serviceId >>> 32)));
		
		return hash;
	}
	@Override
	public String toString() {
		return "McbUserServiceMapInfoPK [userId=" + userId + ", serviceId="
				+ serviceId + "]";
	}
	
}