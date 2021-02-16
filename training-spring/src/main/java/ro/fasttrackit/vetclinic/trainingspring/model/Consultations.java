package ro.fasttrackit.vetclinic.trainingspring.model;

public class Consultations {

    private Long id;
    public Pet pet;
    public Vet vet;
    public Owner owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Consultations{" +
                "id=" + id +
                ", pet=" + pet +
                ", vet=" + vet +
                ", owner=" + owner +
                '}';
    }
}
