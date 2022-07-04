package org.app.pricing_models;

import org.app.fare_details.FareDetails;
import org.app.parkinglots.ParkingLotType;
import org.app.tickets.ParkingReceipt;

public abstract class TieredPricing implements PricingModel{
    @Override
    public long calculateFare(ParkingReceipt parkingReceipt) {
      return 0;
    }
}
