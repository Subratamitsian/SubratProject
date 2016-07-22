package com.subrat.Executor;

import java.util.concurrent.Callable;

public class CallableTask  implements Callable<String>{

	@Override
	public String call() throws Exception {
		String s="CallableTask started At"+System.currentTimeMillis();
		return s;
	}
	
	

}
