package com.akash.railwayticketbooking.datalayer;

import java.util.ArrayList;
import java.util.List;

import com.akash.railwayticketbooking.model.Credentials;
import com.akash.railwayticketbooking.model.Train;

public class RailwayTicketBookingDatabase {

	private static RailwayTicketBookingDatabase bookingDatabase;
	private List<Credentials> credentialsList;
	private List<Train> trainList;

	public RailwayTicketBookingDatabase() {
		credentialsList = new ArrayList<Credentials>();
		trainList = new ArrayList<Train>();
	}

	public static RailwayTicketBookingDatabase getInstance() {
		if (bookingDatabase == null) {
			bookingDatabase = new RailwayTicketBookingDatabase();
		}
		return bookingDatabase;
	}

	public Credentials getCredentials(String email) {
		for (Credentials credentials : credentialsList) {
			if (credentials.getEmail().equals(email)) {
				return credentials;
			}
		}
		return null;
	}

	public void addCredentials(Credentials credentials) {
		credentialsList.add(credentials);
	}

	public void addTrain(Train train) {
		trainList.add(train);
	}

	public List<Train> getTrain() {
		return trainList;
	}
}
