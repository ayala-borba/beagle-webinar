package br.com.zup.beagle.demo.controller

import br.com.zup.beagle.action.*
import br.com.zup.beagle.demo.dto.request.LoginForm
import br.com.zup.beagle.demo.service.BeagleService
import br.com.zup.beagle.demo.ui.ComposeFormLogin
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import org.springframework.web.bind.annotation.*

@RestController
class BeagleController(private val service: BeagleService) {
    @GetMapping("/text/{name}")
    fun getText(@PathVariable name: String) = service.getText(name)

    @GetMapping("/custom/{name}")
    fun getCustomText(@PathVariable name: String) = service.getCustomText(name)

    @RequestMapping("/form-login")
    fun getCpf() = service.createFormLogin()

    @PostMapping("/validate-login")
    fun validatePassword(@RequestBody loginForm: LoginForm) = service.validateLogin(loginForm)

    @RequestMapping("/welcome/{user}")
    fun getWelcome(@PathVariable user: String) = service.createWelcome(user)

}
