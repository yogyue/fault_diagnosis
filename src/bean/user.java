package bean;

public class user {
	private String userID;
	private String userName;
	private String UserRole;
	private String userPwd;
	private String referID;
        private String userCaptcha;
        private String userCaptchaPic;

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getReferID() {
		return referID;
	}
	public void setReferID(String referID) {
		this.referID = referID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setUserRole(String UserRole) {
		this.UserRole = UserRole;
	}
	public String getUserPwd() {
    	return userPwd;
    	}
    	public void setUserPwd(String userPwd) {
    		this.userPwd = userPwd;
    	}
	
    
	
    public String getUserCaptcha(){
    	return userCaptcha;
    }
    
	public void setUserCaptcha(String userCaptcha){
	this.userCaptcha=userCaptcha;
    }
    public String getUserCaptchaPic(){
	return userCaptchaPic;
    }
    public void setUserCaptchaPic(String usercaptchapic){
	this.userCaptchaPic=usercaptchapic;
    }
}

