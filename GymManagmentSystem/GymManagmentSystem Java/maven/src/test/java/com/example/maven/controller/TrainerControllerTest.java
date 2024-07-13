package com.example.maven.controller;

import com.example.maven.controller.TrainerController;
import com.example.maven.pojo.Trainer.CreateTrainerInput;
import com.example.maven.pojo.Trainer.EditTrainerInput;
import com.example.maven.pojo.Trainer.Trainer;
import com.example.maven.service.TrainerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TrainerController.class)
class TrainerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrainerService trainerService;

    @Test
    void testGetAll() throws Exception {
        List<Trainer> trainers = Arrays.asList(new Trainer(), new Trainer());
        when(trainerService.findAll()).thenReturn(trainers);

        mockMvc.perform(get("/trainer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(trainers.size()));

        verify(trainerService, times(1)).findAll();
    }

    @Test
    void testGetOneById() throws Exception {
        Trainer trainer = new Trainer();
        when(trainerService.findOneById(1)).thenReturn(trainer);

        mockMvc.perform(get("/trainer/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(trainer.getId()));

        verify(trainerService, times(1)).findOneById(1);
    }

    @Test
    void testCreate() throws Exception {
        CreateTrainerInput input = new CreateTrainerInput();
        input.setId(1);
        input.setName("John");
        input.setAge(30);

        Trainer trainer = new Trainer();
        when(trainerService.create(anyInt(), anyString(), anyInt())).thenReturn(trainer);

        mockMvc.perform(post("/trainer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"John\",\"age\":30}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(trainer.getId()));

        verify(trainerService, times(1)).create(anyInt(), anyString(), anyInt());
    }

    @Test
    void testEdit() throws Exception {
        EditTrainerInput input = new EditTrainerInput();
        input.setName("John");

        Trainer trainer = new Trainer();
        when(trainerService.edit(anyInt(), anyString())).thenReturn(trainer);

        mockMvc.perform(put("/trainer/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(trainer.getId()));

        verify(trainerService, times(1)).edit(anyInt(), anyString());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(trainerService).delete(anyInt());

        mockMvc.perform(delete("/trainer/1"))
                .andExpect(status().isOk());

        verify(trainerService, times(1)).delete(anyInt());
    }
}
