package br.com.zup.beagle.demo.configuration

import br.com.zup.beagle.serialization.jackson.BeagleActionSerializer
import br.com.zup.beagle.serialization.jackson.BeagleComponentSerializer
import br.com.zup.beagle.serialization.jackson.BeagleScreenBuilderSerializer
import br.com.zup.beagle.serialization.jackson.BeagleScreenSerializer
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Configuration
class JacksonConfiguration {
    @Bean
    open fun jacksonBuilder(): Jackson2ObjectMapperBuilder {
        return Jackson2ObjectMapperBuilder()
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .serializers(BeagleComponentSerializer())
            .serializers(BeagleActionSerializer())
            .serializers(BeagleScreenSerializer())
            .serializers(BeagleScreenBuilderSerializer())
    }
}
