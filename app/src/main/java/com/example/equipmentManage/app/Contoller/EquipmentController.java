package com.example.equipmentManage.app.Contoller;

import com.example.equipmentManage.app.Entity.Equipment;
import com.example.equipmentManage.app.Service.EquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equip")
public class EquipmentController {
    @Autowired
    EquipmentServiceImpl equipmentService;
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Equipment>> getEquipmentByID(@PathVariable Long id){
   Optional<Equipment> equipment= equipmentService.getEquipmentById(id);
   return new ResponseEntity<>(equipment, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equipment){
    Equipment createdEquipment =equipmentService.createEquipment(equipment);
    return new ResponseEntity<>(createdEquipment, HttpStatus.CREATED);
    }
    @GetMapping("/findall")
    public ResponseEntity<List<Equipment>> getAllEquipments(){
    List<Equipment> List1 =equipmentService.getAllEquipment();
return new ResponseEntity<>(List1, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable Long id, @RequestBody Equipment equipment){
    Equipment updated =equipmentService.updateEquipment(id, equipment);
    return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id){
    equipmentService.getEquipmentById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
