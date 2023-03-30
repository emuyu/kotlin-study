package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StudyApiApplication

fun main(args: Array<String>) {
	runApplication<StudyApiApplication>(*args)
}
