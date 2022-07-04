package org.app.parkinglots;

import lombok.Getter;
import lombok.Setter;
import org.app.Exceptions.GeneralException;
import org.app.Exceptions.NoSpotAvailableException;
import org.app.parking_spots.*;
import org.app.pricing_models.PricingModel;
import org.app.tickets.ParkingReceipt;
import org.app.tickets.ParkingTicket;
import org.app.vehicles.Vehicle;

import java.util.*;

@Getter
@Setter
public abstract class ParkingLot{
    private String name;
    private String id;
    private Map<String, ParkingSpot> usedSpots;
    private Map<ParkingSpotType,List<ParkingSpot>> availableSpots;
    private ParkingLotType parkingLotType;



    private PricingModel pricingModel;

    private List<ParkingTicket> activeTickets;




    public ParkingLot(ParkingLotType parkingLotType, PricingModel pricingModel, String name, String id){
        this.name = name;
        this.id = id;
        this.availableSpots = new HashMap<>();
        this.usedSpots = new HashMap<>();
        this.parkingLotType = parkingLotType;
        this.pricingModel = pricingModel;
        this.activeTickets = new ArrayList<>();
    }

    public void addSpot(ParkingSpot parkingSpot){
        if (availableSpots.containsKey(parkingSpot.getType())) {
            availableSpots.get(parkingSpot.getType()).add(parkingSpot);
        }else {
            availableSpots.put(parkingSpot.getType(), Arrays.asList(parkingSpot));
        }
    }


    public ParkingSpot assignASpot(Vehicle vehicle){
        ParkingSpotType parkingSpotType;
        switch (vehicle.getType()){
            case MOTORCYCLE:
            case SCOOTER:
            {
               parkingSpotType = ParkingSpotType.MOTORBIKE_SPOT;
               break;
            }

            case CAR:
            case SUV:
            {
                parkingSpotType = ParkingSpotType.CAR_SPOT;
                break ;
            }

            case BUS:
            case TRUCK:
            {
                parkingSpotType = ParkingSpotType.BUS_SPOT;
                break ;
            }
            default:
                throw new GeneralException("Unexpected!!!", 500);
        }

        ParkingSpot parkingSpot = getASpot(parkingSpotType);
        setSpots(parkingSpot);
        return parkingSpot;
    }

    private void generateTickets(ParkingSpot parkingSpot){
        ParkingTicket parkingTicket = new ParkingTicket(parkingSpot, this);
        activeTickets.add(parkingTicket);
    }

    public void setSpots(ParkingSpot parkingSpot){
        availableSpots.remove(parkingSpot);
        usedSpots.put(parkingSpot.getLocationId(), parkingSpot);
    }


    public ParkingSpot getASpot(ParkingSpotType parkingSpotType) {
        if (!availableSpots.containsKey(parkingSpotType)){
            throw new NoSpotAvailableException("No spot available");
        }

        ParkingSpot parkingSpot = availableSpots.get(parkingSpotType).get(0);
        availableSpots.remove(0);
       if(availableSpots.get(parkingSpotType).isEmpty()){
           availableSpots.remove(parkingSpotType);
       }
        return parkingSpot;
    }

    public void releaseSpot(ParkingSpot parkingSpot){
        if(!usedSpots.containsKey(parkingSpot.getId())) {
            throw new GeneralException("Un expected!!", 500);
        }
        usedSpots.remove(parkingSpot.getId());
        addSpot(parkingSpot);
    }

    public ParkingReceipt generateReceipt(ParkingTicket parkingTicket){
        validateTicket(parkingTicket);
        ParkingReceipt receipt = new ParkingReceipt();
        return receipt.generateReceipt(parkingTicket);
    }

    public void validateTicket(ParkingTicket parkingTicket){
        if (!activeTickets.contains(parkingTicket)){
            throw new GeneralException("Un expected!!", 500);
        }
        activeTickets.remove(parkingTicket);
    }
}
