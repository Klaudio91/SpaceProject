package org.example.entities;


import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SPACE")
public class Space {

    public Space() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int numberOfPeopleInSpace;

    @OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
    private List<People> peopleList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfPeopleInSpace() {
        return numberOfPeopleInSpace;
    }

    public void setNumberOfPeopleInSpace(int numberOfPeopleInSpace) {
        this.numberOfPeopleInSpace = numberOfPeopleInSpace;
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }

}