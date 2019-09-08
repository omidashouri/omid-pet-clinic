package ir.omidashouri.omidpetclinic.services.springdatajpa;

import ir.omidashouri.omidpetclinic.model.Pet;
import ir.omidashouri.omidpetclinic.repositories.PetRepository;
import ir.omidashouri.omidpetclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class PetSDJpaService implements PetService {

    @Autowired
    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    private final PetRepository petRepository;


    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
