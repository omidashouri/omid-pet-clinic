package ir.omidashouri.omidpetclinic.repositories;

import ir.omidashouri.omidpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
