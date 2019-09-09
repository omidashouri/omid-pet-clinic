package ir.omidashouri.omidpetclinic.services.springdatajpa;

import ir.omidashouri.omidpetclinic.model.Owner;
import ir.omidashouri.omidpetclinic.repositories.OwnerRepository;
import ir.omidashouri.omidpetclinic.repositories.PetRepository;
import ir.omidashouri.omidpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    public static final String LAST_NAME = "Smith";


//    could run as Integration Test if has insert in database as test

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {

//        we do not need constructor for injecting ***Repository in to test class
//        because we had inject through Mockito

        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner ownerSmith = ownerSDJpaService.findByLastName(LAST_NAME);

        Assertions.assertEquals(LAST_NAME,ownerSmith.getLastName());

        verify(ownerRepository).findByLastName(LAST_NAME);

    }

    @Test
    void findAll() {

        Set<Owner> returnOwners = new HashSet<>();
        returnOwners.add(Owner.builder().id(1L).build());
        returnOwners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwners);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertNotNull(owners);

        assertEquals(2,owners.size());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerSDJpaService.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerSDJpaService.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner ownerToSave = Owner.builder().id(1L).build();

        Owner owner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(owner);

        verify(ownerRepository).save(any());

    }

    @Test
    void delete() {

        ownerSDJpaService.delete(returnOwner);

//        verify is good for here which method 'delete' has no return

        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {

        ownerSDJpaService.deleteById(1L);

//        default value for verify is 'times(1)'
        verify(ownerRepository).deleteById(anyLong());
    }
}