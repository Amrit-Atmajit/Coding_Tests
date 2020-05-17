package com.synechron.threadtest;

public class ColorPrintTest {

	public static void main(String[] args) {
		Thread t1 = new ColorThread("RED");
		Thread t2 = new ColorThread("GREEN");
		Thread t3 = new ColorThread("BLUE");
		
		try {
			// Start RED thread
			t1.start();
			t1.join();
			
			// Start GREEN thread
			t2.start();
			t2.join();
			
			// Start BLUE thread
			t3.start();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

class ColorThread extends Thread {
	private String color;
	
	public ColorThread(String color) {
		this.color = color;
	}
	
	public void run() {
		System.out.println("Color is :: " + color);
	}
}
