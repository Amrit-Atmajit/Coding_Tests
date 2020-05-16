package com.promotion.engine;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.promotion.engine.dao.SkuInventory;
import com.promotion.engine.model.Sku;
import com.promotion.engine.model.SkuOrder;

public class SkuCart {
	String combinedPromotionalFlag = "";
	private double totalPrice;
	private Map<String, Sku> skuInventory = SkuInventory.getInventory().getSkuInventory();
	private List<SkuOrder> orderedSkuList;
	
	public double calculateCart(List<SkuOrder> orderedSkuList) {
		this.orderedSkuList = orderedSkuList;
		for (SkuOrder skuOrder : orderedSkuList) {
			totalPrice += calculateSku(skuOrder);
		}
		return totalPrice;
	}

	private double calculateSku(SkuOrder skuOrder) {
		double skuOrderPrice = 0;
		String sku = skuOrder.getSku();
		
		if (sku != null && skuInventory.get(sku) != null && sku.equals(skuInventory.get(sku).getSku())) {
			int promotionalQty = skuInventory.get(sku).getPromotionalQty();
			String combinedPromotional = skuInventory.get(sku).getCombinedPromotion();
			if (skuOrder.getQty() > 0) {
				if (promotionalQty > 0) {
					int promCount = skuOrder.getQty() / promotionalQty;
					int genCount = skuOrder.getQty() % promotionalQty;
					skuOrderPrice = (promCount * skuInventory.get(sku).getPromotionalPrice()) + (genCount * skuInventory.get(sku).getUnitPrice());
				} 
			}
			
		}
			
		return skuOrderPrice;	
		
	}

}
