package com.bridgelabz.parkinglottest;


import com.bridgelabz.parkinglot.Car;
import com.bridgelabz.parkinglot.ParkingLotEnum;
import com.bridgelabz.parkinglot.ParkingLotRepository;


public class ParkingLotTest {
	private ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
	private Car[] carDetails;
    public static ParkingLotEnum ownerParkingLotStatus = ParkingLotEnum.NOT_FULL;
    public static ParkingLotEnum securityStatus = ParkingLotEnum.NOT_FULL;

    public void ParkingLot(Car[] carDetails) {
        this.carDetails = carDetails;
    }
    public void ParkingLot(Car[] carDetails, ParkingLotRepository parkingLotRepository) {
        this.carDetails = carDetails;
        this.parkingLotRepository = parkingLotRepository;
    }
    public boolean getVehicleParkedUnparked(String... carNumber){
        if (carNumber.length == 0)
            return parkingLotRepository.getVehicleParked(carDetails);
        return parkingLotRepository.getVehicleUnparked(carNumber[0]);
    }
}
