package ro.fasttrackit.vetclinic.trainingspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.vetclinic.trainingspring.model.entity.VetsEntity;

@Repository
public interface VetsRepository extends JpaRepository<VetsEntity,Long> {
}

