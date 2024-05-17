package com.example.equipmentManage.app.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private int id;
    private String username;
    private String email;
    private boolean location;

    private String password;
    private List<Equipment> equipmentList= new ArrayList<>();
    private List<String> roles;

}
