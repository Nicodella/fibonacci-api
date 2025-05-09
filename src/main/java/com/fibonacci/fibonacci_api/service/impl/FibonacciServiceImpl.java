package com.fibonacci.fibonacci_api.service.impl;

import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibonacci.fibonacci_api.model.FibonacciNumber;
import com.fibonacci.fibonacci_api.repository.FibonacciRepository;
import com.fibonacci.fibonacci_api.service.FibonacciService;

@Service
public class FibonacciServiceImpl implements FibonacciService{

    @Autowired
    private FibonacciRepository repository;

    public String getFibonacci(int n) {
        return repository.findByN(n).map(fib -> {
            fib.setCantAccedidos(fib.getCantAccedidos() + 1);
            repository.save(fib);
            return fib.getValor(); 
        }).orElseGet(() -> {
            BigInteger value = calculateFibonacci(n); 
            FibonacciNumber fib = new FibonacciNumber();
            fib.setN(n);
            fib.setValor(value.toString()); 
            fib.setCantAccedidos(1);
            repository.save(fib);
            return value.toString(); 
        });
    }
    

    public BigInteger calculateFibonacci(int n) {
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger temp = b;
            b = b.add(a);
            a = temp;
        }
        return b;
    }

    public String getCantAccesos(int n) {
        return repository.findByN(n)
            .map(fib -> String.valueOf(fib.getCantAccedidos()))
            .orElse("No hay valores para el n ingresado");
    }
}

