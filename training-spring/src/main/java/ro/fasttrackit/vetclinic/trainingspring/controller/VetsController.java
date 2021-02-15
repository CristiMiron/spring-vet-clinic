package ro.fasttrackit.vetclinic.trainingspring.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.vetclinic.trainingspring.model.Vets;
import ro.fasttrackit.vetclinic.trainingspring.service.VetsService;

import java.util.List;

@RestController
public class VetsController {
    public final VetsService service;

    public VetsController(VetsService injectedService) {
        this.service = injectedService;
    }

    @GetMapping("api/vets")
    public List<Vets> getAllVets(){
        return service.findAllVets();
    }

    @PostMapping("/api/vets")
    public Vets createNewVet (@RequestBody Vets vetsRequest){
        return service.createNewVet(vetsRequest);
    }

    @PutMapping("api/vets")
    public Vets updateVets (@RequestBody Vets updateVets){
        return service.updateVets(updateVets);
    }

    @DeleteMapping("api/vets/{id}")
    public void deleteVets (@PathVariable("id") Long idToDelete){
        this.service.deleteVetsById(idToDelete);
    }
}
