package com.fuuerzzapato.demo.models;

import javax.persistence.*;

import lombok.Data;

//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;

@Data
@Entity
@Table(name = "presupuesto")
public class Presupuestos {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")    
    private long id;
    
    @Column(name = "cantidadinicial")
    private int cantidadInicial;

    @Column(name = "cantidadactual")
    private int cantidadActual;

    @Column(name = "gastototal")
    private int gastoTotal;

    @Column(name = "sobro")
    private int sobro;

    @Column(name = "aplicado")
    private int aplicado;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "mes")
    private String mes;

}
