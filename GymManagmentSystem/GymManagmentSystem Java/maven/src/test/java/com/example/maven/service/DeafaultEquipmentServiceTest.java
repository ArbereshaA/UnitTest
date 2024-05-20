package com.example.maven.service;
import com.example.maven.pojo.Equipments.Equipments;
import com.example.maven.repository.EquipmentsRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DeafaultEquipmentServiceTest {

    @InjectMocks
    private DeafaultEquipmentService equipmentsService;

    @Mock
    private EquipmentsRepository equipmentsRepository;

    public DeafaultEquipmentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Equipments> equipmentsList = Arrays.asList(new Equipments(), new Equipments());
        when(equipmentsRepository.findAll()).thenReturn(equipmentsList);

        List<Equipments> result = equipmentsService.findAll();
        assertEquals(2, result.size());

        verify(equipmentsRepository, times(1)).findAll();
    }

    @Test
    void testCreate() {
        Equipments equipment = new Equipments();
        when(equipmentsRepository.save(any(Equipments.class))).thenReturn(equipment);

        Equipments result = equipmentsService.create(1, "Treadmill", 1000, 5);
        assertEquals(equipment, result);

        verify(equipmentsRepository, times(1)).save(any(Equipments.class));
    }

    @Test
    void testDelete() {
        doNothing().when(equipmentsRepository).deleteById(anyInt());

        equipmentsService.delete(1);
        verify(equipmentsRepository, times(1)).deleteById(anyInt());
    }
}
