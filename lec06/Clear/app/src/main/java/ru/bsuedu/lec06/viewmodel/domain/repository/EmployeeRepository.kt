package ru.bsuedu.lec06.viewmodel.domain.repository

import ru.bsuedu.lec06.viewmodel.domain.entity.Employee
import java.util.UUID

interface EmployeeRepository {
    fun getEmployees(): List<Employee>
    fun getEmployeeById(id:UUID): Employee?

    fun addEmployee(employee: Employee)

    fun removeEmployeeById(id:UUID)
}