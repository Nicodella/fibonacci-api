package com.fibonacci.fibonacci_api.service;

import java.math.BigInteger;

public interface FibonacciService {
    
    public BigInteger getFibonacci(int n);
    
    public int getCantAccesos(int n);
}
