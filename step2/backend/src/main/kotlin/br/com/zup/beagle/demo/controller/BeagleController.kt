package br.com.zup.beagle.demo.controller

import br.com.zup.beagle.demo.widget.CustomText
import br.com.zup.beagle.widget.ui.Text
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class BeagleController {
    @GetMapping("/text/{name}")
    fun getComponent(@PathVariable name: String) = Text("Hello, $name!")

    @GetMapping("/custom/{name}")
    fun getCustomText(@PathVariable name: String) = CustomText(name)
}
