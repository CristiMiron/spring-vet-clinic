package ro.fasttrackit.vetclinic.trainingspring.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.vetclinic.trainingspring.model.Vet;
import ro.fasttrackit.vetclinic.trainingspring.model.entity.VetEntity;
import ro.fasttrackit.vetclinic.trainingspring.repository.VetRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VetService {
    private final VetRepository repository;

    public VetService(VetRepository injectedRepository){
        this.repository=injectedRepository;
    }

    private Vet getVet(VetEntity entity) {
        Vet Vet = new Vet();
        Vet.setId(entity.getId());
        Vet.setFirstname(entity.getFirstname());
        Vet.setLastname(entity.getLastname());
        Vet.setCnp(entity.getCnp());
        Vet.setYearOfGraduation(entity.getYearOfGraduation());
        Vet.setSpecialization(entity.getSpecialization());
        Vet.setPhoneNumber(entity.getPhoneNumber());
        Vet.setEmail(entity.getEmail());

        return Vet;
    }

    public List<Vet> findAllVets(){
        return this.repository.findAll()
                .stream()
                .map(entity -> {
                    Vet Vet = getVet(entity);
                    return Vet;
                })
                .collect(Collectors.toList());
    }

    public Vet getVetById(Long vetId){
        Optional<VetEntity> foundEntity = repository.findById(vetId);

        if(!foundEntity.isPresent()){
            return null;
        }

        return foundEntity
                .map(entityToMap -> {
                    Vet response = getVet(entityToMap);
                    return response;
                })
                .get();
    }

    public Vet createNewVet(Vet request){
        VetEntity newVet = new VetEntity();
        newVet.setId(request.getId());
        newVet.setFirstname(request.getFirstname());
        newVet.setLastname(request.getLastname());
        newVet.setCnp(request.getCnp());
        newVet.setYearOfGraduation(request.getYearOfGraduation());
        newVet.setSpecialization(request.getSpecialization());
        newVet.setPhoneNumber(request.getPhoneNumber());
        newVet.setEmail(request.getEmail());

        VetEntity savedEntity = this.repository.save(newVet);

        Vet responseObject = getVet(savedEntity);

        return responseObject;
    }

    public Vet updateVet(Vet req){
        VetEntity entityToUpdate = new VetEntity();
        entityToUpdate.setId(req.getId());
        entityToUpdate.setFirstname(req.getFirstname());
        entityToUpdate.setLastname(req.getLastname());
        entityToUpdate.setCnp(req.getCnp());
        entityToUpdate.setYearOfGraduation(req.getYearOfGraduation());
        entityToUpdate.setSpecialization(req.getSpecialization());
        entityToUpdate.setPhoneNumber(req.getPhoneNumber());
        entityToUpdate.setEmail(req.getEmail());

        VetEntity updateEntity = this.repository.save(entityToUpdate);
        Vet response = getVet(updateEntity);

        return response;
    }
    public void deleteVetById(Long id){
        this.repository.deleteById(id);
    }
}
