package com.akash.railwayticketbooking.passangerbooking;

import java.util.ArrayList;
import java.util.List;

import com.akash.railwayticketbooking.datalayer.RailwayTicketBookingDatabase;
import com.akash.railwayticketbooking.model.Train;

public class BookingModel {

	private BookingView bookingView;
	private List<Train> availableTrain;

	public BookingModel(BookingView bookingView) {
		availableTrain = new ArrayList<Train>();
		this.bookingView = bookingView;
	}

	public void availableTrain(String from, String to) {

		List<Train> trainList = RailwayTicketBookingDatabase.getInstance().getTrain();
		boolean flag = true;
		for (Train train : trainList) {
			List<String> routes = train.getRoutes();
			if (routes.get(0).equalsIgnoreCase(from) && routes.get(routes.size()-1).equalsIgnoreCase(to)) {
				availableTrain.add(train);
				flag = false;
			}
//			for (String route : routes) {
//				if (route.equalsIgnoreCase(from) && route.equalsIgnoreCase(to)) {
//					availableTrain.add(train);
//					
//				}
//			}
		}
		if (flag) {
			System.out.println("Currently No trains are Available");
		} else {
			availableTrains();
		}
	}

	private void availableTrains() {
		for (Train availableTrain : availableTrain) {
			System.out.println(availableTrain);
		}
	}

}
