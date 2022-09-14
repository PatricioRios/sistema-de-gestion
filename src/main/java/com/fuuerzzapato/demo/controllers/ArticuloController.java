package com.fuuerzzapato.demo.controllers;

import java.util.List;

import com.fuuerzzapato.demo.dao.ImplArticuloDao;
import com.fuuerzzapato.demo.models.Articulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticuloController {
  @Autowired
  private ImplArticuloDao dao = new ImplArticuloDao();

  @RequestMapping(value = "api/articulos/getallArticles")
  public List<Articulo> getArticulos() {
    return dao.getAllArticles();
  }

  @RequestMapping(value = "api/articulo/getLast10")
  public List<Articulo> getLast10() {
    return dao.getAllArticles();
  }

  @RequestMapping(value = "api/articulos/eliminar/{id}", method = RequestMethod.DELETE)
  public void eliminar(@PathVariable("id") Long id) {
    System.out.println("eliminar articulo con id: " + id + " CONTROLLER");
    dao.delete(id);
  }

  @RequestMapping(value = "api/articulos", method = RequestMethod.POST)
  public void registrar(@RequestBody Articulo articulo) {
    dao.create(articulo);
  }

  @RequestMapping(value = "api/articulo{id}", method = RequestMethod.PUT)
  public void actualizar(@PathVariable("id") Long id, @RequestBody Articulo articulo) {
    articulo.setId(id);
    dao.update(articulo);
  }
}
