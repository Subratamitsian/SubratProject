package com.subrat.Condition;

import java.util.Random;

public class Consumer implements Runnable {
	private Buffer buffer;
	
	public Consumer(Buffer buffer){
		this.buffer=buffer;
	}

	@Override
	public void run() {
		
		while(buffer.isPendingLines()){
			String line= buffer.get();
			processLine(line);
		}
		
	}
	
	public void processLine(String line){
		try{
			Random random= new Random();
			Thread.sleep(100);
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}

}
