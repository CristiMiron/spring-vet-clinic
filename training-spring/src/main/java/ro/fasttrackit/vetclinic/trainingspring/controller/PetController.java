package ro.fasttrackit.vetclinic.trainingspring.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.vetclinic.trainingspring.model.Pet;
import ro.fasttrackit.vetclinic.trainingspring.service.PetService;

import java.util.List;

@RestController

public class PetController {
    private final PetService service;

    public PetController(PetService injectedService) {
        this.service = injectedService;
    }



    @GetMapping("api/pet/{id}")
    public Pet getPetById (@PathVariable("id") Long petId){
        return service.getPetById(petId);
    }

    @GetMapping("api/pet")
    public List<Pet> getAllPets(){
        return service.findAllPets();
    }

    @PostMapping("/api/pet")
    public Pet createNewPet (@RequestBody Pet petRequest){
        return service.createNewPet(petRequest);
    }

    @PutMapping("api/pet")
    public Pet updatePet(@RequestBody Pet updatePet){
        return service.updatePet(updatePet);
    }

    @DeleteMapping("api/pet/{id}")
    public void deletePet (@PathVariable("id") Long idToDelete){
        this.service.deletePetById(idToDelete);
    }


}
