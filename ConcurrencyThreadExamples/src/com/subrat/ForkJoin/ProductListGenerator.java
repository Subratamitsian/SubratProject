package com.subrat.ForkJoin;

import java.util.ArrayList;
import java.util.List;

public class ProductListGenerator {
	
	public List<Product> generate(int size){
		List<Product> ret= new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			
			Product prod= new Product();
			prod.setName("Product "+i);
			prod.setPrice(10);
			ret.add(prod);
		}
		
		return ret;
	}

}
