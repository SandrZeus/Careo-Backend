package ge.careo.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(basePackages = ["ge.careo"])
@EnableJpaRepositories(basePackages = ["ge.careo"])
@EntityScan(basePackages = ["ge.careo"])
class CareoApplication

fun main(args: Array<String>) {
    runApplication<CareoApplication>(*args)
}