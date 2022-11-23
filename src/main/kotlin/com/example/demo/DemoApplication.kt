package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans
import org.springframework.web.reactive.function.server.*

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args) {
		addInitializers(beans())
	}
}

fun beans() = beans {
	bean(::writeEndpoint)
}

fun writeEndpoint() = coRouter {
	GET("/user") { ServerResponse.ok().buildAndAwait() }
}