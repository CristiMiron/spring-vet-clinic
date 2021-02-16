package ro.fasttrackit.vetclinic.trainingspring.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.vetclinic.trainingspring.model.Vet;
import ro.fasttrackit.vetclinic.trainingspring.service.VetService;

import java.util.List;

@RestController
public class VetController {
    public final VetService service;

    public VetController(VetService injectedService) {
        this.service = injectedService;
    }

    @GetMapping("api/vet/{id}")
    public Vet getVetById (@PathVariable("id") Long vetId){
        return service.getVetById(vetId);
    }

    @GetMapping("api/vet")
    public List<Vet> getAllVets(){
        return service.findAllVets();
    }

    @PostMapping("/api/vet")
    public Vet createNewVet (@RequestBody Vet vetRequest){
        return service.createNewVet(vetRequest);
    }

    @PutMapping("api/vet")
    public Vet updateVet (@RequestBody Vet updateVet){
        return service.updateVet(updateVet);
    }

    @DeleteMapping("api/vet/{id}")
    public void deleteVet (@PathVariable("id") Long idToDelete){
        this.service.deleteVetById(idToDelete);
    }
}
