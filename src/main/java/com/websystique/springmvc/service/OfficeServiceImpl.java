package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.OfficeDao;
import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service ("officeService")
@Transactional
public class OfficeServiceImpl implements OfficeService{

    @Autowired
    private OfficeDao dao;

    @Override
    public Office findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveOffice(Office office) {
        Office entity = dao.findById(office.getId());
        if(entity!=null){
            entity.setId(office.getId());
//            if();// check admin rights
        }
        entity.setNameOffice(office.getNameOffice());
        entity.setNameOffice(office.getNameOffice());
        entity.setPostalCode(office.getPostalCode());
    }

    @Override
    public void updateOffice(Office office) {
        Office entity = dao.findById(office.getId());
        if(entity!=null){
            entity.setId(office.getId());
//            if());// check admin rights
            }
            entity.setNameOffice(office.getNameOffice());
            entity.setNameOffice(office.getNameOffice());
            entity.setPostalCode(office.getPostalCode());
        }



    @Override
    public void deleteOfficeById(int id) {
        dao.deleteOfficeById(id);
    }

    @Override
    public List<Office> findAllOffices() {
        return dao.findAllOffices();
    }
}
