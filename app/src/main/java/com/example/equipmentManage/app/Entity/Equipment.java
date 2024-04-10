package com.example.equipmentManage.app.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name="Equipment")
public class Equipment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int equipmentId;
    private String equipmentType;
    private String equipmentStatus;

    public Equipment(int equipmentId, String equipmentType, String equipmentStatus) {
        this.equipmentId = equipmentId;
        this.equipmentType = equipmentType;
        this.equipmentStatus = equipmentStatus;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId=" + equipmentId +
                ", equipmentType='" + equipmentType + '\'' +
                ", equipmentStatus='" + equipmentStatus + '\'' +
                '}';
    }
}
