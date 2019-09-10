package ir.omidashouri.omidpetclinic.services;

import ir.omidashouri.omidpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
