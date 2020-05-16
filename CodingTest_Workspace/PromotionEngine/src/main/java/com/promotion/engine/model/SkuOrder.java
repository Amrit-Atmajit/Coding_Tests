package com.promotion.engine.model;

public class SkuOrder {

	private String sku;
	private int qty;
	
	public SkuOrder(String sku, int qty) {
		super();
		this.sku = sku;
		this.qty = qty;
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "SkuOrderLine [sku=" + sku + ", qty=" + qty + "]";
	}
	
}
