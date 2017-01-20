package bean;

public class Dtree {
	private String Bid;
	
	public String getBid(){
	return Bid;
	}
	public void setBid(String bid){
	this.Bid=bid;
	}
	
	private int id;
	private int Pid;
    private String Name;
	private String Url;
	private String Title;
    
    private String Target;
    private String Icon;
    private String IconOpen;
    private String Open;
   
    public int getId(){
	return id;
    }
    public void setId(int id){
	this.id=id;
    }
    public int getPid(){
	return Pid;
    }
    public void setPid(int pid){
	this.Pid=pid;
    }
    public void setName(String name){
	this.Name=name;
    }
    public String getName(){
	return Name;
    }
    public String getUrl(){
	return Url;
    }
    public void setUrl(String url){
	this.Url=url;
    }
    public String getTitle(){
	return Title;
    }
    public void setTitle(String title){
	this.Title=title;
    }
    public String getTarget(){
	return Target;
    }
    public void setTarget(String target){
	this.Target=target;
    }
    public String getIcon(){
	return Icon;
    }
    public void setIcon(String icon){
	this.Icon=icon;
    }
    public String getIconOpen(){
	return IconOpen;
    }
    public void setIconOpen(String iconOpen){
	this.IconOpen=iconOpen;
    }
    public String getOpen(){
	return Open;
    }
    public void setOpen(String open){
	this.Open=open;
    }

}

