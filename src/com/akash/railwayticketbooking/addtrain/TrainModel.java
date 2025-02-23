package com.akash.railwayticketbooking.addtrain;

import java.util.List;

import com.akash.railwayticketbooking.datalayer.RailwayTicketBookingDatabase;
import com.akash.railwayticketbooking.model.Train;

public class TrainModel {

	private TrainView trainView;
	private Train train;

	public TrainModel(TrainView trainView) {
		this.trainView = trainView;
		train=new Train();
	}

	public void addTrain(int trainNo, String trainName, String depature, String arrival, int seats, double fare) {
		
		train.setTrainNo(trainNo);
		train.setTrainName(trainName);
		train.setDepatureTime(depature);
		train.setArrivalTime(arrival);
		train.setTotalSeats(seats);
		train.setFare(fare);
		RailwayTicketBookingDatabase.getInstance().addTrain(train);
	}

	public void getAllTrain() {
		List<Train>trainList= RailwayTicketBookingDatabase.getInstance().getTrain();
		boolean flag=true;
		for (Train train : trainList) {
			System.out.println(train);
			flag=false;
		}
		if (flag) {
			System.out.println("no trains are added ");
		}
	}

	public void checkTrain(int trainNumer) {
		List<Train>trainList= RailwayTicketBookingDatabase.getInstance().getTrain();
		boolean flag=true;
		for (Train train : trainList) {
			if(train.getTrainNo()==trainNumer) {
				flag=false;
				System.out.println("Train available");
				trainView.addTrainRoutes(train);
				
			}
		}
	}

	public void addTrainRoutes(List<String> routes) {
		train.setRoutes(routes);
	}
	
	
}
