package model;

public class Custom {
	private long user_id;
	private String passwd_Hash;
	private String user_Active;
	private String user_Name;
	private String user_Role;
	private long service_Id;
	private String mcb_Service;
	
	public long getService_Id() {
		return service_Id;
	}
	public void setService_Id(long service_Id) {
		this.service_Id = service_Id;
	}
	public String getMcb_Service() {
		return mcb_Service;
	}
	public void setMcb_Service(String mcb_Service) {
		this.mcb_Service = mcb_Service;
	}
	public String getUser_Active() {
		return user_Active;
	}
	public void setUser_Active(String user_Active) {
		this.user_Active = user_Active;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getUser_Role() {
		return user_Role;
	}
	public void setUser_Role(String user_Role) {
		this.user_Role = user_Role;
	}
	public long getUser_id() {
		return user_id;
	}
	public Custom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Custom(long user_id, String passwd_Hash, String user_Active,
			String user_Name, String user_Role, long service_Id,
			String mcb_Service) {
		super();
		this.user_id = user_id;
		this.passwd_Hash = passwd_Hash;
		this.user_Active = user_Active;
		this.user_Name = user_Name;
		this.user_Role = user_Role;
		this.service_Id = service_Id;
		this.mcb_Service = mcb_Service;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getPasswd_Hash() {
		return passwd_Hash;
	}
	public void setPasswd_Hash(String passwd_Hash) {
		this.passwd_Hash = passwd_Hash;
	}
	@Override
	public String toString() {
		return "Custom [user_id=" + user_id + ", passwd_Hash=" + passwd_Hash
				+ "]";
	}
	

}
