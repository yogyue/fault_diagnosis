package bean;

public class StuFee {
	private String sid;
	private String basicFee;
	private String addFee1;
	private String addFee2;   //基本费用
	private String addFee3;  //其他费用
	private String feeTime; //
	private String state;  //
	
	private String remarks;
	
	public String getsid() {
		return sid;
	}
	public void setsid(String sid) {
		this.sid = sid;
	}
	public String getbasicFee() {
		return basicFee;
	}
	public void setbasicFee(String basicFee) {
		this.basicFee = basicFee;
	}
	public String getaddFee1() {
		return addFee1;
	}
	public void setaddFee1(String addFee1) {
		this.addFee1 = addFee1;
	}
	public String getaddFee2() {
		return addFee2;
	}
	public void setaddFee2(String addFee2) {
		this.addFee2 = addFee2;
	}
	public String getaddFee3() {
		return addFee3;
	}
	public void setaddFee3(String addFee3) {
		this.addFee3 = addFee3;
	}
	public String getfeeTime() {
		return feeTime;
	}
	public void setfeeTime(String feeTime) {
		this.feeTime = feeTime;
	}
	public String getstate() {
		return state;
	}
	public void setstate(String state) {
		this.state = state;
	}
	public String getremarks() {
		return remarks;
	}
	public void setremarks(String remarks) {
		this.remarks = remarks;
	}

}
