package com.fuuerzzapato.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fuuerzzapato.demo.models.Articulo;
import com.fuuerzzapato.demo.models.Presupuestos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ImplArticuloDao implements IArticuloDao {

  @Autowired
  private ImplPresupuestosDao dao = new ImplPresupuestosDao();

  @PersistenceContext
  private EntityManager entityManager;

  // this function get all Articles in the database
  @Override
  @Transactional
  public List<Articulo> getAllArticles() {
    return entityManager.createQuery("FROM Articulo ", Articulo.class).getResultList();
  }

  @Override
  public List<Articulo> getNotTop10() {
    List<Articulo> articulos = getAllArticles();
    List<Articulo> returnList = new ArrayList<Articulo>();
    for (int i = 0; i < 10; i++) {
      System.out.println("returnList.add(" + articulos.get(articulos.size() - i) + ")");
      returnList.add(articulos.get(articulos.size() - i));
    }
    return returnList;
  }

  @Override
  public void delete(Long id) {
    List<Presupuestos> data = dao.getPresupuestos();
    Articulo articulo = new Articulo();
    List<Articulo> articulos = getAllArticles();

    for (Articulo a : articulos) {
      if (a.getId() == id) {
        articulo = a;
        break;
      }
    }
    data.get(0).setCantidadActual(data.get(0).getCantidadActual() + articulo.getPrecio());
    data.get(0).setGastoTotal(data.get(0).getGastoTotal() - articulo.getPrecio());

    dao.update(data.get(0));

    System.out.println("Articulo eliminado!!!!!!!!!");

    Articulo articuloDelete = entityManager.find(Articulo.class, id);
    entityManager.remove(articuloDelete);
  }

  @Override
  public void create(Articulo articulo) {

    List<Presupuestos> data = dao.getPresupuestos();
    data.get(0).setCantidadActual(data.get(0).getCantidadActual() - articulo.getPrecio());
    data.get(0).setGastoTotal(data.get(0).getGastoTotal() + articulo.getPrecio());
    dao.update(data.get(0));
    entityManager.merge(articulo);

  }

  @Override
  public void update(Articulo articulo) {
    entityManager.merge(articulo);
  }
}
