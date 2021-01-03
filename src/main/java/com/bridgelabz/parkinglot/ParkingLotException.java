package com.bridgelabz.parkinglot;

public class ParkingLotException extends RuntimeException {

    public enum ExceptionType{
        NO_SUCH_CAR_NUMBER
    }

    public ExceptionType type;

    public ParkingLotException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
