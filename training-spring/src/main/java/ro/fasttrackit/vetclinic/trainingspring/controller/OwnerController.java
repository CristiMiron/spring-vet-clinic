package ro.fasttrackit.vetclinic.trainingspring.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.vetclinic.trainingspring.model.Owner;
import ro.fasttrackit.vetclinic.trainingspring.model.Vet;
import ro.fasttrackit.vetclinic.trainingspring.service.OwnerService;

import java.util.List;

@RestController
public class OwnerController {

    private final OwnerService service;

    public OwnerController(OwnerService injectedService){this.service = injectedService;}

    @GetMapping("api/owner/{id}")
    public Owner getOwnerById (@PathVariable("id") Long ownerId){
        return service.getOwnerById(ownerId);
    }

    @GetMapping("api/owner")
    public List<Owner> getAllOwners(){
        return service.findAllOwners();
    }

    @PostMapping("/api/owner")
    public Owner createNewOwner (@RequestBody Owner ownerRequest){
        return service.createNewOwner(ownerRequest);
    }

    @PutMapping("api/owner")
    public Owner updateOwner(@RequestBody Owner updateOwner){
        return service.updateOwner(updateOwner);
    }

    @DeleteMapping("api/owner/{id}")
    public void deleteOwner (@PathVariable("id") Long idToDelete){
        this.service.deleteOwnerById(idToDelete);
    }
}
