package com.subrat.exception;

import java.io.IOException;

public class ExceptionCheck {
	
	public static void main(String[] args) throws Exception {
		
		try{
			System.out.println("1");
			throw new IOException();
		}
		catch(RuntimeException e){
			
			
			System.out.println("2");
			//System.exit(1);
			
		}
		finally{
			System.out.println("3");
		}
	}

}
