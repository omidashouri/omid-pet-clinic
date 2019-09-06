package ir.omidashouri.omidpetclinic.services;

import ir.omidashouri.omidpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

}
