package com.example.kmmplayground

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform