package com.fibonacci.fibonacci_api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fibonacci.fibonacci_api.model.FibonacciNumber;

@SpringBootTest
public class FibonacciServiceTest {

    @Autowired
    private FibonacciService service;

    @Test
    public void testFibonacci() {
        assertEquals(BigInteger.ZERO, service.getFibonacci(0)); 
        assertEquals(BigInteger.ONE, service.getFibonacci(1));
        assertEquals(BigInteger.valueOf(1), service.getFibonacci(2));
        assertEquals(BigInteger.valueOf(1), service.getFibonacci(2));
        assertEquals(BigInteger.valueOf(2), service.getFibonacci(3));
        assertEquals(BigInteger.valueOf(3), service.getFibonacci(4));
        assertEquals(BigInteger.valueOf(3), service.getFibonacci(4));
    }
    

    @Test
    void testFibonacciNumberModel() {
        FibonacciNumber fib = new FibonacciNumber();
        fib.setId(5); 
        fib.setValor(BigInteger.valueOf(8)); 
        fib.setCantAccedidos(2); 
        assertEquals(5, fib.getId());
        assertEquals(BigInteger.valueOf(8), fib.getValor());
        assertEquals(2, fib.getCantAccedidos());
    }
    
}

