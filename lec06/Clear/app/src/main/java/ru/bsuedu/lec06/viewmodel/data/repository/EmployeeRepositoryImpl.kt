package ru.bsuedu.lec06.viewmodel.data.repository

import ru.bsuedu.lec06.viewmodel.domain.entity.Employee
import ru.bsuedu.lec06.viewmodel.domain.repository.EmployeeRepository
import java.util.UUID

class EmployeeRepositoryImpl : EmployeeRepository {
    private val _employees = mutableListOf(
        Employee(UUID.randomUUID(), "Sam", "", UUID.randomUUID()),
        Employee(UUID.randomUUID(), "Sam", "", UUID.randomUUID()),
        Employee(UUID.randomUUID(), "Sam", "", UUID.randomUUID()),
        Employee(UUID.randomUUID(), "Sam", "", UUID.randomUUID()),

        )

    override fun getEmployees(): List<Employee> = _employees.toList()

    override fun getEmployeeById(id: UUID): Employee? {
        return _employees.find { it.id == id }
    }

    override fun addEmployee(employee: Employee) {
        _employees.add(employee)
    }

    override fun removeEmployeeById(id: UUID) {
        _employees.removeIf { it.id == id }
    }
}