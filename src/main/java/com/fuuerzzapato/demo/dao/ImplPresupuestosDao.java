package com.fuuerzzapato.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fuuerzzapato.demo.models.Presupuestos;

@Repository
@Transactional
public class ImplPresupuestosDao implements IPresupuestosDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Presupuestos getUnique() {
        List<Presupuestos> presupuesto = entityManager.
        createQuery("FROM Presupuestos ", Presupuestos.class).
        getResultList();
        if(presupuesto.size() >= 0){
            return presupuesto.get(0);
        }
        return null;
    }

    @Override
    public List<Presupuestos> getPresupuestos() {
        return entityManager.createQuery(
            "FROM Presupuestos ", Presupuestos.class).
            getResultList();
    }

    @Override
    public Presupuestos getPresupuestoById(long id) {
        return entityManager.createQuery(
            "FROM Prespuestos ", Presupuestos.class).getSingleResult();
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Presupuestos.class, id));
    }

    @Override
    public void create(Presupuestos presupuesto) {
        entityManager.merge(presupuesto);
    }

    @Override
    public void update(Presupuestos presupuesto) {
        entityManager.merge(presupuesto);
    }

}
