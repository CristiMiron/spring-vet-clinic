package ro.fasttrackit.vetclinic.trainingspring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.fasttrackit.vetclinic.trainingspring.model.Pet;
import ro.fasttrackit.vetclinic.trainingspring.model.entity.PetEntity;
import ro.fasttrackit.vetclinic.trainingspring.repository.PetRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class PetServiceTest {
    @InjectMocks
    private PetService service;
    @Mock
    private PetRepository repository;

    @Test
    public void createNewPet_expectedRepositorySavedMethodCalled(){
        Pet petRequest = new Pet();
        Mockito.when(this.repository.save(ArgumentMatchers.any(PetEntity.class))).thenReturn(new PetEntity());

        this.service.createNewPet(petRequest);

        Mockito.verify(repository).save(ArgumentMatchers.any(PetEntity.class));
    }

    @Test
    public void updatePet_expectedRepositorySavedMethodCalled(){
        Pet updatePet = new Pet();
        Mockito.when(this.repository.save(ArgumentMatchers.any(PetEntity.class))).thenReturn(new PetEntity());

        this.service.updatePet(updatePet);

        Mockito.verify(repository).save(ArgumentMatchers.any(PetEntity.class));
    }

}