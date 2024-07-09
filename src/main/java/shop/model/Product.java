package shop.model;

public class Product {
	private int prodId;
    private String prodName;
    private String prodDesc;
    private double prodPrice;
    private String prodImg;
	

	public int getProdId() {
		return prodId;
	}


	public void setProdId(int prodId) {
		this.prodId = prodId;
	}


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public String getProdDesc() {
		return prodDesc;
	}


	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}


	public double getProdPrice() {
		return prodPrice;
	}


	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}


	public String getProdImg() {
		return prodImg;
	}


	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}


	public Product(int prodId, String prodName, String prodDesc, double prodPrice, String prodImg) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.prodPrice = prodPrice;
		this.prodImg = prodImg;
	}


	public Product() {}
}


