package com.fuuerzzapato.demo;

//agregar funcionalidades
//mostrar quien hizo la compra, poner un boton de confirmacion cuando el vuelto de la compra sea depositado en el fondo
//310$ que habia de antes

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
    System.out.println("Started in port 8080 \n link https:localhost:8080");
    System.out.println("String nuevo");
  }
}
// # GENERAL
// server.port=8080
// #
// # DATABASE
// spring.datasource.url=jdbc:mysql://database-1.c8rtonkbeffg.sa-east-1.rds.amazonaws.com/cursoSpring
// spring.datasource.dbname=cursoSpring
// spring.datasource.username=admin
// spring.datasource.password=prios123_!
// spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
