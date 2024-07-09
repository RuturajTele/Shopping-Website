package shop.model;

public class Register {
	
	private String emailId;
	private String custName;
	private String userName;
	private String mobNo;
	private String password;
	
	public Register(String emailId, String custName, String userName, String mobNo, String password) {
		super();
		this.emailId = emailId;
		this.custName = custName;
		this.userName = userName;
		this.mobNo = mobNo;
		this.password = password;
	
	}
	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getMobNo() {
		return mobNo;
	}


	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	


	
	

}
