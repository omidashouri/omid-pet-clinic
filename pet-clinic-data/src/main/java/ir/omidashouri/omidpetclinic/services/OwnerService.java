package ir.omidashouri.omidpetclinic.services;

import ir.omidashouri.omidpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

}
