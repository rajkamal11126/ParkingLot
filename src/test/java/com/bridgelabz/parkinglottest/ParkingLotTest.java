package com.bridgelabz.parkinglottest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.bridgelabz.parkinglot.Car;
import com.bridgelabz.parkinglot.ParkingLot;
import com.bridgelabz.parkinglot.ParkingLotRepository;
import static org.mockito.Mockito.when;

public class ParkingLotTest {
	Car carDetails;
	@Mock
    ParkingLotRepository parkingLotRepository;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

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
		ParkingLot parkingLot = new ParkingLot(carDetails, parkingLotRepository);
        when(parkingLotRepository.getVehicleParked(carDetails)).thenReturn(true);
		boolean carParkStatus = parkingLot.parkVehicle();
		Assert.assertTrue(carParkStatus);
	}
}
