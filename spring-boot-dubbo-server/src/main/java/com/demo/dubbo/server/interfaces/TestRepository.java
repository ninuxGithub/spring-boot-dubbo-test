package com.demo.dubbo.server.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.dubbo.server.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

    public List<Test> findAll();
    
    
    public Test findById(Integer id);
}
