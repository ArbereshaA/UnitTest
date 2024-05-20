package com.example.maven.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.example.maven.controller.EquipmentsController;
import com.example.maven.pojo.Equipments.CreateEquipmentsInput;
import com.example.maven.pojo.Equipments.Equipments;
import com.example.maven.service.EquipmentsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(EquipmentsController.class)
class EquipmentsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EquipmentsService equipmentsService;

    @Test
    void testGetAll() throws Exception {
        List<Equipments> equipments = Arrays.asList(new Equipments(), new Equipments());
        when(equipmentsService.findAll()).thenReturn(equipments);

        mockMvc.perform(get("/equipments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(equipments.size()));

        verify(equipmentsService, times(1)).findAll();
    }

    @Test
    void testCreate() throws Exception {
        CreateEquipmentsInput input = new CreateEquipmentsInput();
        input.setId(1);
        input.setName("Treadmill");
        input.setPrice(1000);
        input.setQuantity(5);

        Equipments equipments = new Equipments();
        equipments.setId(1); // Ensure to set ID for jsonPath expectation

        when(equipmentsService.create(anyInt(), anyString(), anyInt(), anyInt())).thenReturn(equipments);

        mockMvc.perform(post("/equipments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"Treadmill\",\"price\":1000,\"quantity\":5}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(equipments.getId()));

        verify(equipmentsService, times(1)).create(anyInt(), anyString(), anyInt(), anyInt());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(equipmentsService).delete(anyInt());

        mockMvc.perform(delete("/equipment/1"))
                .andExpect(status().isOk());

        verify(equipmentsService, times(1)).delete(anyInt());
    }
}
