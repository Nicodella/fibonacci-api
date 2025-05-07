package com.fibonacci.fibonacci_api.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fibonacci.fibonacci_api.controller.FibonacciController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(FibonacciController.class)
public class FibonacciControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FibonacciService fibonacciService;

    @Test
    void testGetFibonacci() throws Exception {
        Mockito.when(fibonacciService.getFibonacci(5)).thenReturn(5L);

        mockMvc.perform(get("/api/fibonacci/5"))
               .andExpect(status().isOk())
               .andExpect(content().string("5"));
    }
}
