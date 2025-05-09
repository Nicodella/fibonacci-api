package com.fibonacci.fibonacci_api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigInteger;
import java.util.Optional;

import com.fibonacci.fibonacci_api.controller.FibonacciController;
import com.fibonacci.fibonacci_api.model.FibonacciNumber;
import com.fibonacci.fibonacci_api.repository.FibonacciRepository;
import com.fibonacci.fibonacci_api.service.impl.FibonacciServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@WebMvcTest(FibonacciController.class)
public class FibonacciControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FibonacciService fibonacciService;


    @Mock
    private FibonacciRepository repository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new FibonacciController(fibonacciService)).build();
    }

    @Test
    void testGetFibonacci() throws Exception {
        Mockito.when(fibonacciService.getFibonacci(5)).thenReturn(BigInteger.valueOf(5));

        mockMvc.perform(get("/api/fibonacci/5"))
            .andExpect(status().isOk())
            .andExpect(content().string("5"));
    }

    @Test
    void testGetAccessCount_InvalidN() throws Exception {
        mockMvc.perform(get("/api/fibonacci/0/cantaccesos"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("-1"));

        mockMvc.perform(get("/api/fibonacci/-1/cantaccesos"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("-1"));
    }

    @Test
    void testGetAccessCount_Found() throws Exception {
        int n = 5;
        int expectedAccessCount = 3; 

        when(fibonacciService.getCantAccesos(n)).thenReturn(expectedAccessCount);

        mockMvc.perform(get("/api/fibonacci/" + n + "/cantaccesos"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedAccessCount)));
    }

    @Test
    void testGetAccessCount_NotFound() throws Exception {
        int n = 99; 
        when(fibonacciService.getCantAccesos(n)).thenReturn(-2);

        mockMvc.perform(get("/api/fibonacci/" + n + "/cantaccesos"))
                .andExpect(status().isOk())
                .andExpect(content().string("-2"));
    }

        @Test
        void testGetFibonacci_InvalidN() throws Exception {
            mockMvc.perform(get("/api/fibonacci/0"))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().string("-1"));
    
            mockMvc.perform(get("/api/fibonacci/-1"))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().string("-1"));
        }
    
        @Test
        void testGetFibonacci_ValidN() throws Exception {
            int n = 5;
            BigInteger expectedResult = BigInteger.valueOf(5);
    
            when(fibonacciService.getFibonacci(n)).thenReturn(expectedResult);
    
            mockMvc.perform(get("/api/fibonacci/" + n))
                    .andExpect(status().isOk())
                    .andExpect(content().string(expectedResult.toString()));
        }
    
}
