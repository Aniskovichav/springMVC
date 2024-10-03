package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Office;

import java.util.List;

public interface OfficeDao {

    Office findById(int id);

    void save(Office office);

    void update(int id);

    List<Office> findAllOffices();
}
