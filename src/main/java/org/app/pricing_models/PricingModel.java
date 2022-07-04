package org.app.pricing_models;

import org.app.tickets.ParkingReceipt;

public interface PricingModel {

    public long calculateFare(ParkingReceipt parkingReceipt);
}
