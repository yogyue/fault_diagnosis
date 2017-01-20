package bean;

/**
 * @author dujiexian
 *
 */
public class studentInfo {

	private String sid;
	private String sidCard;
	private String sName;
	private String sPName;
	private String sPTel1;
	private String sPTel2;
	private String sPTel3;
	private String schoolID;
	private String pid;
	private String stuPid;
	private String rid;
	public String getsid() {
		return sid;
	}
	
	public void setsid(String sid) {
		this.sid = sid;
	}
	
	public void setsidCard(String cardid) {
		this.sidCard = cardid;
	}
	public String getsidCard() {
		return sidCard;
	}
	public void setsName(String name) {
		this.sName = name;
	}
	public String getsName() {
		return sName;
	}
	public String getsPName() {
		return sPName;
	}
	public void setsPName(String spname) {
		this.sPName =spname;
	}
	public String getsPTel1() {
		return sPTel1;
	}
	public void setsPTel1(String sptel1) {
		this.sPTel1 = sptel1;
	}
	public String getsPTel2() {
		return sPTel2;
	}
	public void setsPTel2(String sptel2) {
		this.sPTel2 = sptel2;
	}
	public String getsPTel3() {
		return sPTel3;
	}
	public void setsPTel3(String sptel3) {
		this.sPTel3 = sptel3;
	}
	
	public void setschoolID(String schoolID) {
		this.schoolID = schoolID;
	}
	public String getschoolID() {
		return schoolID;
	}
	public void setpid(String pid) {
		this.pid = pid;
	}
	public String getpid() {
		return pid;
	}
	public void setstuPid(String stuPid) {
		this.stuPid = stuPid;
	}
	public String getstuPid() {
		return stuPid;
	}
	public String getrid() {
		return rid;
	}
	
	public void setrid(String rid) {
		this.rid = rid;
	}
	
}
