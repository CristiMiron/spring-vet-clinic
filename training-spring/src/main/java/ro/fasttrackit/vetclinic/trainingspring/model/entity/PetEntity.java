package ro.fasttrackit.vetclinic.trainingspring.model.entity;

import ro.fasttrackit.vetclinic.trainingspring.model.Pet;
import ro.fasttrackit.vetclinic.trainingspring.model.Species;

import javax.persistence.*;

@Entity(name = "pet")

public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    private Species species;

    public PetEntity (Long id, String name, Species species){
        this.id = id;
        this.name = name;
        this.species = species;
    }

    public PetEntity() {

    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PetEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species=" + species +
                '}';
    }
}
