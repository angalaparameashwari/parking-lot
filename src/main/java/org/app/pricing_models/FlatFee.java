package org.app.pricing_models;

import org.app.Exceptions.GeneralException;
import org.app.fare_details.FareDetails;
import org.app.parking_spots.ParkingSpotType;
import org.app.tickets.ParkingReceipt;

public class FlatFee implements PricingModel{
    @Override
    public long calculateFare(ParkingReceipt parkingReceipt) {
        switch (parkingReceipt.getParkingSpotType()){
            case MOTORBIKE_SPOT:
                return FareDetails.MOTOR_BIKE_FARE_MALL;
            case CAR_SPOT:
                return FareDetails.CAR_FARE_MALL;
            case BUS_SPOT:
                return FareDetails.BUS_FARE_MALL;
            default:
                throw new GeneralException("Unexpected!!!", 500);
        }
    }
}
