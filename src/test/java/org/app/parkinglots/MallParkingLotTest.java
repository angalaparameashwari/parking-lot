package org.app.parkinglots;

import org.app.pricing_models.FlatFee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MallParkingLotTest {

    @Test
    public void shouldCreateMallParkingLot(){
        MallParkingLot mallParkingLot = new MallParkingLot("mall1", "mall1_id",new FlatFee());

        Assertions.assertEquals("mall1", mallParkingLot.getName());
        Assertions.assertEquals("mall1_id", mallParkingLot.getId());
    }

}