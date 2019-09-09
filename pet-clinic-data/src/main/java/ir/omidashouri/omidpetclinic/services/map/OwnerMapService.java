package ir.omidashouri.omidpetclinic.services.map;

import ir.omidashouri.omidpetclinic.model.Owner;
import ir.omidashouri.omidpetclinic.model.Pet;
import ir.omidashouri.omidpetclinic.services.OwnerService;
import ir.omidashouri.omidpetclinic.services.PetService;
import ir.omidashouri.omidpetclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    @Autowired
    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        Owner saveowner = null;

        if(null!=object){
            if(null!=object.getPets()){
                object.getPets().forEach(pet->{
                    if(null!=pet.getPetType()){
                        if(null==pet.getPetType().getId()){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(null!=pet.getId()){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }

                });
            }

            return super.save(object);
        } else{
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner->owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}
