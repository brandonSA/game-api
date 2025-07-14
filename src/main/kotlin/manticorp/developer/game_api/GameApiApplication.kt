package manticorp.developer.game_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GameApiApplication

fun main(args: Array<String>) {
	runApplication<GameApiApplication>(*args)
}
