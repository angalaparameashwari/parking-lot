package org.app.tickets;


import org.app.parking_spots.ParkingSpot;
import org.app.parking_spots.ParkingSpotType;
import org.app.parkinglots.ParkingLot;
import org.app.parkinglots.ParkingLotType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ParkingTicketTest {

    @Mock
    ParkingSpot parkingSpot;
    @Mock
    ParkingLot parkingLot;
    ParkingSpot parkingSpotActual;

    @BeforeEach
    public void before(){
        parkingSpotActual = new ParkingSpot(ParkingSpotType.MOTORBIKE_SPOT,"id", "location");
    }
    @Test
    public void shouldGenerateTicket(){
        ParkingTicket parkingTicket = new ParkingTicket(parkingSpot, parkingLot);

        Assertions.assertNotNull(parkingTicket.getEntryTime());
        Assertions.assertNotNull(parkingTicket.getTicketNo());
//        Assertions.assertEquals(ParkingLotType.MALL_PARKING_LOT, parkingTicket.getParkingLot().getParkingLotType());
    }

    @Test
    public void shouldGenerateTicketWithSpot(){
        ParkingTicket parkingTicket = new ParkingTicket(parkingSpotActual, parkingLot);

        Assertions.assertNotNull(parkingTicket.getEntryTime());
        Assertions.assertNotNull(parkingTicket.getTicketNo());
//        Assertions.assertEquals(ParkingLotType.MALL_PARKING_LOT, parkingTicket.getParkingLotType());
        Assertions.assertEquals("id", parkingSpotActual.getId());
        Assertions.assertEquals("location", parkingSpotActual.getLocationId());
    }

    @Test
    public void shouldReturnParkingSpotType(){

        ParkingTicket parkingTicket = new ParkingTicket(parkingSpotActual, parkingLot);

        Assertions.assertEquals(ParkingSpotType.MOTORBIKE_SPOT, parkingSpotActual.getType());
    }

}