package com.subrat.Condition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	private LinkedList<String> buffer;
	private int maxSize;
	private ReentrantLock lock;
	private Condition space;
	private Condition lines;
	private boolean pendingLines;
	
	
	public Buffer(int maxSize){
		
		this.maxSize=maxSize;
		buffer= new LinkedList<String>();
		lock= new ReentrantLock();
		lines= lock.newCondition();
		space= lock.newCondition();
		pendingLines=true;
	}

	public boolean isPendingLines() {
		return pendingLines|| buffer.size()>0;
	}

	public void setPendingLines(boolean pendingLines) {
		this.pendingLines = pendingLines;
	}

	//Added in the tail of the list.. 
	public void insert(String line){
		lock.lock();
		try{
			while(buffer.size()==maxSize){
				space.await();
			}
			buffer.offer(line);// offer-- add the element to the tail of the list
			System.out.printf("%s: Inserted Line : %d \n",Thread.currentThread().getName(),buffer.size());
			
			lines.signalAll();
			
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		finally{
			lock.unlock();
		}
	}
	
	//returns head of the list
	public String get(){
		
		String line= null;
		lock.lock();
		try{
			while((buffer.size()==0) &&(isPendingLines())){
				lines.await();
			}
			if(isPendingLines()){
				line= buffer.poll();// returns head of the list
				System.out.printf("%s : Line Readed: %d\n", Thread.currentThread().getName(),buffer.size());
				space.signalAll();
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		finally{
			lock.unlock();
		}
		return line;		
	}
	
	
}
