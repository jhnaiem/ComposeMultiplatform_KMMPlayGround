package com.example.kmmplayground.data

import kotlinx.serialization.Serializable

@Serializable
data class Participant(
    val name: String = "",
    val id: String = "",
    val email: String = "",
)
