package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.OfficeDao;
import com.websystique.springmvc.model.Office;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service ("officeService")
@Transactional
public class OfficeServiceImpl implements OfficeService{

    @Autowired
    private OfficeDao dao;

    static final Logger logger = LoggerFactory.getLogger(OfficeServiceImpl.class);

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
        entity.setName(office.getName());
        entity.setName(office.getName());
        entity.setPostalCode(office.getPostalCode());
    }

    @Override
    public void updateOffice(Office office) {
        Office entity = dao.findById(office.getId());
        if(entity!=null){
            entity.setId(office.getId());
//            if());// check admin rights
            }
            entity.setName(office.getName());
            entity.setName(office.getName());
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
