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
				} else if (combinedPromotional != null && !combinedPromotional.equals("") && !skuInventory.get(sku).getSku().equals(combinedPromotionalFlag)) {
					Optional<SkuOrder> combninedSkuOrder = orderedSkuList.stream().filter(s -> s.getSku().equals(combinedPromotional)).findFirst();
					int combinedSkuCount = 0;
					if (combninedSkuOrder.isPresent()) {
						combinedSkuCount = combninedSkuOrder.get().getQty();
					}
					
					if (combinedSkuCount < skuOrder.getQty()) {
						skuOrderPrice = (combinedSkuCount * skuInventory.get(sku).getCombinedPromotionPrice()) 
								+ ((skuOrder.getQty() - combinedSkuCount) * skuInventory.get(sku).getUnitPrice());
					} else if (combinedSkuCount > skuOrder.getQty()) {
						skuOrderPrice = (skuOrder.getQty() * skuInventory.get(sku).getCombinedPromotionPrice()) 
								+ ((skuOrder.getQty() - combinedSkuCount) * skuInventory.get(combninedSkuOrder.get()).getUnitPrice());
					} else {
						skuOrderPrice = skuOrder.getQty() * skuInventory.get(sku).getCombinedPromotionPrice();
					}
					
					combinedPromotionalFlag = combinedPromotional;
				} else if (promotionalQty == 0 && (combinedPromotional == null || combinedPromotional.equals(""))) {
					skuOrderPrice = skuOrder.getQty() * skuInventory.get(sku).getUnitPrice();
				}
			}
			
		}
			
		return skuOrderPrice;	
		
	}

}
