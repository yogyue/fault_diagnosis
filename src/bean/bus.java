/**
 * 
 */
package bean;

/**
 * @author shi
 *
 */
public class bus{
	private String uid;   //车牌号
	private String rid;  //线路ID
	private String tid;  //终端ID
	private String vin;  //vin码
	private String sim;  //sim手机号
	private String schoolid;  //学校id
	private String fid;  //随行人员id
	private String fid1;  //司机id
	private String rname;  //线路名称
	private String pname; //站点名
	private String date;
	private String time;
	private String auth;  //鉴权码
	
	private double lat;   //纬度
	private double lon;   //经度
	private double height;
	private double vel;
	private double dir;	  //方向
	
	public String getuid() {
		return uid;
	}
	public  void setuid(String uid) {
		this.uid = uid;
	}
	
	public String getrid() {
		return rid;
	}
	public void setrid(String rid) {
		this.rid = rid;
	}
	
	public String gettid() {
		return tid;
	}
	public void settid(String tid) {
		this.tid = tid;
	}
	
	public String getvin() {
		return vin;
	}
	public void setvin(String vin) {
		this.vin = vin;
	}
	
	public String getschoolid() {
		return schoolid;
	}
	public void setschoolid(String schoolid) {
		this.schoolid = schoolid;
	}
	
	public String getfid() {
		return fid;
	}
	public void setfid(String fid) {
		this.fid = fid;
	}
	
	public String getfid1() {
		return fid1;
	}
	public void setfid1(String fid1) {
		this.fid1 = fid1;
	}
	
	public String getsim() {
		return sim;
	}
	public void setsim(String sim) {
		this.sim = sim;
	}
	
	public String getrname() {
		return rname;
	}
	public void setrname(String rname) {
		this.rname = rname;
	}
	
	public String getpname() {
		return pname;
	}
	public void setpname(String pname) {
		this.pname = pname;
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
	
	public String getauth() {
		return auth;
	}
	public void setauth(String auth) {
		this.auth = auth;
	}
	
	public double getlat() {
		return lat;
	}
	
	public void setlat(double lat) {
		this.lat = lat;
	}
	
	public double getlon() {
		return lon;
	}
	
	public void setlon(double lon) {
		this.lon = lon;
	}
	
	public double getheight() {
		return height;
	}
	
	public void setheight(double height) {
		this.height = height;
	}
	
	public double getvel() {
		return vel;
	}
	public void setvel(double vel) {
		this.vel = vel;
	}
	
	public double getdir() {
		return dir;
	}
	public void setdir(double dir) {
		this.dir = dir;
	}
}
