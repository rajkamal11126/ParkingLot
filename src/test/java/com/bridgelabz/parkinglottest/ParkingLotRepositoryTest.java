package com.bridgelabz.parkinglottest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bridgelabz.parkinglot.Car;
import com.bridgelabz.parkinglot.ParkingLot;
import com.bridgelabz.parkinglot.ParkingLotException;

public class ParkingLotRepositoryTest {
	Car[] carDetails = new Car[101];
	
    @Before
    public void setup() {
        for (int i = 0; i < 101; i++) {
            carDetails[i] = new Car()
                    .setCarNumber("ABC " + (i+1))
                    .setColor("Black")
                    .setModelName("CarModel " + i)
                    .setOwnerName("ABC's "+ i)
                    .getCarDetails();
        }
    }
    @Test
    public void whenVehicleArrives_shouldParkInLot() {
        ParkingLot parkingLot = new ParkingLot(carDetails);
        boolean carParkStatus = parkingLot.parkVehicle();
        Assert.assertTrue(carParkStatus);
    }

    @Test
    public void whenDriverArrives_shouldUnparkVehicle() {
        ParkingLot parkingLot = new ParkingLot(carDetails);
        boolean carParkStatus = parkingLot.parkVehicle();
        boolean carUnParkStatus = parkingLot.unparkVehicle("ABC 1");
        Assert.assertTrue(carUnParkStatus);
    }

    @Test
    public void whenGivenInvalidCarNumber_shouldThrowException() {
        try {
            ParkingLot parkingLot = new ParkingLot(carDetails);
            boolean carParkStatus = parkingLot.parkVehicle();
            boolean carUnParkStatus = parkingLot.unparkVehicle("ABC 12");
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.NO_SUCH_CAR_NUMBER, e.type);
        }
    }
    @Test
    public void whenMoreThen100Vehicle_shouldSetParkingLotStatusFull() {
        carDetails[carDetails.length-1] = new Car()
                .setCarNumber("ABC 101")
                .setColor("Black")
                .setModelName("CarModel 101")
                .setOwnerName("ABC's 101")
                .getCarDetails();
        ParkingLot parkingLot = new ParkingLot(carDetails);
        boolean carParkStatus = parkingLot.getVehicleParkedUnparked();
        Assert.assertEquals(ParkingLot.parkingLotStatus, "FULL");
    }
}