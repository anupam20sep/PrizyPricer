package executors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import beans.Product;
import beans.ProductData;
import beans.ProductList;
import beans.WorkersData;

public class Execution {
	public static Map<String, ProductData>	pm	= new HashMap<String, ProductData>();

	public static List<Product>				productTable;

	public static void main(final String args[]) throws Exception {

		productTable = DataSetup.getDataSetupInstance().instantiateProductTable();
		run("abh453", 1, 13, 102.89, "ABC");
		run("abh453", 2, 14, 101.52, "cbd");
		run("abh453", 3, 15, 104.69, "ABC");
		run("abh453", 4, 16, 103.75, "cbd");
		run("abh453", 5, 17, 100.20, "ABC");
		run("abh453", 6, 18, 105.67, "cbd");
		run("abh453", 7, 19, 101.75, "ABC");
		run("abh453", 8, 20, 103.89, "cbd");
		run("abh453", 9, 21, 100.89, "ABC");
		run("abh453", 10, 2, 99.52, "cbd");

		// prepare list by administrator

		List<ProductList> pl = prepareProductList(pm, "abh453");

		for (ProductList productList : pl) {
			System.out.println(productList.getProductBarcode());
			System.out.println(productList.getProductDescription());
			System.out.println(productList.getAveragePrice());
			System.out.println(productList.getLowestPrice());
			System.out.println(productList.getHighestprice());
			System.out.println(productList.getIdealPrice());
		}

	}

	public static void run(final String barcode, final int workerID, final int storeID, final double productPrice, final String notes)
			throws Exception {

		// instantiate product table

		// prepare product data fr each product from table

		// worker loads the product

		// find the product from prodcuct table with barcode abh453

		pm = ProductLoader.loadProduct(barcode, workerID, storeID, productPrice, notes, productTable, pm);

	}

	public static List<ProductList> prepareProductList(final Map<String, ProductData> pm, final String barcode) {
		double idealPrice = 0.0;
		double lowestPrice = 0.0;
		double highestPrice = 0.0;
		double avgPrice = 0.0;

		List<ProductList> pList = new ArrayList<ProductList>();
		Iterator it = pm.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, ProductData> pair = (Map.Entry) it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());

			String code = pair.getKey();
			ProductData pd = pair.getValue();

			if (barcode.equals(code)) {
				List<Double> priceList = new ArrayList<Double>();

				for (WorkersData p : pd.getProductPriceList()) {
					priceList.add(p.getProductPrice());
				}
				idealPrice = PluginExecution.getIdealPrice(priceList);
				Collections.sort(priceList);

				lowestPrice = priceList.get(0);
				highestPrice = priceList.get(priceList.size() - 1);
				double sum = 0.0;
				for (Double p : priceList) {
					sum += p;
				}

				avgPrice = sum / priceList.size();
				String description = "";
				for (Product prod : productTable) {
					if (prod.getBarcode().equals(barcode)) {
						description = prod.getProductDescription();
						break;
					}
				}
				ProductList pl = new ProductList(barcode, description, avgPrice, lowestPrice, highestPrice, idealPrice);

				pList.add(pl);
			}

		}
		return pList;

	}
}
