package com.bridgelabz.parkinglottest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bridgelabz.parkinglot.Car;
import com.bridgelabz.parkinglot.ParkingLot;

public class ParkingLotTest {
	Car carDetails;

	@Before
	public void setup() {
		carDetails = new Car()
			.setCarNumber("MH9955")
			.setColor("Red")
			.setModelName("Yamaha")
			.setOwnerName("Hidaka")
			.getCarDetails();
	}

	@Test
	public void whenVehicleArrives_shouldParkInLot() {
		ParkingLot parkingLot = new ParkingLot(carDetails);
		boolean carParkStatus = parkingLot.parkVehicle();
		Assert.assertTrue(carParkStatus);
	}
}
