package com.subrat.ForkJoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Product> product;
	private int first;
	private int last;
	private double increment;
	
	
	

	public Task(List<Product> product, int first, int last, double increment) {
		//super();
		this.product = product;
		this.first = first;
		this.last = last;
		this.increment = increment;
	}




	@Override
	protected void compute() {
		//System.out.println("Inside compute method...");
		
		if(last-first<10){
			updatePrices();
		}
		else{
			int middle= (first+last)/2;
			System.out.printf("Task: Pending Tasks: %s\n", getQueuedTaskCount());
			Task t1= new Task(product,first,middle+1,increment);
			Task t2= new Task(product, middle+1, last,increment);
			invokeAll(t1,t2);			
		}
	}
	
	private void updatePrices(){
		for (int i = first; i < last; i++) {
			
			Product prod= new Product();
			prod.setPrice(prod.getPrice()*(1+increment));
		}
	}

}
