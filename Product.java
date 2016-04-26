package beans;

public class Product {

	private String	barcode;

	private String	productDescription;

	public Product(final String barcode, final String productDescription) {
		super();
		this.barcode = barcode;
		this.productDescription = productDescription;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(final String barcode) {
		this.barcode = barcode;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(final String productDescription) {
		this.productDescription = productDescription;
	}

}
