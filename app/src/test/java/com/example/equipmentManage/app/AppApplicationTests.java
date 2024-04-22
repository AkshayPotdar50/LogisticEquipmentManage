package com.example.equipmentManage.app;

import com.example.equipmentManage.app.Entity.Equipment;
import com.example.equipmentManage.app.Repository.EquipmentRepository;
import com.example.equipmentManage.app.Service.EquipmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class AppApplicationTests {


	@ExtendWith(MockitoExtension.class)
	public static class EquipmentServiceImplTest {

		@Mock
		private EquipmentRepository equipmentRepository;

		@InjectMocks
		private EquipmentServiceImpl equipmentService;

		@Test
		public void testGetEquipmentById_ExistingId() {
			// Arrange
			Equipment expectedEquipment = new Equipment();
			expectedEquipment.setId(1L);
			when(equipmentRepository.findById(1)).thenReturn(Optional.of(expectedEquipment));

			// Act
			Optional<Equipment> result = equipmentService.getEquipmentById(1L);

			// Assert
			assertTrue(result.isPresent());
			assertEquals(expectedEquipment, result.get());
		}

		@Test
		public void testGetEquipmentById_NonExistingId() {
			// Arrange
			when(equipmentRepository.findById(1)).thenReturn(Optional.empty());

			// Act
			Optional<Equipment> result = equipmentService.getEquipmentById(1L);

			// Assert
			assertFalse(result.isPresent());
		}

		@Test
		public void testCreateEquipment() {
			// Arrange
			Equipment equipment = new Equipment();
			when(equipmentRepository.save(equipment)).thenReturn(equipment);

			// Act
			Equipment result = equipmentService.createEquipment(equipment);

			// Assert
			assertEquals(equipment, result);
		}

		@Test
		public void testUpdateEquipment_ExistingId() {
			// Arrange
			Equipment existingEquipment = new Equipment();
			existingEquipment.setId(1L);
			Equipment updatedEquipment = new Equipment();
			updatedEquipment.setId(1L);
			updatedEquipment.setEquipmentStatus("Updated Status");
			updatedEquipment.setEquipmentType("Updated Type");
			when(equipmentRepository.findById(1)).thenReturn(Optional.of(existingEquipment));
			when(equipmentRepository.save(existingEquipment)).thenReturn(existingEquipment);

			// Act
			Equipment result = equipmentService.updateEquipment(1L, updatedEquipment);

			// Assert
			assertEquals("Updated Status", result.getEquipmentStatus());
			assertEquals("Updated Type", result.getEquipmentType());
		}

		@Test
		public void testGetAllEquipment() {
			// Arrange
			List<Equipment> equipmentList = new ArrayList<>();
			equipmentList.add(new Equipment());
			when(equipmentRepository.findAll()).thenReturn(equipmentList);

			// Act
			List<Equipment> result = equipmentService.getAllEquipment();

			// Assert
			assertEquals(equipmentList.size(), result.size());
			assertEquals(equipmentList.get(0), result.get(0));
		}

		@Test
		public void testDeleteEquipment() {
			// Arrange
			doNothing().when(equipmentRepository).deleteById(1);

			// Act & Assert
			assertDoesNotThrow(() -> equipmentService.deleteEquipment(1L));
			verify(equipmentRepository, times(1)).deleteById(1);
		}
	}
}