package com.subrat.Executor;

public class Main {

	public static void main(String[] args) {
		ServerApplication server = new ServerApplication();
		for (int i = 0; i < 100; i++) {

			Task task = new Task("Task " + i);
			server.executeTask(task);
		}
		server.endTask();

	}

}
