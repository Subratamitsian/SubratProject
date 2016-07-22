package com.subrat.Semaphore;

public class Job implements Runnable {
	
	private PrintQueue printQueue;
	
	public Job(PrintQueue queue){
		this.printQueue=queue;
	}
	@Override
	public void run(){
		System.out.printf("%s: going to print a document \n", Thread.currentThread().getName());
		printQueue.printJob(new Object());
		System.out.printf("%s: Document has been printed \n", Thread.currentThread().getName());
		
	}

}
