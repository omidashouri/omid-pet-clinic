package ir.omidashouri.omidpetclinic.services.map;

import ir.omidashouri.omidpetclinic.model.PetType;
import ir.omidashouri.omidpetclinic.services.PetTypeServce;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType,Long> implements PetTypeServce {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
         super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);

    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
