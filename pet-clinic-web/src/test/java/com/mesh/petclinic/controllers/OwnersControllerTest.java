package com.mesh.petclinic.controllers;

import com.mesh.petclinic.model.Owner;
import com.mesh.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnersControllerTest {

    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnersController controller;
    Set<Owner> owners;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1l).build());
        owners.add(Owner.builder().id(2l).build());
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getById_happyPath() throws Exception {
        Long id = 1L;
        when(ownerService.findById(eq(id))).thenReturn(Owner.builder().id(id).build());

        mockMvc.perform(get(String.format("/owners/%d", id)))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(id))));
    }

    @Test
    void getById_throwException() throws Exception {
        Long id = 123L;
        when(ownerService.findById(anyLong())).thenReturn(null);

        mockMvc.perform(get(String.format("/owners/%d", id)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void find_happyPath() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));
    }

    @Test
    void processFindForm_emptyLastName() throws Exception {
        when(ownerService.findAllByLastName("")).thenReturn(Collections.EMPTY_LIST);

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"));
    }

    @Test
    void processFindForm_oneOwner() throws Exception {
        Long id = 1L;
        when(ownerService.findAllByLastName("")).thenReturn(List.of(Owner.builder().id(id).build()));

        mockMvc.perform(get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name(String.format("redirect:/owners/%s", id)));
    }

    @Test
    void processFindForm_moreOwners() throws Exception {
        var id = 1L;
        when(ownerService.findAllByLastName("")).thenReturn(
                List.of(
                        Owner.builder().id(id).build(),
                        Owner.builder().id(id + 1).build(),
                        Owner.builder().id(id + 2).build()
                )
        );

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attributeExists("selections"));
    }
}