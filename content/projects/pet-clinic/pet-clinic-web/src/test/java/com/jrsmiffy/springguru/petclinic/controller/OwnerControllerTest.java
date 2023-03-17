package com.jrsmiffy.springguru.petclinic.controller;

import com.jrsmiffy.springguru.petclinic.model.Owner;
import com.jrsmiffy.springguru.petclinic.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

//@AutoConfigureMockMvc // Note: might be a useful annotation
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock OwnerService ownerService;

    @InjectMocks OwnerController underTest;

    Set<Owner> owners;

    MockMvc mockMvc;

    private final Long firstOwnerId = 1L;
    private final Long secondOwnerId = 2L;

    @BeforeEach
    void setUp() {
        owners = Set.of(
                Owner.builder().id(firstOwnerId).build(),
                Owner.builder().id(secondOwnerId).build()
        );

        mockMvc = MockMvcBuilders
                .standaloneSetup(underTest) // Note: lightweight setup
                .build();
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owner/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/findOwners"))
                .andExpect(model().attributeExists("owner"));

        verifyNoInteractions(ownerService);
    }

    @Test
    void processFindFormReturnMany() throws Exception {
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(List.of(Owner.builder().id(firstOwnerId).build(),
                        Owner.builder().id(secondOwnerId).build()));

        mockMvc.perform(get("/owner"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    void processFindFormReturnOne() throws Exception {
        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(List.of(Owner.builder().id(firstOwnerId).build()));

        mockMvc.perform(get("/owner"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owner/" + firstOwnerId));
    }

    @Test
    void processFindFormEmptyReturnMany() throws Exception {
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(List.of(Owner.builder().id(firstOwnerId).build(),
                        Owner.builder().id(secondOwnerId).build()));

        mockMvc.perform(get("/owner")
                        .param("lastName",""))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));;
    }

    @Test
    void displayOwner() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(firstOwnerId).build());

        mockMvc.perform(get("/owner/" + firstOwnerId)) // Note :: note any {id} can be used b.c we mock the service call
                .andExpect(status().isOk())
                .andExpect(view().name("owner/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(firstOwnerId))));
    }
    // Note :: IntelliJ running old version of test (not taking up changes) - soln: invalidate cache, then delete .idea if nec
    // Note :: https://stackoverflow.com/questions/73735539/intellij-runs-old-version-of-tests-and-will-not-compile

    @Disabled @Test
    void initCreationForm() throws Exception {
        mockMvc.perform(get("/owner/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));

        verifyNoInteractions(ownerService);
    }

    @Disabled @Test
    void processCreationForm() throws Exception {
        when(ownerService.save(any())).thenReturn(Owner.builder().id(firstOwnerId).build());

        mockMvc.perform(post("/owner/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owner/1"))
                .andExpect(model().attributeExists("owner"));

        verify(ownerService).save(any());
    }

    @Disabled @Test
    void initUpdateOwnerForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(firstOwnerId).build());

        mockMvc.perform(get("/owner/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));

        verifyNoInteractions(ownerService);
    }

    @Disabled @Test
    void processUpdateOwnerForm() throws Exception {
        when(ownerService.save(any())).thenReturn(Owner.builder().id(firstOwnerId).build());

        mockMvc.perform(post("/owner/" + firstOwnerId + "/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owner/" + firstOwnerId))
                .andExpect(model().attributeExists("owner"));

        verify(ownerService).save(any());
    }
}