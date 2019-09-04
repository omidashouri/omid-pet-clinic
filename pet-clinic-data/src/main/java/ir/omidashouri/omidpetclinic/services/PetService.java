package ir.omidashouri.omidpetclinic.services;

import ir.omidashouri.omidpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
