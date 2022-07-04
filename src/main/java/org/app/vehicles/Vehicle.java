package org.app.vehicles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.app.tickets.ParkingTicket;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Vehicle {
    private String number;
    private VehicleType type;

    public Vehicle(VehicleType type, String number){
        this.type = type;
        this.number = number;
    }
}
