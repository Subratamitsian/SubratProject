package com.subrat.LOCK;

public class Job implements Runnable {
	
	private PrintQueue printQueue;
	
	public Job(PrintQueue queue){
		this.printQueue=queue;
	}
	@Override
	public void run(){
		System.err.printf("%s: going to print a document \n", Thread.currentThread().getName());
		printQueue.printJob(new Object());
		System.err.printf("%s: Document has been printed \n", Thread.currentThread().getName());
		
	}

}
