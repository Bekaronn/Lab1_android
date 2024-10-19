package com.example.lab1

import java.io.Serializable

data class Vacancy(
    val title: String,
    val company: String,
    val salary: String,
    val location: String,
    val description: String,
    val requirements: String,
    val applicationInstructions: String
) : Serializable
