package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import beans.Product;
import beans.ProductData;
import beans.WorkersData;

public class ProductLoader {

	public synchronized static Map<String, ProductData> loadProduct(final String barcode, final int workerID, final int storeID,
			final double productPrice, final String notes, final List<Product> productTable, final Map<String, ProductData> productMap)
			throws Exception {

		// Map<String, ProductData> productMap = new HashMap<String,
		// ProductData>();
		Product pd = null;
		for (Product prod : productTable) {
			if (prod.getBarcode().equals(barcode)) {
				pd = prod;
				break;
			} else {
				throw new Exception("Product not found in table");
			}
		}

		WorkersData wd = new WorkersData(workerID, storeID, productPrice, notes);
		if (productMap.containsKey(barcode)) {

			ProductData pData = productMap.get(barcode);
			List<WorkersData> temp = pData.getProductPriceList();
			temp.add(wd);
			pData.setProductPriceList(temp);
		} else {

			List<WorkersData> temp = new ArrayList<WorkersData>();
			temp.add(wd);
			productMap.put(barcode, new ProductData(pd, temp));
		}
		return productMap;
	}

}
