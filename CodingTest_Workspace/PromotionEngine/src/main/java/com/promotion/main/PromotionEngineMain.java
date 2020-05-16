package com.promotion.main;

import java.util.ArrayList;
import java.util.List;

import com.promotion.engine.SkuCart;
import com.promotion.engine.model.SkuOrder;

public class PromotionEngineMain {

	public static void main(String[] args) {
		
		// Scenario 1
		List<SkuOrder> skuOrderList1 = new ArrayList<SkuOrder>();
		skuOrderList1.add(new SkuOrder("A", 1));
		skuOrderList1.add(new SkuOrder("B", 1));
		skuOrderList1.add(new SkuOrder("C", 1));
		System.out.println(new SkuCart().calculateCart(skuOrderList1));

		// Scenario 2
		List<SkuOrder> skuOrderList2 = new ArrayList<SkuOrder>();
		skuOrderList2.add(new SkuOrder("A", 5));
		skuOrderList2.add(new SkuOrder("B", 5));
		skuOrderList2.add(new SkuOrder("C", 1));
		System.out.println(new SkuCart().calculateCart(skuOrderList2));

		// Scenario 3
		List<SkuOrder> skuOrderList3 = new ArrayList<SkuOrder>();
		skuOrderList3.add(new SkuOrder("A", 3));
		skuOrderList3.add(new SkuOrder("B", 5));
		skuOrderList3.add(new SkuOrder("C", 1));
		skuOrderList3.add(new SkuOrder("D", 1));
		System.out.println(new SkuCart().calculateCart(skuOrderList3));
	}

}
