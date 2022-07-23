package org.example;

import interfaces.LocationInterface;
import org.example.Services.LocationService;
import org.example.Services.SpaceLocation;
import org.example.Services.WeatherDao;
import org.example.Services.WeatherDaoImpl;
import org.example.entities.Location;
import org.example.entities.People;
import org.example.entities.Space;
import org.example.model.IssNowResponse;
import org.example.model.PeopleResponse;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static final WeatherDao weatherDao= new WeatherDaoImpl();
    private static final LocationInterface locationService= new LocationService();
    public static void main(String[] args) {
        SpaceLocation spaceLocation = new SpaceLocation();
        IssNowResponse response = spaceLocation.getPeopleInSpace();
        System.out.println(response.getNumber());


        Space space = new Space();
        List<People> peopleList = new ArrayList<>();

        space.setNumberOfPeopleInSpace(response.getNumber());

        for (PeopleResponse peopleResponse : response.getPeople()) {
            People people = new People();
            people.setName(peopleResponse.getName());
            people.setCraft(peopleResponse.getCraft());
            people.setSpace(space);

            peopleList.add(people);
        }

        space.setPeopleList(peopleList);

    weatherDao.insert(space);
    weatherDao.insert(locationService.addLocation());

    }
}
