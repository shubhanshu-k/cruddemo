package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOimpl implements StudentDAO {

//define field for entity manager
    private EntityManager entityManager;


    @Autowired
    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // inject entity manager
    //implement save method
@Transactional
    @Override
    public void save(Student theStudent) {
     entityManager.persist(theStudent);
    }
}




