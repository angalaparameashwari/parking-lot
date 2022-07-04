package org.app.tickets;

import lombok.Getter;
import org.app.parking_spots.ParkingSpot;
import org.app.parking_spots.ParkingSpotType;
import org.app.parkinglots.ParkingLot;
import org.app.parkinglots.ParkingLotType;
import java.sql.Date;
import java.util.UUID;
@Getter
public class ParkingTicket {
    private ParkingLot parkingLot;
    private String ticketNo;
    private ParkingSpot parkingSpot;
    private Date entryTime;



    public ParkingTicket(ParkingSpot parkingSpot, ParkingLot parkingLot){
        this.parkingSpot = parkingSpot;
        this.entryTime = new Date(System.currentTimeMillis());
        this.ticketNo = UUID.randomUUID().toString();
        this.parkingLot = parkingLot;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpot.getType();
    }
}
