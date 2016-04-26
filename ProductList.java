/**
 * 
 */
package beans;

/**
 * @author 703153941
 *
 */
public class ProductList {

	private String	productBarcode;

	private String	productDescription;

	private double	averagePrice;

	private double	lowestPrice;

	private double	highestprice;

	private double	idealPrice;

	public ProductList(final String productBarcode, final String productDescription, final double averagePrice, final double lowestPrice,
			final double highestprice, final double idealPrice) {
		super();
		this.productBarcode = productBarcode;
		this.productDescription = productDescription;
		this.averagePrice = averagePrice;
		this.lowestPrice = lowestPrice;
		this.highestprice = highestprice;
		this.idealPrice = idealPrice;
	}

	public String getProductBarcode() {
		return this.productBarcode;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public double getAveragePrice() {
		return this.averagePrice;
	}

	public double getLowestPrice() {
		return this.lowestPrice;
	}

	public double getHighestprice() {
		return this.highestprice;
	}

	public double getIdealPrice() {
		return this.idealPrice;
	}

}
