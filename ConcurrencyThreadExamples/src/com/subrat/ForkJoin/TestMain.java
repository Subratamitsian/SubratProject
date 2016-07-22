package com.subrat.ForkJoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class TestMain {
	public static void main(String[] args) {
		
		ProductListGenerator generator= new ProductListGenerator();
		List<Product> product=generator.generate(20);
		
		Task task= new Task(product, 0, product.size(),.20);
		
		ForkJoinPool pool= new ForkJoinPool();
		pool.execute(task);
		
		do{
			System.out.println("Main: pool size= "+pool.getPoolSize());
			System.out.println("Main: Theread count= "+pool.getActiveThreadCount());
			System.out.println("Main: Theread Steal count= "+pool.getStealCount());
			System.out.println("Main: Theread Parallelism= "+pool.getParallelism());
			try{
				TimeUnit.SECONDS.sleep(1);
			}
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
		while(!task.isDone());
		
		pool.shutdown();
		
		if(task.isCompletedNormally()){
			System.out.println("Task completed Normally");
		}
				
		for (int i = 0; i < product.size(); i++) {
			Product prod= new Product();
			if(prod.getPrice() !=12){
				System.out.println("Product Name - Price:- "+prod.getName()+ "- "+ prod.getPrice());
			}
			
		}
		System.out.println("*************End of program**************");
	}

}
