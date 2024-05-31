package com.akash.railwayticketbooking.passangerbooking;

import java.util.Scanner;

public class BookingView {
	Scanner sc = new Scanner(System.in);
	private BookingModel bookingModel;

	public BookingView() {
		bookingModel = new BookingModel(this);
	}

	public void start() {
		System.out.println("Welcome To IRCTC");
		System.out.println("\n1.Booking\n2.PNR Status\nExit\nEnter Your choice");

		switch (sc.nextLine()) {
		case "1":
			startBooking();
			break;

		default:
			break;
		}
	}

	private void startBooking() {
		System.out.println("Enter Your From Station");
		String from = sc.nextLine();
		System.out.println("Enter Your To Station");
		String to = sc.nextLine();
		bookingModel.availableTrain(from, to);

	}
}
