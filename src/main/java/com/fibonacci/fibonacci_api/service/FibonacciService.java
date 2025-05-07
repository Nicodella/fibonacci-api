package com.fibonacci.fibonacci_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibonacci.fibonacci_api.model.FibonacciNumber;
import com.fibonacci.fibonacci_api.repository.FibonacciRepository;

@Service
public class FibonacciService {

    @Autowired
    private FibonacciRepository repository;

    public long getFibonacci(int n) {
        return repository.findById(n).map(fib -> {
            fib.setAccessCount(fib.getAccessCount() + 1);
            repository.save(fib);
            return fib.getValue();
        }).orElseGet(() -> {
            long value = calculateFibonacci(n);
            FibonacciNumber fib = new FibonacciNumber();
            fib.setN(n);
            fib.setValue(value);
            fib.setAccessCount(1);
            repository.save(fib);
            return value;
        });
    }

    private long calculateFibonacci(int n) {
        if (n <= 2) return n;
        long a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            long temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }
}

