package ro.fasttrackit.vetclinic.trainingspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.vetclinic.trainingspring.model.entity.OwnerEntity;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity,Long> {
}
