package manticorp.developer.game_api

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class GameController {

    @Operation(summary = "Get game config", description = "Returns the game configuration")
    @GetMapping("/game-config")
    fun listMessages() = listOf(
        Model("1", "Hello!"),
        Model("2", "Bonjour!"),
        Model("3", "Privet!"),
    )
}