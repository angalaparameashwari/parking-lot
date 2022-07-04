package org.app.parkinglots;

import org.app.pricing_models.PricingModel;

public class MallParkingLot extends ParkingLot{

    public MallParkingLot(String name, String id, PricingModel pricingModel){

        super(ParkingLotType.MALL_PARKING_LOT, pricingModel, name, id);
    }
}
