package jxau.spms.common.vo;

public class PassModification {

	private String account;
	private int role;
	private String password;
	private String realPass;
	private String modifyPass;
	private String confirmPass;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRealPass() {
		return realPass;
	}
	public void setRealPass(String realPass) {
		this.realPass = realPass;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getModifyPass() {
		return modifyPass;
	}
	public void setModifyPass(String modifyPass) {
		this.modifyPass = modifyPass;
	}
	public String getConfirmPass() {
		return confirmPass;
	}
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
	
}
