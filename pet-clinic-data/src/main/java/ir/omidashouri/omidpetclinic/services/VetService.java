package ir.omidashouri.omidpetclinic.services;

import ir.omidashouri.omidpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
