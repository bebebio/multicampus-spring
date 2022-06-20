package vo;

public class ProductVo extends CommonVo {
	
	private int code;
	
	private String name;
	
	private int price;
	
	private String pictureurl;
	
	private String description;
	
	private String scName;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	@Override
	public String toString() {
		return "ProductVo [code=" + code + ", name=" + name + ", price=" + price + ", pictureurl=" + pictureurl
				+ ", description=" + description + ", scName=" + scName + "]";
	}
	
}
