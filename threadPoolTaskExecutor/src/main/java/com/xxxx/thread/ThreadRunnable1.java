package com.xxxx.thread;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class ThreadRunnable1 {

	
	@Autowired
	private TaskExecutor taskExecutor;
	
	
	
	public void executeThread(String result){
	
		this.taskExecutor.execute(new TaskThread(result));
	}
	private class TaskThread implements Runnable{

		private String result;
		private TaskThread(String result){
			super();
			this.result=result;
		}
		
		@Override
		public void run() {
			
			 new TestShow().start(result);
			
			
		}
		
	}
}
