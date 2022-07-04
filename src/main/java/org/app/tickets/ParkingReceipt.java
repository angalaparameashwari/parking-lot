package org.app.tickets;

import lombok.Getter;
import org.app.parking_spots.ParkingSpotType;
import org.app.pricing_models.PriceCalculator;

import java.sql.Date;
import java.util.UUID;

@Getter
public class ParkingReceipt {
    private String receiptNo;
    private ParkingTicket parkingTicket;
    private Date exitTime;

    private long fee;

    public ParkingReceipt generateReceipt(ParkingTicket parkingTicket){
        this.parkingTicket = parkingTicket;
        this.receiptNo = UUID.randomUUID().toString();
        this.exitTime = new Date(System.currentTimeMillis());
        computeAmount();
        return this;
    }

    private void computeAmount(){
        PriceCalculator priceCalculator = new PriceCalculator(parkingTicket.getParkingLot().getPricingModel());
        this.fee = priceCalculator.getPricingModel().calculateFare(this);
    }

    public ParkingSpotType getParkingSpotType(){
        return parkingTicket.getParkingSpotType();
    }

    public Date getEntryTime(){
        return parkingTicket.getEntryTime();
    }
}
