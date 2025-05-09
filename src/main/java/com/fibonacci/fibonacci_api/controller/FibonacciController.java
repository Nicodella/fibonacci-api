package com.fibonacci.fibonacci_api.controller;

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

    @Autowired
    public FibonacciController(FibonacciService service) {
        this.service = service;
    }
    
    @GetMapping("/{n}")
    @Operation(summary = "Get Fibonacci(n)", description = "Calcula Fibonacci de un numero n. Para el caso 0 que no existe, se devuelve -1")
    public ResponseEntity<String> getFibonacci(@PathVariable int n) {
        if (n < 0) return ResponseEntity.badRequest().body("Fibonacci(n negativo) no existe");
        return ResponseEntity.ok(service.getFibonacci(n));
    }

    @GetMapping("/{n}/cantaccesos")
    @Operation(summary = "Get cantidad de accesos de n", description = "Devuelve la cantidad de accesos de n. Para el caso 0 que no existe, se devuelve -1 y si n no esta en base devuelve -2")
    public ResponseEntity<String> getAccessCount(@PathVariable int n) {
        if (n < 0) return ResponseEntity.badRequest().body("Fibonacci(n negativo) no existe");
        String cant = service.getCantAccesos(n);
        return ResponseEntity.ok(cant);
    }

}

