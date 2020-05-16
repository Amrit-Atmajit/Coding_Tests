package com.promotion.engine.dao;

import java.util.HashMap;
import java.util.Map;

import com.promotion.engine.model.Sku;

public class SkuInventory {
	private static SkuInventory skuInventory ; 
	private static Map<String, Sku> inventory;
	
	private SkuInventory() {
		inventory = new HashMap<String, Sku>();
		inventory.put("A", new Sku.SkuBuilder("A", 50).setPromotionalQty(3).setPromotionalPrice(130).build());
		inventory.put("B", new Sku.SkuBuilder("B", 30).setPromotionalQty(2).setPromotionalPrice(45).build());
		inventory.put("C", new Sku.SkuBuilder("C", 20).setCombinedPromotion("D").setCombinedPromotionPrice(30).build());
		inventory.put("D", new Sku.SkuBuilder("D", 15).setCombinedPromotion("C").setCombinedPromotionPrice(30).build());
	}

	public static SkuInventory getInventory() {
		if (null == inventory) {
			skuInventory = new SkuInventory();
		}
		return skuInventory;
	}
	
	public Map<String, Sku> getSkuInventory() {
		return inventory;
	}
}
