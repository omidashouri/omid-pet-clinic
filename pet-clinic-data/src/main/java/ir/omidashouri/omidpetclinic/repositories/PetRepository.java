package ir.omidashouri.omidpetclinic.repositories;

import ir.omidashouri.omidpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
