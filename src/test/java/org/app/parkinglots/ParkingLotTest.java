package org.app.parkinglots;

import org.app.Exceptions.NoSpotAvailableException;
import org.app.parking_spots.*;
import org.app.pricing_models.FlatFee;
import org.app.vehicles.Vehicle;
import org.app.vehicles.VehicleType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
class ParkingLotTest {


    @Mock
    Vehicle vehicle;
    @Mock
    ParkingSpot parkingSpot;
    @Mock
    Map<ParkingSpotType, List<ParkingSpot>> availableSpots;
    @Mock
    Map<String, ParkingSpot> usedSpots;

    ParkingLot parkingLot;

    @BeforeEach
    public void before(){
        parkingLot = new MallParkingLot("mall1","mall1_id", new FlatFee()) {
        };
    }

    @Test
    public void shouldAddAParkingSpot(){
        //given
        Mockito.when(parkingSpot.getType()).thenReturn(ParkingSpotType.MOTORBIKE_SPOT);
        Map<ParkingSpotType,List<ParkingSpot>> availableSpots = new HashMap<>();
        //when
        parkingLot.addSpot(parkingSpot);

        //then
        Assertions.assertEquals(1,parkingLot.getAvailableSpots().size());
        Assertions.assertEquals(1,parkingLot.getAvailableSpots().get(ParkingSpotType.MOTORBIKE_SPOT).size());

    }

    @Test
    public void shouldAddBusParkingSpot(@Mock ParkingSpot parkingSpot){
        //given
        Mockito.when(parkingSpot.getType()).thenReturn(ParkingSpotType.BUS_SPOT);
        Map<ParkingSpotType,List<ParkingSpot>> availableSpots = new HashMap<>();
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new ParkingSpot(ParkingSpotType.BUS_SPOT,"id", "location"));
        availableSpots.put(ParkingSpotType.BUS_SPOT,parkingSpots);
        parkingLot.setAvailableSpots(availableSpots);
        //when
        parkingLot.addSpot(parkingSpot);

        //then
        Assertions.assertEquals(1,parkingLot.getAvailableSpots().size());
        Assertions.assertEquals(2,parkingLot.getAvailableSpots().get(ParkingSpotType.BUS_SPOT).size());
    }


    @Test
    public void shouldAssignASpotToAMotorCycle(){
        Mockito.when(vehicle.getType()).thenReturn(VehicleType.MOTORCYCLE);
        Mockito.when(availableSpots.containsKey(ParkingSpotType.MOTORBIKE_SPOT)).thenReturn(true);
        Mockito.when(availableSpots.get(ParkingSpotType.MOTORBIKE_SPOT)).thenReturn(Arrays.asList(parkingSpot));
        Mockito.when(availableSpots.get(ParkingSpotType.MOTORBIKE_SPOT).get(0)).thenReturn(parkingSpot);
        Mockito.when(availableSpots.remove(0)).thenReturn(null);
        Mockito.when(availableSpots.get(ParkingSpotType.MOTORBIKE_SPOT).isEmpty()).thenReturn(false);
//        Mockito.when(parkingLot.getASpot(ParkingSpotType.MOTORBIKE_SPOT)).thenReturn(parkingSpot);
        Mockito.when(availableSpots.remove(parkingSpot)).thenReturn(null);
        Mockito.when(parkingSpot.getLocationId()).thenReturn("locationId");
        Mockito.when(usedSpots.put(parkingSpot.getLocationId(), parkingSpot)).thenReturn(null);
        ParkingSpot parkingSpot1 = parkingLot.assignASpot(vehicle);

        Assertions.assertEquals(parkingSpot1, parkingSpot);
    }

    @Test
    public void shouldMoveAllotedSpotsToMap(){
//        MallParkingLot parkingLot = new MallParkingLot("mall1", "mall1_id");
//        MotorBikeSpot motorBikeSpot = new MotorBikeSpot("id","1");
//        List<MotorBikeSpot> availableSpots = new ArrayList<>();
//        availableSpots.add(motorBikeSpot);
//        Map<String, MotorBikeSpot> usedSpots = new HashMap<>();
//        parkingLot.setAvailableMotorBikeSpots(availableSpots);
//        parkingLot.setMotorBikeSpots(usedSpots);
//
//        parkingLot.setSpots(usedSpots, availableSpots, motorBikeSpot);
//
//        Assertions.assertEquals(0,parkingLot.getAvailableMotorBikeSpots().size());
//        Assertions.assertEquals(1, parkingLot.getMotorBikeSpots().size());
    }

//    @Test
//    public void getSpotShouldThrowErrorWhenNoSpotIsAvailable(@Mock List<MotorBikeSpot> availableSpots){
//        MallParkingLot parkingLot = new MallParkingLot("mall1", "mall1_id");
//        Mockito.when(availableSpots.isEmpty()).thenReturn(true);
//
//        Assertions.assertThrows(NoSpotAvailableException.class,() -> parkingLot.getASpot(availableSpots));
//    }
//
//    @Test
//    public void getSpotShouldReturnFirstValueInTheList(){
//        MallParkingLot parkingLot = new MallParkingLot("mall1", "mall1_id");
//        List<MotorBikeSpot> availableSpots = new ArrayList<>();
//        availableSpots.add(new MotorBikeSpot("id", "location"));
//
//        ParkingSpot aSpot = parkingLot.getASpot(availableSpots);
//        Assertions.assertEquals("id",aSpot.getId());
//        Assertions.assertEquals("location", aSpot.getLocationId());
//    }

}