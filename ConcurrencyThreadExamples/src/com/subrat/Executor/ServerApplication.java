package com.subrat.Executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ServerApplication {

	private ThreadPoolExecutor executor;
	
	public ServerApplication(){
		//executor= (ThreadPoolExecutor) Executors.newCachedThreadPool();
		executor= (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
	}
	
	public void executeTask(Task task){
		System.out.printf("Server: A new task has been arrived \n");
		executor.execute(task);
		System.out.printf("Server: Pool Size %d\n",executor.getPoolSize());
		
		System.out.printf("Server: Active count %d\n",executor.getActiveCount());
		System.out.println("Server: Task count:- "+ executor.getTaskCount());
		System.out.printf("Server: Completed task %d\n",executor.getCompletedTaskCount());
		
		
		
	}
	
	public void endTask(){
		executor.shutdown();
	}
	
}
