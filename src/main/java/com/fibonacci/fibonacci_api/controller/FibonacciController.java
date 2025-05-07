package com.fibonacci.fibonacci_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fibonacci.fibonacci_api.service.FibonacciService;

@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService service;

    @GetMapping("/{n}")
    public ResponseEntity<Long> getFibonacci(@PathVariable int n) {
        if (n <= 0) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(service.getFibonacci(n));
    }
}

