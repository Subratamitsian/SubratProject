package com.subrat.Semaphore;

public class PrintDoc {
	public static void main(String[] args) {
		
		PrintQueue printqueue= new PrintQueue();
		
		Thread th[]= new Thread[10];
		
		for(int i=0;i<10;i++){
			th[i]= new Thread(new Job(printqueue),"Thread "+i);
		}
		
		for(int i=0;i<10;i++){
			th[i].start();
			try{
				Thread.sleep(100);
			}
			catch(InterruptedException e){e.printStackTrace();}
		}
	}
	

}
