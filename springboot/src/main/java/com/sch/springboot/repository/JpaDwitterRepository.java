package com.sch.springboot.repository;


import com.sch.springboot.dto.Dwitter;
import com.sch.springboot.dto.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaDwitterRepository implements DwitterRepositoryInterface {

    private final EntityManager em;

    @Autowired
    public JpaDwitterRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Dwitter> findAll(){
        return em.createQuery("select m from Dwitter m", Dwitter.class)
                .getResultList();
    }

    @Override
    public String insert(Dwitter dwitter){
        System.out.println(dwitter.getMessage());
        em.persist(dwitter);
        return dwitter.getName();
    }

    @Override
    public String delete(Long id){
        Dwitter managed = em.find(Dwitter.class, id);
        if (managed != null) {
            em.remove(managed);   // OK: managed entity
        }
        return "ok";
    }
}
