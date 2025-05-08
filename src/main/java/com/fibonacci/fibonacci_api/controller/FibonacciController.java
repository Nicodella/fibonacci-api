package com.fibonacci.fibonacci_api.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fibonacci.fibonacci_api.service.FibonacciService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/fibonacci")
@Tag(name = "Serie Fibonacci", description = "Serie Fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService service;

    @GetMapping("/{n}")
    @Operation(summary = "Get Fibonacci(n)", description = "Calcula Fibonacci de un numero n. Para el caso 0 que no existe, se devuelve -1")
    public ResponseEntity<BigInteger> getFibonacci(@PathVariable int n) {
        if (n <= 0) return ResponseEntity.badRequest().body(BigInteger.valueOf(-1));
        return ResponseEntity.ok(service.getFibonacci(n));
    }

}

