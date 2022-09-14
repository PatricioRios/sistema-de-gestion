package com.fuuerzzapato.demo.dao;

import java.util.List;
import com.fuuerzzapato.demo.models.Presupuestos;


public interface IPresupuestosDao {

    Presupuestos getUnique();
    
    List<Presupuestos> getPresupuestos();

    public Presupuestos getPresupuestoById(long id);
    
    void delete(Long id);

    void create(Presupuestos usuario);

    void update(Presupuestos usuario);

}
