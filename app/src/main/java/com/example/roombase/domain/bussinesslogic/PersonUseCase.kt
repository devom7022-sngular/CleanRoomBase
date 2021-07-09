package com.example.roombase.domain.bussinesslogic

import com.example.roombase.data.models.Person

interface PersonUseCase {

    fun getPersons(): List<Person>
}