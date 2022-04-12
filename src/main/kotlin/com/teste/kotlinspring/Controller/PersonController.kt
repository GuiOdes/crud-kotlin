package com.teste.kotlinspring.Controller

import com.teste.kotlinspring.Model.Person
import com.teste.kotlinspring.Service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController (
    val service: PersonService
){

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listAll(): List<Person> {
        return service.listAll()
    }

    @PostMapping("/new")
    fun create(@RequestBody person: Person): ResponseEntity<Person> {
        return service.create(person)
    }

    @PutMapping("/update")
    fun update(@RequestBody person: Person): ResponseEntity<Person> {
        return service.update(person)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteBy(@PathVariable id: Long): ResponseEntity<Unit>{
        return service.deleteBy(id)
    }
}