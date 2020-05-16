package com.promotion.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.promotion.engine.SkuCart;
import com.promotion.engine.model.SkuOrder;

public class PromotionEngineTestCase {

	private SkuCart skuCart;

	@Before  
	public void setUp() throws Exception {  
		System.out.println("Start Test of PromotionEngine");  
	}  

	@SuppressWarnings("deprecation")
	@Test  
	public void scenarion1(){  
		// Scenario 1
		System.out.println("Scenario 1");  
		List<SkuOrder> skuOrderList1 = new ArrayList<SkuOrder>();
		skuOrderList1.add(new SkuOrder("A", 1));
		skuOrderList1.add(new SkuOrder("B", 1));
		skuOrderList1.add(new SkuOrder("C", 1));
		assertEquals(100.0, new SkuCart().calculateCart(skuOrderList1), 0.0);  
	}  

	@SuppressWarnings("deprecation")
	@Test  
	public void scenarion2(){  
		System.out.println("test case cube");  
		// Scenario 2
		List<SkuOrder> skuOrderList2 = new ArrayList<SkuOrder>();
		skuOrderList2.add(new SkuOrder("A", 5));
		skuOrderList2.add(new SkuOrder("B", 5));
		skuOrderList2.add(new SkuOrder("C", 1));
		assertEquals(370.0, new SkuCart().calculateCart(skuOrderList2), 0.0);
	}
	
	@SuppressWarnings("deprecation")
	@Test  
	public void scenarion3(){  
		// Scenario 3
		List<SkuOrder> skuOrderList3 = new ArrayList<SkuOrder>();
		skuOrderList3.add(new SkuOrder("A", 3));
		skuOrderList3.add(new SkuOrder("B", 5));
		skuOrderList3.add(new SkuOrder("C", 1));
		skuOrderList3.add(new SkuOrder("D", 1));
		assertEquals(280.0, new SkuCart().calculateCart(skuOrderList3), 0.0);
	}  
	@After  
	public void tearDown() throws Exception {  
		System.out.println("End Test of PromotionEngine");  
	}  

}
