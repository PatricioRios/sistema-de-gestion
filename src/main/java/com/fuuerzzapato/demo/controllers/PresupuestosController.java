package com.fuuerzzapato.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fuuerzzapato.demo.dao.ImplPresupuestosDao;
import com.fuuerzzapato.demo.models.Presupuestos;

@RestController
public class PresupuestosController {

    @Autowired
    private ImplPresupuestosDao dao = new ImplPresupuestosDao();

    @RequestMapping(value = "api/presupuestos/getpresupuestos")
    public List<Presupuestos> getPresupuestos() {
        return dao.getPresupuestos();
    }

    @RequestMapping(value = "presupuestos/getpresupuesto{id}", method = RequestMethod.GET)
    public Presupuestos getPresupuestosById(@PathVariable("id") Long id) {

        return dao.getPresupuestoById(id);

    }

    @RequestMapping(value = "api/presupuesto/unique", method = RequestMethod.DELETE)
    public Presupuestos getUnique() {
        return dao.getUnique();
    }

    //@RequestMapping(value = "presupuestos/delete{id}", method = RequestMethod.DELETE)
    //public void eliminar(@PathVariable("id") Long id) {
    //    dao.delete(id);
    //}

    //@RequestMapping(value = "presupuestos/registrar", method = RequestMethod.POST)
    //public void registrar(@RequestBody Presupuestos presupuestos) {
    //    dao.create(presupuestos);
    //}

    @RequestMapping(value = "presupuestos/update{id}", method = RequestMethod.PUT)
    public void actualizar(@PathVariable("id") Long id, @RequestBody Presupuestos presupuestos) {
        presupuestos.setId(id);
        dao.update(presupuestos);
    }
}
