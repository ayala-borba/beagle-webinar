package br.com.zup.beagle.demo.controller

import br.com.zup.beagle.action.*
import br.com.zup.beagle.demo.service.BeagleService
import br.com.zup.beagle.demo.ui.ComposeFormLogin
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.core.Alignment
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.JustifyContent
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.ui.Text
import org.springframework.web.bind.annotation.*

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


    object FormData {
        var login: String = ""
    }


    data class LoginForm(
        val login: String,
        val password: String
    )

    @PostMapping("/validate-login")
    fun validatePassword(@RequestBody loginForm: LoginForm): Action {
        return if (loginForm.login.isEmpty() || loginForm.login.split(" ").isEmpty()) {
            FormValidation(
                errors = listOf(
                    FieldError("login", "Digite seu login!")
                )
            )
        } else if (loginForm.password.isEmpty() || loginForm.password.split(" ").isEmpty()) {
            FormValidation(
                errors = listOf(
                    FieldError("password", "Digite sua senha!")
                )
            )
        } else {
            FormData.login = loginForm.login

            return Navigate(
                type = NavigationType.SWAP_VIEW,
                path = "/welcome"
            )
        }
    }

    @RequestMapping("/welcome")
    fun getWelcome(): Widget {
        return Text("Bem-vindo ${FormData.login}!").applyFlex(
            flex = Flex(
                grow = 1.0,
                justifyContent = JustifyContent.CENTER,
                alignContent = Alignment.CENTER,
                alignItems = Alignment.CENTER,
                alignSelf = Alignment.CENTER
            )
        )
    }

}
