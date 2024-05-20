package com.example.maven.service;

import com.example.maven.pojo.Trainer.Trainer;
import com.example.maven.repository.TtrainerRepository;
import com.example.maven.service.DefaultTrainerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class DefaultTrainerServiceTest {

    @InjectMocks
    private DefaultTrainerService trainerService;

    @Mock
    private TtrainerRepository ttrainerRepository;

    public DefaultTrainerServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Trainer> trainerList = Arrays.asList(new Trainer(), new Trainer());
        when(ttrainerRepository.findAll()).thenReturn(trainerList);

        List<Trainer> result = trainerService.findAll();
        assertEquals(2, result.size());

        verify(ttrainerRepository, times(1)).findAll();
    }

    @Test
    void testFindOneById() {
        Trainer trainer = new Trainer();
        when(ttrainerRepository.findTrainerById(anyInt())).thenReturn(trainer);

        Trainer result = trainerService.findOneById(1);
        assertEquals(trainer, result);

        verify(ttrainerRepository, times(1)).findTrainerById(anyInt());
    }

    @Test
    void testCreate() {
        Trainer trainer = new Trainer();
        when(ttrainerRepository.save(any(Trainer.class))).thenReturn(trainer);

        Trainer result = trainerService.create(1, "Jane", 30);
        assertEquals(trainer, result);

        verify(ttrainerRepository, times(1)).save(any(Trainer.class));
    }

    @Test
    void testEdit() {
        Trainer trainer = new Trainer();
        when(ttrainerRepository.findTrainerById(anyInt())).thenReturn(trainer);
        when(ttrainerRepository.save(any(Trainer.class))).thenReturn(trainer);

        Trainer result = trainerService.edit(1, "Jane");
        assertEquals(trainer, result);

        verify(ttrainerRepository, times(1)).findTrainerById(anyInt());
        verify(ttrainerRepository, times(1)).save(any(Trainer.class));
    }

    @Test
    void testDelete() {
        doNothing().when(ttrainerRepository).deleteById(anyInt());

        trainerService.delete(1);
        verify(ttrainerRepository, times(1)).deleteById(anyInt());
    }
}
