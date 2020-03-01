package br.com.zup.beagle.demo.controller

import br.com.zup.beagle.demo.service.BeagleService
import br.com.zup.beagle.demo.ui.ComposeFormLogin
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BeagleController(private val service: BeagleService) {
    @GetMapping("/text/{name}")
    fun getText(@PathVariable name: String) = service.getText(name)

    @GetMapping("/custom/{name}")
    fun getCustomText(@PathVariable name: String) = service.getCustomText(name)


    @RequestMapping("/form-login")
    fun getCpf(): Screen {
        return Screen(
            navigationBar = NavigationBar(
                title = "entrar"
            ),
            content = ComposeFormLogin()
        )
    }

}
