package com.fibonacci.fibonacci_api.model;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fibonacci_numbers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FibonacciNumber implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fibo_id")
    private int id;

    @Column(name = "fibo_n")
    private int n;

    @Column(name = "fibo_valor")
    private String valor;

    @Column(name = "fibo_cant_accedido")
    private int cantAccedidos = 0;

}
