package com.subrat.Executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAppwithThread {
	
	public static void main(String[] args) throws IOException {
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
			new Thread(r).start();
		}
		
	}
	public static void doWork(Socket sk){
		System.out.println("Inside doWork"+ sk.getPort());
		
	}
	
	

}
