package manticorp.developer.game_api.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
class CorsConfig {

    @Bean
    fun corsConfigurationSource(): UrlBasedCorsConfigurationSource {
        val configuration = CorsConfiguration()

        // Allow requests from specific origins
        configuration.allowedOrigins = listOf("http://localhost:4200") // Replace with specific origin for production

        // Allow credentials (cookies, authorization headers, etc.)
        configuration.allowCredentials = true

        // Allow specific HTTP methods
        configuration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")

        // Allow specific headers
        configuration.allowedHeaders = listOf("Authorization", "Content-Type")

        // Apply CORS settings to all paths
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)

        return source
    }
}