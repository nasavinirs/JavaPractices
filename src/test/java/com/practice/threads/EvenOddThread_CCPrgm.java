package com.practice.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

class OrderProcessingThread extends Thread {

	ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
	Double totalAmount = new Double(0);

	public OrderProcessingThread() {

	}

	public void addOrder(String str) {
		queue.add(str);
	}

	public void run() {

		// fill in your code here
		String[] data;
		// System.out.println(queue.size());
		while (queue.size() > 0) {
			data = queue.poll().split(",");
			if (queue.size() % 2 == 0) {
				System.out.println("Order " + data[0] + " Processed by Even Thread thread");
				totalAmount += Double.parseDouble(data[1]);
			} else {

				System.out.println("Order " + data[0] + " Processed by Odd Thread thread");
				totalAmount += Double.parseDouble(data[1]);
			}
		}

	}

	public Double getTotalAmount() {
		return totalAmount;
	}

}

public class EvenOddThread_CCPrgm {

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the number of orders:");
		int numberOfOrders = Integer.parseInt(reader.readLine());
		System.out.println("Enter all the orders (Order ID, Order Amount):");
		OrderProcessingThread oddThread = new OrderProcessingThread();
		OrderProcessingThread evenThread = new OrderProcessingThread();
		for (int i = 0; i < numberOfOrders; i++) {
			String data = reader.readLine();
			if (i % 2 == 0) {
				evenThread.addOrder(data);
			} else {
				oddThread.addOrder(data);
			}

		}

		// fill in your code here

		for (int s = 0; s < numberOfOrders; s++) {
			Thread th1 = new Thread(evenThread);
			Thread th2 = new Thread(oddThread);
			th1.start();			
			th2.start();
			th1.join();
		}

		System.out.println("Total amount processed by even thread:" + evenThread.getTotalAmount());
		System.out.println("Total amount processed by odd thread:" + oddThread.getTotalAmount());

	}

}
