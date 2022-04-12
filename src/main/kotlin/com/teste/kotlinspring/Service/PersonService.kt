package com.teste.kotlinspring.Service

import com.teste.kotlinspring.Model.Person
import com.teste.kotlinspring.Repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class PersonService (
    @Autowired
    val personRepository: PersonRepository
) {



    fun listAll(): List<Person> {
        return personRepository.findAll().toList()
    }

    fun create(person: Person): ResponseEntity<Person> {
        return ResponseEntity.ok(personRepository.save(person))
    }

    fun update(person: Person): ResponseEntity<Person> {
        return if (personRepository.existsById(person.id)) {
            ResponseEntity.ok(personRepository.save(person))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    fun deleteBy(id: Long): ResponseEntity<Unit> {
        return if (personRepository.existsById(id)) {
            ResponseEntity.ok(personRepository.deleteById(id))
        } else{
            ResponseEntity.notFound().build()
        }
    }
}