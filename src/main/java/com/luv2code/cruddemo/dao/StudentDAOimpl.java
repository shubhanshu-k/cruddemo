package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public Student findById(Integer id) {
     return   entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName asc", Student.class);


        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query

        TypedQuery<Student>theQuery =entityManager.createQuery("From Student where lastName=:theData",Student.class);
        //jpql parameters are prefixed with colon :
        theQuery.setParameter("theData", theLastName);

        // set query parameters

        // return query results

        return theQuery.getResultList();
    }
}




