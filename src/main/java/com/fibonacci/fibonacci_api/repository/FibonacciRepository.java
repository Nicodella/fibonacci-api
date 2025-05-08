package com.fibonacci.fibonacci_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fibonacci.fibonacci_api.model.FibonacciNumber;

@Repository
public interface FibonacciRepository extends JpaRepository<FibonacciNumber, Integer> {
    Optional<FibonacciNumber> findByN(int n);
}
