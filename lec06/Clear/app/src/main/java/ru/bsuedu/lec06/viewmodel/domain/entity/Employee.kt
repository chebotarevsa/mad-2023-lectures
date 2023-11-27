package ru.bsuedu.lec06.viewmodel.domain.entity

import java.util.UUID

class Employee(
    val id: UUID,
    val name: String,
    val surname: String,
    val company: UUID
) {

}