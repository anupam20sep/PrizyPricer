package beans;

public class WorkersData {

	private int		workerID;

	private int		StoreID;

	private double	productPrice;

	private String	notes;

	public WorkersData(final int workerID, final int storeID, final double productPrice, final String notes) {
		super();
		this.StoreID = storeID;
		this.productPrice = productPrice;
		this.notes = notes;
		this.workerID = workerID;
	}

	public int getWorkerID() {
		return this.workerID;
	}

	public void setWorkerID(final int workerID) {
		this.workerID = this.workerID;
	}

	public int getStoreID() {
		return this.StoreID;
	}

	public void setStoreID(final int storeID) {
		this.StoreID = storeID;
	}

	public double getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(final double productPrice) {
		this.productPrice = productPrice;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(final String notes) {
		this.notes = notes;
	}

}
