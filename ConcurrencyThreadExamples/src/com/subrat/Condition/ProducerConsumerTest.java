package com.subrat.Condition;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		
		FileMock mock= new FileMock(10, 10);
		Buffer buffer= new Buffer(20);
		
		Producer producer= new Producer(mock, buffer);
		Thread threadproducer= new Thread(producer,"Producer");
		
		Consumer [] consumer= new Consumer[3];
		Thread threadconsumer[]= new Thread[3];
		for (int i = 0; i < 3; i++) {
			consumer[i]= new Consumer(buffer);
			threadconsumer[i]= new Thread(consumer[i],"Consumer "+i);
			
		}
		threadproducer.start();
		for (int i = 0; i < 3; i++) {
			threadconsumer[i].start();
		}
		
	}

}
