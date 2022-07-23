package org.example.Services;

import interfaces.LocationInterface;
import org.example.entities.Location;

import java.util.Scanner;

public class LocationService implements LocationInterface {
    @Override
    public Location addLocation() {
        Location location = new Location();
        Scanner scanner = new Scanner(System.in);
        location.setLongitude(scanner.nextLine());
        location.setLatitude(scanner.nextLine());
        return location;
    }
//     Location addLocation() {
//        Location location = new Location();
//        Scanner scanner = new Scanner(System.in);
//        location.setLongitude(scanner.nextLine());
//        location.setLatitude(scanner.nextLine());
//        return location;
//    }

}
