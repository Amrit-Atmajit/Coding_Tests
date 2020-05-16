package com.promotion.engine.model;

public class Sku {

	private String sku;
	private double unitPrice;
	private int promotionalQty;
	private double promotionalPrice;
	private String combinedPromotion = "";
	private double combinedPromotionPrice;

	public String getSku() {
		return sku;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public int getPromotionalQty() {
		return promotionalQty;
	}

	public double getPromotionalPrice() {
		return promotionalPrice;
	}

	public String getCombinedPromotion() {
		return combinedPromotion;
	}

	public double getCombinedPromotionPrice() {
		return combinedPromotionPrice;
	}

	@Override
	public String toString() {
		return "SkuGeneral [sku=" + sku + ", unitPrice=" + unitPrice + "]";
	}
	
	private Sku(SkuBuilder skuBuilder) {
		this.sku = skuBuilder.sku;
		this.unitPrice = skuBuilder.unitPrice;
		this.promotionalQty= skuBuilder.promotionalQty ;
		this.promotionalPrice = skuBuilder.promotionalPrice;
		this.combinedPromotion = skuBuilder.combinedPromotion;
		this.combinedPromotionPrice= skuBuilder.combinedPromotionPrice;
	}


	//Builder Class
	public static class SkuBuilder {

		// required parameters
		private String sku;
		private double unitPrice;

		// optional parameters
		private int promotionalQty;
		private double promotionalPrice;
		private String combinedPromotion;
		private double combinedPromotionPrice;

		public SkuBuilder(String sku,  double unitPrice) {
			this.sku = sku;
			this.unitPrice = unitPrice;
		}

		public SkuBuilder setPromotionalQty(int promotionalQty) {
			this.promotionalQty = promotionalQty;
			return this;
		}

		public SkuBuilder setPromotionalPrice(double promotionalPrice) {
			this.promotionalPrice = promotionalPrice;
			return this;
		}
		
		public SkuBuilder setCombinedPromotion(String combinedPromotion) {
			this.combinedPromotion = combinedPromotion;
			return this;
		}
		
		public SkuBuilder setCombinedPromotionPrice(double combinedPromotionPrice) {
			this.combinedPromotionPrice = combinedPromotionPrice;
			return this;
		}

		public Sku build(){
			return new Sku(this);
		}

	}
}
