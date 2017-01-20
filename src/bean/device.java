package bean;

public class device {
	
	private String TagID;
	private String deviceName;
	private String factory;
	private String productID;
	private String producerID;
	private String producerName;
	private String devicememo;
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getTagID() {
		return TagID;
	}
	public void setTagID(String tagID) {
		this.TagID = tagID;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getProducerID() {
		return producerID;
	}
	public void setProducerID(String producerID) {
		this.producerID = producerID;
	}
	public String getProducerName() {
		return producerName;
	}
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}
	public String getDevicememo() {
		return devicememo;
	}
	public void setDevicememo(String devicememo) {
		this.devicememo = devicememo;
	}
	
}
