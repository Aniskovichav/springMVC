package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository ("officeDao")
public class OfficeDaoImpl extends AbstractDao<Integer, Office> implements OfficeDao {

    static final Logger logger = LoggerFactory.getLogger(OfficeDaoImpl.class);
    @Override
    public Office findById(int id) {
        Office office = getByKey(id);
        if (office != null){
            Hibernate.initialize(office.getId());
        }
        return office;
    }

    @Override
    public void save(Office office) {

    }

    @Override
    public void edit(int id) {
        Office office = findById(id);
        if (office != null){
            office.setName(office.getName());
            office.setAddress(office.getAddress());
            office.setPostalCode(office.getPostalCode());
        }
    }

    @Override
    public void deleteOfficeById(int id) {

        Office office = findById(id);
        if(office != null){
            delete(office);
        }
    }

    @Override
    public List<Office> findAllOffices() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("address"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Office> offices = (List<Office>) criteria.list();
        return offices;
    }
}
