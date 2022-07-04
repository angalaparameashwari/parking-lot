package org.app.parkinglots;

import org.app.pricing_models.PricingModel;

public class AirPortParkingLot extends ParkingLot{

    public AirPortParkingLot(String name, String id, PricingModel pricingModel){

        super(ParkingLotType.AIR_PORT_PARKING_LOT, pricingModel, name, id);
    }
}
