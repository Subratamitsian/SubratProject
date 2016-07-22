package com.subrat.Executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableClient {
	
	public static void main(String[] args) {
		
		Callable<String> callableTask= new CallableTask();
		
		ExecutorService executor= Executors.newFixedThreadPool(3);
		Future<String> future= executor.submit(callableTask);
		boolean listen= true;
		
		while(listen){
			if(future.isDone()){
				String result;
				try{
					result= future.get();
					listen= false;
					System.out.println("Result is "+result);
				}
				catch(InterruptedException | ExecutionException e){
					
				}
			}
		}
	}

}
