package com.subrat.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	
	private boolean freePrinters[];
	private Lock lockPrinters;
	private final Semaphore semaphore;
	
	public PrintQueue(){
		semaphore= new Semaphore(3);
		freePrinters= new boolean[3];
		for (int i = 0; i < freePrinters.length; i++) {
			freePrinters[i]=true;
			}
		lockPrinters= new ReentrantLock();
	}
	
	public void printJob(Object document){
		
			
			try{
			semaphore.acquire();
			int assignedPrinter= getPrinter();
			Long duration= (long) (Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+": PrintQueue: Printing a job during "+ (duration/1000)+ " seconds");
			//TimeUnit.SECONDS.sleep(duration);
			freePrinters[assignedPrinter]=true;
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
		finally{
		semaphore.release();
		}
			
	}

	private int getPrinter(){
		int ret=-1;
		try{
			lockPrinters.lock();
			for (int i = 0; i < freePrinters.length; i++) {
				if(freePrinters[i]){
					ret=i;
					freePrinters[i]=false;
					break;
				}
				
			}
			
		}
		catch(Exception ie){
			ie.printStackTrace();
		}
		finally{
			lockPrinters.unlock();
		}
		return ret;
	}
}
