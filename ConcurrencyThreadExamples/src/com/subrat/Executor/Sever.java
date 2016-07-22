package com.subrat.Executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Sever {

	public static void main(String[] args) throws IOException {
	
		Executor pool = Executors.newFixedThreadPool(3);
		
		ServerSocket s= new ServerSocket(9000);
		System.out.println("Server socket= "+s.getLocalPort()+ s.isBound());
		while (true){
			final Socket socket= s.accept();
			
			Runnable r= new Runnable() {
				
				@Override
				public void run() {
					doWork(socket);
				}
			};
			pool.execute(r);
		}
		
	}
	public static void doWork(Socket sk){
		System.out.println("Inside doWork"+ sk.getPort());
		
	}
	
}
