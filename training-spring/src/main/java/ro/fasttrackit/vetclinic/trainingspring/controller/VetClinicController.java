package ro.fasttrackit.vetclinic.trainingspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VetClinicController {

    @GetMapping("/api/salut")
    public String getHelloMessage(){
        return "Welcome to Vet Clinic!";
    }
}
