package ir.omidashouri.omidpetclinic.services.map;

import ir.omidashouri.omidpetclinic.model.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

//    This is Unit Test

    OwnerMapService ownerMapService;

    final Long ownerId = 1L;
    final String lastName = "ashouriTest";

    @BeforeEach
    void setUp() {
        ownerMapService  = new OwnerMapService(new PetTypeMapService(),new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        Set<Owner> owners =  ownerMapService.findAll();

        assertEquals(1,owners.size());
    }

    @Test
    void deleteById() {

        ownerMapService.deleteById(ownerId);

        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {

        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = ownerMapService.save(owner2);
        
        assertEquals(id,savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId,owner.getId());
    }

    @Test
    void findByLastName() {
        Owner ashouri = ownerMapService.findByLastName(lastName);
        assertNotNull(ashouri);
        assertEquals(ownerId,ashouri.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner ashouri = ownerMapService.findByLastName("foo");
        assertNull(ashouri);
    }
}