package org.example;

import org.example.Services.SpaceLocation;
import org.example.entities.People;
import org.example.entities.Space;
import org.example.model.IssNowResponse;
import org.example.model.PeopleResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        SpaceLocation spaceLocation = new SpaceLocation();
        IssNowResponse response = spaceLocation.getPeopleInSpace();
        System.out.println(response.getNumber());


        Space space = new Space();
        List<People> peopleList = new ArrayList<>();

        space.setNumberOfPeopleInSpace(response.getNumber());

        for (PeopleResponse peopleResponse : response.getPeople()) {
            People p = new People();
            p.setName(peopleResponse.getName());
            p.setCraft(peopleResponse.getCraft());

            peopleList.add(p);
        }

        space.setPeopleList(peopleList);

        System.out.println(space);
        // SAVE space

        public static int Space (Space space){
            try {
                session = buildSessionFactory().openSession();
                session.beginTransaction();

                session.save(space);
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null) {
                    session.close();
                }
            }
            return 0;
        }
    }
}