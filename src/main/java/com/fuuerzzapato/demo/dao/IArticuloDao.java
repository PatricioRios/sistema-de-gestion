package com.fuuerzzapato.demo.dao;


import java.util.List;
import com.fuuerzzapato.demo.models.Articulo;

public interface IArticuloDao {

    List<Articulo> getAllArticles();

    List<Articulo> getNotTop10();


    void delete(Long id);

    void create(Articulo usuario);

    void update(Articulo usuario);

}
