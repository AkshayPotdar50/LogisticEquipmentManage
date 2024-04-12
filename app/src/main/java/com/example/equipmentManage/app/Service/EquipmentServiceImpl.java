package com.example.equipmentManage.app.Service;

import com.example.equipmentManage.app.Entity.Equipment;
import com.example.equipmentManage.app.Repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService{
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Override
    public Optional<Equipment> getEquipmentById(Long id) {
        return equipmentRepository.findById(Math.toIntExact(id));
    }

    @Override
    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment updateEquipment(Long id, Equipment updatedEquipment) {
        Optional<Equipment> existingEquipmentOptional = getEquipmentById(id);

        if (existingEquipmentOptional.isPresent()) {
            Equipment existingEquipment = existingEquipmentOptional.get();
            existingEquipment.setEquipmentStatus(updatedEquipment.getEquipmentStatus());
            existingEquipment.setEquipmentType(updatedEquipment.getEquipmentType());

            return equipmentRepository.save(existingEquipment);
        } else {

            return null;
        }
    }

    @Override
    public List<Equipment> getAllEquipment() {
        List<Equipment> listOfEquip = equipmentRepository.findAll();
        return listOfEquip;
    }

    @Override
    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(Math.toIntExact(id));
        System.out.println("equipment deleted successfully");

    }
}
