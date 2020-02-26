package br.com.zup.beagle.demo

import br.com.zup.beagle.widget.ui.Text
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BeagleController {
    @GetMapping("/widget")
    fun getComponent() = Text("Hello, world!")
}
