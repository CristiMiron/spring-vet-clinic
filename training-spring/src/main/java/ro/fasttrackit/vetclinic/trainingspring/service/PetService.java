package ro.fasttrackit.vetclinic.trainingspring.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.vetclinic.trainingspring.model.Pet;
import ro.fasttrackit.vetclinic.trainingspring.model.Species;
import ro.fasttrackit.vetclinic.trainingspring.model.entity.PetEntity;
import ro.fasttrackit.vetclinic.trainingspring.repository.PetRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class PetService {

    private final PetRepository repository;

    public PetService(PetRepository injectedRepository){
        this.repository=injectedRepository;
    }

    public Pet getPetById(Long petId){
        Optional<PetEntity> foundEntity = repository.findById(petId);

        if(!foundEntity.isPresent()){
            return null;
        }

        return foundEntity
                .map(entityToMap -> {
                    Pet response = getPet(entityToMap);
                    return response;
                })
                .get();
    }

    public Pet createNewPet(Pet request){
        PetEntity newPet1 = new PetEntity();
        newPet1.setName(request.getName());
        newPet1.setSpecies(request.getSpecies());


        PetEntity savedEntity = this.repository.save(newPet1);

        Pet responseObject = getPet(savedEntity);

        return responseObject;
    }

    public Pet updatePet(Pet req) {
        PetEntity entityToUpdate = new PetEntity();
        entityToUpdate.setId(req.getId());
        entityToUpdate.setName(req.getName());
        entityToUpdate.setSpecies(req.getSpecies());

        PetEntity updateEntity = this.repository.save(entityToUpdate);

        Pet response = getPet(updateEntity);
        return response;
    }

    public List<Pet> findAllPets(){
        return this.repository.findAll()
                .stream()
                .map(entity -> {
                    Pet pet = getPet(entity);
                    return pet;
                })
                .collect(Collectors.toList());
    }

    private Pet getPet(PetEntity entity) {
        Pet pet = new Pet();
        pet.setId(entity.getId());
        pet.setName(entity.getName());
        pet.setSpecies(entity.getSpecies());
        return pet;
    }
    public void deletePetById(Long id){
        this.repository.deleteById(id);
    }
}
