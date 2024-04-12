package com.example.equipmentManage.app.Service;

import com.example.equipmentManage.app.Entity.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {

    Optional<Equipment> getEquipmentById(Long id);

    Equipment createEquipment(Equipment equipment);

    Equipment updateEquipment(Long id, Equipment equipment);

    List<Equipment> getAllEquipment();

    void deleteEquipment(Long id);


}
