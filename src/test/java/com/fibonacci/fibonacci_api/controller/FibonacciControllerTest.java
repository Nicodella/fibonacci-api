package com.fibonacci.fibonacci_api.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fibonacci.fibonacci_api.model.FibonacciNumber;
import com.fibonacci.fibonacci_api.service.FibonacciService;

@WebMvcTest(FibonacciController.class)
public class FibonacciControllerTest {
@Autowired
    private MockMvc mockMvc;

    @MockBean
    private FibonacciService service;

    @Test
    public void testGetFibonacci_validInput() throws Exception {
        when(service.getFibonacci(5)).thenReturn("5");

        mockMvc.perform(get("/api/fibonacci/5"))
            .andExpect(status().isOk())
            .andExpect(content().string("5"));
    }

    @Test
    public void testGetFibonacci_zero() throws Exception {
        when(service.getFibonacci(0)).thenReturn("0");
    
        mockMvc.perform(get("/api/fibonacci/0"))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }
    

    @Test
    public void testGetAccessCount_validInput() throws Exception {
        when(service.getCantAccesos(5)).thenReturn("3");

        mockMvc.perform(get("/api/fibonacci/5/cantaccesos"))
            .andExpect(status().isOk())
            .andExpect(content().string("3"));
    }

    @Test
    public void testGetAccessCount_invalidInput() throws Exception {
        mockMvc.perform(get("/api/fibonacci/-1/cantaccesos"))
            .andExpect(status().isBadRequest())
            .andExpect(content().string("Fibonacci(n negativo) no existe"));
    }

        @Test
    public void testGetMasAccedido_found() throws Exception {
        FibonacciNumber fib = new FibonacciNumber();
        fib.setN(5);
        fib.setCantAccedidos(10);
        when(service.getMasAccedido()).thenReturn(Optional.of(fib));
        mockMvc.perform(get("/api/fibonacci/masaccedido"))
            .andExpect(status().isOk()) 
            .andExpect(content().string("El número más consultado es: 5 con 10 accesos.")); 
    }

    @Test
    public void testGetMasAccedido_notFound() throws Exception {
        when(service.getMasAccedido()).thenReturn(Optional.empty());
        mockMvc.perform(get("/api/fibonacci/masaccedido"))
            .andExpect(status().isNotFound())  
            .andExpect(content().string("No hay números registrados."));  
    }

}
