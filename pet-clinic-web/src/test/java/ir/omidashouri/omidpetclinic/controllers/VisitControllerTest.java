package ir.omidashouri.omidpetclinic.controllers;

import ir.omidashouri.omidpetclinic.model.Owner;
import ir.omidashouri.omidpetclinic.model.Pet;
import ir.omidashouri.omidpetclinic.model.PetType;
import ir.omidashouri.omidpetclinic.services.PetService;
import ir.omidashouri.omidpetclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith({MockitoExtension.class})
class VisitControllerTest {

    private static final String PETS_CREATE_OR_UPDATE_VISIT_FORM = "pets/createOrUpdateVisitForm";
    private static final String REDIRECT_OWNERS_1 = "redirect:/owners/{ownerId}";
    private static final String YET_ANOTHER_VISIT_DESCRIPTION = "yet another visit";

    @Mock
    VisitService visitService;

    @Mock
    PetService petService;

    @InjectMocks
    VisitController visitController;

    MockMvc mockMvc;

    private final UriTemplate visitUriTemplate = new UriTemplate("/owners/{ownerId}/pets/{petId}/visits/new");
    private final Map<String,String> uriVariable = new HashMap<>();
    private URI visitsUri;


    @BeforeEach
    void setUp() {

        Long petId= 1L;
        Long ownerId = 1L;

        when(petService.findById(anyLong()))
                .thenReturn(
                        Pet.builder()
                        .id(petId)
                        .birthDate(LocalDate.of(2018,11,13))
                        .name("omidPetName")
                        .visits(new HashSet<>())
                        .owner(Owner.builder()
                                .id(ownerId)
                                .lastName("omidOwnerLastName")
                                .firstName("omidOwnerFirstName")
                                .build())
                        .petType(PetType.builder()
                                .name("omidPetTypeName")
                                .build())
                        .build()
                );

        uriVariable.clear();
        uriVariable.put("ownerId",ownerId.toString());
        uriVariable.put("petId",petId.toString());
        visitsUri = visitUriTemplate.expand(uriVariable);


        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();

    }

    @Test
    void processNewVisitForm() throws Exception {
        mockMvc.perform(post(visitsUri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("date","2018-11-11")
                .param("description", YET_ANOTHER_VISIT_DESCRIPTION))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name(REDIRECT_OWNERS_1))
                .andExpect(model().attributeExists("visit"))
        ;
    }
}