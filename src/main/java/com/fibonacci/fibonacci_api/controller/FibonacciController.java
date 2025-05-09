package com.fibonacci.fibonacci_api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fibonacci.fibonacci_api.model.FibonacciNumber;
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
    @Operation(summary = "Get Fibonacci(n)", description = "Calcula Fibonacci de un numero n.")
    public ResponseEntity<String> getFibonacci(@PathVariable int n) {
        if (n < 0) return ResponseEntity.badRequest().body("Fibonacci(n negativo) no existe");
        return ResponseEntity.ok(service.getFibonacci(n));
    }

    @GetMapping("/{n}/cantaccesos")
    @Operation(summary = "Get cantidad de accesos de n", description = "Devuelve la cantidad de accesos de n.")
    public ResponseEntity<String> getAccessCount(@PathVariable int n) {
        if (n < 0) return ResponseEntity.badRequest().body("Fibonacci(n negativo) no existe");
        String cant = service.getCantAccesos(n);
        return ResponseEntity.ok(cant);
    }

    @GetMapping("/masaccedido")
    @Operation(summary = "Número más accedido", description = "Devuelve el número de Fibonacci más consultado")
    public ResponseEntity<String> getMasAccedido() {
        Optional<FibonacciNumber> masAccedido = service.getMasAccedido();
        return masAccedido
            .map(fibonacciNumber -> ResponseEntity.ok("El número más consultado es: " + fibonacciNumber.getN() + " con " + fibonacciNumber.getCantAccedidos() + " accesos."))
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No hay números registrados."));
    }
}

