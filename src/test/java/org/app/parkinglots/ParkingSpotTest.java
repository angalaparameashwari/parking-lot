package org.app.parkinglots;

import org.app.parking_spots.ParkingSpot;
import org.app.parking_spots.ParkingSpotType;
import org.app.vehicles.Vehicle;
import org.app.vehicles.VehicleType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ParkingSpotTest {

    @Mock
    Vehicle vehicle;

    @Test
    public void shouldAssignParkingSpot(){
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.assignSpot(vehicle);
        Assertions.assertEquals(parkingSpot.isFree(), false);
    }

    @Test
    public void shouldReturnIdAndLocationId(){
        ParkingSpot parkingSpot = new ParkingSpot(ParkingSpotType.BUS_SPOT,"111","222");
        Assertions.assertEquals(parkingSpot.isFree(), true);
        Assertions.assertEquals("111", parkingSpot.getId());
        Assertions.assertEquals("222", parkingSpot.getLocationId());
    }

    @Test
    public void vehicleShouldBeAddedWhenSpotIsAssigned(){
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.assignSpot(vehicle);
        Assertions.assertNotNull(parkingSpot.getVehicle());
    }

    @Test void shouldReleaseParkingSpot(){
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.assignSpot(vehicle);
        parkingSpot.releaseSpot();
        Assertions.assertEquals(parkingSpot.isFree(), true);
    }

    @Test
    public void vehicleShouldBeRemovedWhenSpotIsReleased(){
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.assignSpot(vehicle);
        parkingSpot.releaseSpot();
        Assertions.assertNull(parkingSpot.getVehicle());
    }

}