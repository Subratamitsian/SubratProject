package com.subrat.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class VideoConference implements Runnable{
	
	private final CountDownLatch controller;
	

	@Override
	public void run() {
		System.out.printf("Video conference initalization : %d participants. \n",controller.getCount());
		try{
		//	controller.await(3000,TimeUnit.MILLISECONDS);
			controller.await();
			System.out.printf("Video conference all the participants has arrived. \n");
			System.out.printf("Let's start the video Conference... \n");
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}


	public VideoConference(int number) {
		controller= new CountDownLatch(number);
	}

	public void arrive(String name){
		System.out.printf("%s: has arrived. \n",name);
		controller.countDown();
		System.out.printf("Video conference: waiting for %d participants. \n",controller.getCount());
		
		
	}
}
