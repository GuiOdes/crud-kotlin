package com.teste.kotlinspring.Model

import javax.persistence.*

@Entity
@Table(name = "persons")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var age: Int
)