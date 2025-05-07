package com.fibonacci.fibonacci_api.model;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FibonacciNumber implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private Integer n;

    private Long value;

    private Integer accessCount = 0;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Integer getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Integer accessCount) {
        this.accessCount = accessCount;
    }


    
}
