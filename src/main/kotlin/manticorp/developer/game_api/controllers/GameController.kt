package manticorp.developer.game_api.controllers

import io.swagger.v3.oas.annotations.Operation
import manticorp.developer.game_api.models.GameConfig
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class GameController {

    @Operation(summary = "Get game config", description = "Returns the game configuration")
    @GetMapping("/game-config")
    fun getConfig() = GameConfig(3, GameConfig.GameChoices.entries.toTypedArray())
}