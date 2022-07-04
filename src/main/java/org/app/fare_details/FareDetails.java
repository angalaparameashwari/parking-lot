package org.app.fare_details;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FareDetails {

    //MALL

    public static final int MOTOR_BIKE_FARE_MALL = 10;
    public static final int CAR_FARE_MALL = 20;
    public static final int BUS_FARE_MALL = 50;


    //stadium;

    public static final Map<TierInfo, Integer> MOTOR_BIKE_FARE_STADIUM = new LinkedHashMap<>();
    public static final Map<TierInfo, Integer> CAR_FARE_STADIUM = new LinkedHashMap<>();

    public static final Map<TierInfo, Integer> BUS_FARE_STADIUM = new LinkedHashMap<>();


    public static final Map<TierInfo, Integer> MOTOR_BIKE_FARE_AIR_PORT = new LinkedHashMap<TierInfo, Integer>();
    public static final Map<TierInfo, Integer> CAR_FARE_AIR_PORT = new LinkedHashMap<>();

    public static final Map<TierInfo, Integer> BUS_FARE_AIR_PORT = new LinkedHashMap<>();


    public static void init(){
        MOTOR_BIKE_FARE_STADIUM.put(new TierInfo(0,4),30);
        MOTOR_BIKE_FARE_STADIUM.put(new TierInfo(4,12),60);
        MOTOR_BIKE_FARE_STADIUM.put(new TierInfo(12, null),100);

        CAR_FARE_STADIUM.put(new TierInfo(0,4), 60);
        CAR_FARE_STADIUM.put(new TierInfo(4, 12), 120);
        CAR_FARE_STADIUM.put(new TierInfo(12, null), 200);

        MOTOR_BIKE_FARE_AIR_PORT.put(new TierInfo(0,1),0);
        MOTOR_BIKE_FARE_AIR_PORT.put(new TierInfo(1,8),40);
        MOTOR_BIKE_FARE_AIR_PORT.put(new TierInfo(8,24), 60);
        MOTOR_BIKE_FARE_AIR_PORT.put(new TierInfo(24, null), 80);

        CAR_FARE_AIR_PORT.put(new TierInfo(0,12),60);
        CAR_FARE_AIR_PORT.put(new TierInfo(12,24),80);
        CAR_FARE_AIR_PORT.put(new TierInfo(24, null), 100);
    }
}
