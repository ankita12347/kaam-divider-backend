package com.ljprojects.kaam_divider.users;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UsersJPARepository {
    //when we want to make use of JPA to talk to the database , use entity manager
    // @Autowired, better use PersistenceContext, its more specific for entity manager
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Users user){
        entityManager.merge(user);
    }

    public Users findById(Long id){
        return entityManager.find(Users.class, id);
    }

    public void deleteById(Long id){
        Users user = this.findById(id);
        entityManager.remove(user);
    }
}
