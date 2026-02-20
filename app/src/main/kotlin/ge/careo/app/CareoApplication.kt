package ge.careo.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CareoApplication

fun main(args: Array<String>) {
    runApplication<CareoApplication>(*args)
}