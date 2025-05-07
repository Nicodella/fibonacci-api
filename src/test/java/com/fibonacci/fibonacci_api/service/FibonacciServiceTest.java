package com.fibonacci.fibonacci_api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(2, service.getFibonacci(2));
        assertEquals(3, service.getFibonacci(3));
        assertEquals(5, service.getFibonacci(4));
    }

    @Test
    void testFibonacciNumberModel() {
        FibonacciNumber fib = new FibonacciNumber();
        fib.setId(5);
        fib.setValor(8L);
        fib.setCantAccedidos(2);

        assertEquals(5, fib.getId());
        assertEquals(8L, fib.getValor());
        assertEquals(2, fib.getCantAccedidos());
    }
}

