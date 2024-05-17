package com.example.equipmentManage.app.Repository;

import com.example.equipmentManage.app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String username);

    void deleteByUserName(String username);
}
