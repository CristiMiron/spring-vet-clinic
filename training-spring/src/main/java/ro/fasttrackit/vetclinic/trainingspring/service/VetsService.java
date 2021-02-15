package ro.fasttrackit.vetclinic.trainingspring.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.vetclinic.trainingspring.model.Vets;
import ro.fasttrackit.vetclinic.trainingspring.model.entity.VetsEntity;
import ro.fasttrackit.vetclinic.trainingspring.repository.VetsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VetsService {
    private final VetsRepository repository;

    public VetsService(VetsRepository injectedRepository){
        this.repository=injectedRepository;
    }

    private Vets getVets(VetsEntity entity) {
        Vets vets = new Vets();
        vets.setId(entity.getId());
        vets.setFirstname(entity.getFirstname());
        vets.setLastname(entity.getLastname());
        vets.setCNP(entity.getCNP());
        vets.setYearOfGraduation(entity.getYearOfGraduation());
        vets.setSpecialization(entity.getSpecialization());
        vets.setPhoneNumber(entity.getPhoneNumber());
        vets.setEmail(entity.getEmail());

        return vets;
    }

    public List<Vets> findAllVets(){
        return this.repository.findAll()
                .stream()
                .map(entity -> {
                    Vets vets = getVets(entity);
                    return vets;
                })
                .collect(Collectors.toList());
    }

    public Vets createNewVet(Vets request){
        VetsEntity newVet = new VetsEntity();
        newVet.setId(request.getId());
        newVet.setFirstname(request.getFirstname());
        newVet.setLastname(request.getLastname());
        newVet.setCNP(request.getCNP());
        newVet.setYearOfGraduation(request.getYearOfGraduation());
        newVet.setSpecialization(request.getSpecialization());
        newVet.setPhoneNumber(request.getPhoneNumber());
        newVet.setEmail(request.getEmail());

        VetsEntity savedEntity = this.repository.save(newVet);

        Vets responseObject = getVets(savedEntity);

        return responseObject;
    }

    public Vets updateVets(Vets req){
        VetsEntity entityToUpdate = new VetsEntity();
        entityToUpdate.setId(req.getId());
        entityToUpdate.setFirstname(req.getFirstname());
        entityToUpdate.setLastname(req.getLastname());
        entityToUpdate.setCNP(req.getCNP());
        entityToUpdate.setYearOfGraduation(req.getYearOfGraduation());
        entityToUpdate.setSpecialization(req.getSpecialization());
        entityToUpdate.setPhoneNumber(req.getPhoneNumber());
        entityToUpdate.setEmail(req.getEmail());

        VetsEntity updateEntity = this.repository.save(entityToUpdate);
        Vets response = getVets(updateEntity);

        return response;
    }
    public void deleteVetsById(Long id){
        this.repository.deleteById(id);
    }
}
