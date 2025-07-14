package manticorp.developer.game_api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController {
    @GetMapping("/")
    fun listMessages() = listOf(
        Model("1", "Hello!"),
        Model("2", "Bonjour!"),
        Model("3", "Privet!"),
    )
}