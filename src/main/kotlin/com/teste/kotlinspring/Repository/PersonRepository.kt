package com.teste.kotlinspring.Repository

import com.teste.kotlinspring.Model.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Long> {
}