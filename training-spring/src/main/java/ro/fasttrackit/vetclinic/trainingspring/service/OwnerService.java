package ro.fasttrackit.vetclinic.trainingspring.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.vetclinic.trainingspring.model.Owner;
import ro.fasttrackit.vetclinic.trainingspring.model.entity.OwnerEntity;
import ro.fasttrackit.vetclinic.trainingspring.repository.OwnerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    private final OwnerRepository repository;

    public OwnerService(OwnerRepository injectedRepository){ this.repository = injectedRepository;}

    private Owner getOwner(OwnerEntity entity) {
        Owner owner = new Owner();
        owner.setId(entity.getId());
        owner.setFirstname(entity.getFirstname());
        owner.setLastname(entity.getLastname());
        owner.setCNP(entity.getCNP());
        owner.setPhoneNumber(entity.getPhoneNumber());
        owner.setEmail(entity.getEmail());

        return owner;
    }

    public List<Owner> findAllOwners(){
        return this.repository.findAll()
                .stream()
                .map(entity -> {
                    Owner owner = getOwner(entity);
                    return owner;
                })
                .collect(Collectors.toList());
    }

    public Owner createNewOwner(Owner request){
        OwnerEntity newOwner = new OwnerEntity();
        newOwner.setId(request.getId());
        newOwner.setFirstname(request.getFirstname());
        newOwner.setLastname(request.getLastname());
        newOwner.setCNP(request.getCNP());
        newOwner.setPhoneNumber(request.getPhoneNumber());
        newOwner.setEmail(request.getEmail());

        OwnerEntity savedEntity = this.repository.save(newOwner);

        Owner responseObject = getOwner(savedEntity);

        return responseObject;
    }

    public Owner updateOwner(Owner req){
        OwnerEntity entityToUpdate = new OwnerEntity();
        entityToUpdate.setId(req.getId());
        entityToUpdate.setFirstname(req.getFirstname());
        entityToUpdate.setLastname(req.getLastname());
        entityToUpdate.setCNP(req.getCNP());
        entityToUpdate.setPhoneNumber(req.getPhoneNumber());
        entityToUpdate.setEmail(req.getEmail());

        OwnerEntity updateEntity = this.repository.save(entityToUpdate);
        Owner response = getOwner(updateEntity);

        return response;
    }
    public void deleteOwnerById(Long id){
        this.repository.deleteById(id);
    }
}
