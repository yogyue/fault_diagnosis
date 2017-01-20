package bean;

public class fee {
	private String name;
	private String date;
	private String time;
	private double fee1;   //基本费用
	private double fee2;  //其他费用
	private String state; //是否欠费
	private String remark;  //备注
	
	private String id;
	
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getdate() {
		return date;
	}
	public void setdate(String date) {
		this.date = date;
	}
	public String gettime() {
		return time;
	}
	public void settime(String time) {
		this.time = time;
	}
	public double getfee1() {
		return fee1;
	}
	public void setfee1(double fee1) {
		this.fee1 = fee1;
	}
	public double getfee2() {
		return fee2;
	}
	public void setfee2(double fee2) {
		this.fee2 = fee2;
	}
	public String getstate() {
		return state;
	}
	public void setstate(String state) {
		this.state = state;
	}
	public String getremark() {
		return remark;
	}
	public void setremark(String remark) {
		this.remark = remark;
	}

}
