package ir.omidashouri.omidpetclinic.services.map;

import ir.omidashouri.omidpetclinic.model.Speciality;
import ir.omidashouri.omidpetclinic.model.Vet;
import ir.omidashouri.omidpetclinic.services.SpecialtyService;
import ir.omidashouri.omidpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    @Autowired
    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size()>0){
            object.getSpecialities().forEach(specialty->{
                if(specialty.getId()==null){
                    Speciality savedSpeciality = specialtyService.save(specialty);
                    specialty.setId(savedSpeciality.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
