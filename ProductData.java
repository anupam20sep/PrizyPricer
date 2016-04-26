/**
 * 
 */
package beans;

import java.util.List;

/**
 * 
 *
 */
public class ProductData {

	private Product				product;

	private List<WorkersData>	productPriceList;

	public ProductData(final Product product) {
		super();
		this.product = product;
	}

	public ProductData(final Product product, final List<WorkersData> productPriceList) {
		super();
		this.product = product;
		this.productPriceList = productPriceList;
	}

	public List<WorkersData> getProductPriceList() {
		return this.productPriceList;
	}

	public void setProductPriceList(final List<WorkersData> productPriceList) {
		this.productPriceList = productPriceList;
	}

}
