package com.fibonacci.fibonacci_api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fibonacci.fibonacci_api.model.FibonacciNumber;
import com.fibonacci.fibonacci_api.repository.FibonacciRepository;
import com.fibonacci.fibonacci_api.service.impl.FibonacciServiceImpl;

@ExtendWith(MockitoExtension.class)
public class FibonacciServiceTest {

    @InjectMocks
    private FibonacciServiceImpl service;

    @Mock
    private FibonacciRepository repository;

    private FibonacciNumber fib;
    
    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        fib = new FibonacciNumber();
        fib.setId(1);
        fib.setN(1);
        fib.setCantAccedidos(1);
        fib.setValor("1");
    }


    @Test
    public void testGetFibonacci_existingInDB() {
        FibonacciNumber fib = new FibonacciNumber(1, 5, "5", 2);
        when(repository.findByN(5)).thenReturn(Optional.of(fib));
        String result = service.getFibonacci(5);
        assertEquals("5", result);
        assertEquals(3, fib.getCantAccedidos());
        verify(repository).save(fib); 
    }

    @Test
    public void testGetFibonacci_notInDB() {
        when(repository.findByN(6)).thenReturn(Optional.empty());
        String result = service.getFibonacci(6);
        assertNotNull(result);
        assertEquals(new BigInteger(result), new BigInteger("8")); 
        verify(repository).save(any(FibonacciNumber.class));
    }

    @Test
    public void testGetCantAccesos_found() {
        FibonacciNumber fib = new FibonacciNumber(1, 7, "13", 4);
        when(repository.findByN(7)).thenReturn(Optional.of(fib));
        String result = service.getCantAccesos(7);
        assertEquals("4", result);
    }

    @Test
    public void testGetCantAccesos_notFound() {
        when(repository.findByN(99)).thenReturn(Optional.empty());
        String result = service.getCantAccesos(99);
        assertEquals("No hay valores para el n ingresado", result);
    }
}

