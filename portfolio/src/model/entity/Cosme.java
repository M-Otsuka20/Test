package model.entity;

public class Cosme {
	String code;
	String name;
	int price;
	String category;
	int stock;
	String maker;
	String makercode;

	public Cosme() {
		super();
	}

	public Cosme(String makercode) {
		super();
		this.makercode = makercode;
	}

	public Cosme(String code, String name, int price, String category, int stock, String maker, String makercode) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.category = category;
		this.stock = stock;
		this.maker = maker;
		this.makercode = makercode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getMakercode() {
		return makercode;
	}

	public void setMakercode(String makercode) {
		this.makercode = makercode;
	}

}
