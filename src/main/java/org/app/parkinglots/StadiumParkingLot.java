package org.app.parkinglots;

import org.app.pricing_models.PricingModel;

public class StadiumParkingLot extends ParkingLot {


    public StadiumParkingLot(String name, String id, PricingModel pricingModel){
        super(ParkingLotType.STADIUM_PARKING_LOT, pricingModel,name, id);
    }
}
