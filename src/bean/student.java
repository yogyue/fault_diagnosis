/**
 * 
 */
package bean;

/**
 * @author shi
 *
 */
public class student {
	private String id;
	private String cardid;
	private String name;
	private String date;
	private String time;
	private String place;
	private String state;
	private double lat;
	private double lon;
	private double height;
	
	public String getid() {
		return id;
	}
	
	public void setid(String id) {
		this.id = id;
	}
	
	public void setcardid(String cardid) {
		this.cardid = cardid;
	}
	public String getcardid() {
		return cardid;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getname() {
		return name;
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
	public void setplace(String place) {
		this.place = place;
	}
	public String getplace() {
		return place;
	}
	public void setstate(String state) {
		this.state = state;
	}
	public String getstate() {
		return state;
	}
	public void setlat(double lat) {
		this.lat = lat;
	}
	public double getlat() {
		return lat;
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
}
