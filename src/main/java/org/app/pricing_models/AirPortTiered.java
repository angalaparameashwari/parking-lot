package org.app.pricing_models;

import org.app.Exceptions.GeneralException;
import org.app.fare_details.FareDetails;
import org.app.fare_details.TierInfo;
import org.app.parking_spots.ParkingSpotType;
import org.app.tickets.ParkingReceipt;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AirPortTiered extends TieredPricing{

    @Override
    public long calculateFare(ParkingReceipt parkingReceipt) {
        long diffInMillies = Math.abs(parkingReceipt.getExitTime().getTime() - parkingReceipt.getEntryTime().getTime());
        long hours = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        Map<TierInfo, Integer> priceDetails = new LinkedHashMap<>();
        if (parkingReceipt.getParkingSpotType().equals(ParkingSpotType.MOTORBIKE_SPOT)){
            priceDetails.putAll(FareDetails.MOTOR_BIKE_FARE_AIR_PORT);
        }else if(parkingReceipt.getParkingSpotType().equals(ParkingSpotType.CAR_SPOT)){
            priceDetails.putAll(FareDetails.CAR_FARE_AIR_PORT);
        }
        else {
            throw new GeneralException("Invalid input", 400);
        }
        int i =0;
        for (Map.Entry<TierInfo,Integer> entry : priceDetails.entrySet()){
            i++;
            TierInfo tierInfo = entry.getKey();
            if (i == priceDetails.size()){
                return hours/24 * entry.getValue();
            }
            if (tierInfo.getStartUnit() <= hours && hours < tierInfo.getEndUnit()){
                return entry.getValue();
            }
        }

        throw new GeneralException("Unexpected!!!", 500);
    }
}
