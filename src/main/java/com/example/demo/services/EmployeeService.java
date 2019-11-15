package com.example.demo.services;

import com.example.demo.domains.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public void create(Employee e) {
        employeeRepository.save(e).subscribe();
    }

    public Mono<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    public Flux<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    public Flux<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Mono<Employee> update(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Mono<Void> delete(Integer id) {
        return employeeRepository.deleteById(id);
    }
}
