package com.practice.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;

class CreditCardProcessingThread implements Runnable {

	ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

	public ArrayBlockingQueue<String> getQueue() {
		return queue;
	}

	public void setQueue(ArrayBlockingQueue<String> queue) {
		this.queue = queue;
	}

	public CreditCardProcessingThread(ArrayBlockingQueue<String> queue) {
		this.queue = queue;
	}

	public CreditCardProcessingThread() {
		// TODO Auto-generated constructor stub
	}

	public void run() {
		try {
			String[] splittedValue = queue.take().split(",");
			System.out.println("Credit card processing completed for payment id " + splittedValue[0]);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addCreditCard(String val) throws InterruptedException {
		queue.put(val);
	}

}

class ChequeProcessingThread implements Runnable {

	ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

	public ArrayBlockingQueue<String> getQueue() {
		return queue;
	}

	public void setQueue(ArrayBlockingQueue<String> queue) {
		this.queue = queue;
	}

	public ChequeProcessingThread(ArrayBlockingQueue<String> queue) {
		this.queue = queue;

	}

	public ChequeProcessingThread() {
		// TODO Auto-generated constructor stub
	}

	public void run() {
		try {
			String[] splittedValue = queue.take().split(",");
			System.out.println("Cheque processing completed for payment id " + splittedValue[0]);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addCheque(String val) throws InterruptedException {
		queue.put(val);
	}
}

public class ShipmentPaymentProcess {
	public static void main(String args[]) throws IOException, InterruptedException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of payment:");
		int numberOfPayments = Integer.parseInt(buff.readLine());
		System.out.println("Enter all the payment details");
		for (int i = 0; i < numberOfPayments; i++) {
			String paymentDetails = buff.readLine();
			String[] splittedPaymentDetails = paymentDetails.split(",");
			if (splittedPaymentDetails[2].equalsIgnoreCase("CHEQ")) {
				ChequeProcessingThread cpt = new ChequeProcessingThread();
				Thread th = new Thread(cpt);
				cpt.addCheque(paymentDetails);
				th.start();
			} else if (splittedPaymentDetails[2].equalsIgnoreCase("CC")) {
				CreditCardProcessingThread ccpt = new CreditCardProcessingThread();
				Thread th = new Thread(ccpt);
				ccpt.addCreditCard(paymentDetails);
				th.start();
			} else {
				System.out.println("Error 1");
			}
		}
	}
}
