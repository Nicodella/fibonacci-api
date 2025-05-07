package com.fibonacci.fibonacci_api.model;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fibonacci_numbers")
public class FibonacciNumber implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fibo_id")
    private Integer id;

    @Column(name = "fibo_valor")
    private Long valor;

    @Column(name = "fibo_cant_accedido")
    private Integer cantAccedidos = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Integer getCantAccedidos() {
        return cantAccedidos;
    }

    public void setCantAccedidos(Integer cantAccedidos) {
        this.cantAccedidos = cantAccedidos;
    }
}
