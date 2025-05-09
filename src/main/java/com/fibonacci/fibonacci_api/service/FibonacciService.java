package com.fibonacci.fibonacci_api.service;

import java.util.Optional;

import com.fibonacci.fibonacci_api.model.FibonacciNumber;

public interface FibonacciService {
    
    public String getFibonacci(int n);
    
    public String getCantAccesos(int n);

    public Optional<FibonacciNumber> getMasAccedido();

}
