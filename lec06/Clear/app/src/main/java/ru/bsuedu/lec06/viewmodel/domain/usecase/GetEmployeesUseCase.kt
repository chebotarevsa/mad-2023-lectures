package ru.bsuedu.lec06.viewmodel.domain.usecase

import ru.bsuedu.lec06.viewmodel.domain.entity.Employee
import ru.bsuedu.lec06.viewmodel.domain.repository.EmployeeRepository

class GetEmployeesUseCase(
    private val employeeRepository: EmployeeRepository
) {
    operator fun invoke(): List<Employee> = employeeRepository.getEmployees()
}