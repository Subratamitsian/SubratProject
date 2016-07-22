package com.subrat.LOCK;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

	private final Lock queueLock= new ReentrantLock(true);
	
	public void printJob(Object document){
		
			queueLock.lock();
			try{
			Long duration= (long) (Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+": PrintQueue: Printing a job during "+ (duration/1000)+ " seconds");
			Thread.sleep(10);
			
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
		finally{
		queueLock.unlock();
		}
			
		queueLock.lock();
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.println(Thread.currentThread().getName()
					+ ": PrintQueue: Printing a job during " + (duration/1000)
					+ " seconds");
			Thread.sleep(10);

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} finally {
			queueLock.unlock();
		}
	}
	
}
