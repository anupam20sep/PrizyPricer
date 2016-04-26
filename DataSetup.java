package executors;

import java.util.ArrayList;
import java.util.List;

import beans.Product;

public class DataSetup {

	private static List<Product>	productTable	= null;

	private static DataSetup		instance		= null;

	private DataSetup() {
		// Exists only to defeat instantiation.
	}

	public static DataSetup getDataSetupInstance() {
		if (instance == null) {
			instance = new DataSetup();
			productTable = new ArrayList<Product>();

		}
		return instance;
	}

	public List<Product> instantiateProductTable() {

		productTable.add(new Product("abh453", "abc"));
		productTable.add(new Product("dfh5542", "agvf"));

		return productTable;
	}
}
