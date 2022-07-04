package org.app.parking_spots;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.app.vehicles.Vehicle;


@Setter
@Getter
@NoArgsConstructor
public class ParkingSpot {
    private String id;
    private String locationId;
    private boolean free;
    private ParkingSpotType type;
    private Vehicle vehicle;

    public ParkingSpot(ParkingSpotType type, String id, String locationId){
        this.type = type;
        this.id = id;
        this.locationId = locationId;
        this.free = true;
    }

    public ParkingSpot assignSpot(Vehicle vehicle){
        this.vehicle = vehicle;
        setFree(false);
        return this;
    }

    public void releaseSpot(){
        this.vehicle = null;
        setFree(true);
    }

}
