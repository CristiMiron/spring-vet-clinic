package ro.fasttrackit.vetclinic.trainingspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.vetclinic.trainingspring.model.entity.VetEntity;

@Repository
public interface VetRepository extends JpaRepository<VetEntity,Long> {
}

