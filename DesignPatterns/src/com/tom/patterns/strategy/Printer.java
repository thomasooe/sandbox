package com.tom.patterns.strategy;

import java.util.Random;

public class Printer extends Thread {
	public enum QueueStrategy { 
		FIFO,
		JOB_PRIORITY
	}
	
	private boolean shouldRun = true;
	//private PrinterQueue printerQueue = new SimpleFIFOPrinterQueue();
	//private PrinterQueue printerQueue = new JobPriorityPrinterQueue();
	private Random myRandom = new Random();
	private PrinterQueue printerQueue;

	public Printer() {
		this(QueueStrategy.FIFO);
	}
	
	public Printer(QueueStrategy queueStrategy) {
		if (queueStrategy == QueueStrategy.FIFO)
		{
			this.printerQueue = new SimpleFIFOPrinterQueue();
		} else if (queueStrategy == QueueStrategy.JOB_PRIORITY)
		{
			this.printerQueue = new JobPriorityPrinterQueue();
		}
	}

	public void run() {
		while (this.shouldRun) {
			try {
				Thread.sleep(100);
				Job j = this.getNextJob();
				if (j != null) {
					this.printJob(j);
					this.informUserJob(j);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private Job getNextJob() {
		return printerQueue.getNextJob();
	}
	
	private void printJob(Job j) {
		try {
			System.out.println("Start of Job " + j.getId());
			Thread.sleep(this.myRandom.nextInt(1000));
			System.out.println("Print: " + this.getJobsAsPrinterLanguage(j));
			Thread.sleep(this.myRandom.nextInt(1000));
			System.out.println("End of Job " + j.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void informUserJob(Job j) {
		if (j.getUser() != null) {
			System.out.println("Notifying the user " + j.getUser().getName() + " that the print Job is done");
			j.getUser().printJobComplete(j);
		}
	}
	
	private String getJobsAsPrinterLanguage(Job j) {
		String retVal = new StringBuilder(j.getContent().toUpperCase()).reverse().toString();
		System.out.println("Translation " + j.getContent() + " --> " + retVal);
		return retVal;
	}

	public void print(Job job) {
		this.printerQueue.addJob(job);
	}

	public void shutdownPrinter() {
		this.shouldRun = false;
	}
}
