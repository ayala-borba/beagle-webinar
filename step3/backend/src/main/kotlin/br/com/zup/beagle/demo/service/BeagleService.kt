package br.com.zup.beagle.demo.service

import br.com.zup.beagle.action.*
import br.com.zup.beagle.demo.dto.request.LoginForm
import br.com.zup.beagle.demo.ui.ComposeFormLogin
import br.com.zup.beagle.demo.widget.CustomText
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.core.Alignment
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.JustifyContent
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.ui.Text
import br.com.zup.beagle.widget.ui.TextAlignment
import org.springframework.stereotype.Service

@Service
class BeagleService {
    fun getText(name: String) = centered(Text("Hello, $name!", alignment = TextAlignment.CENTER))

    fun getCustomText(name: String) = centered(CustomText(name))

    fun createFormLogin() = Screen(
        navigationBar = NavigationBar(
            title = "entrar"
        ),
        content = ComposeFormLogin()
    )

    fun validateLogin(loginForm: LoginForm) = when {
        loginForm.login.isBlank() -> FormValidation(
            errors = listOf(
                FieldError("login", "Digite seu login!")
            )
        )

        loginForm.password.isBlank() -> FormValidation(
            errors = listOf(
                FieldError("password", "Digite sua senha!")
            )
        )

        else -> Navigate(
            type = NavigationType.ADD_VIEW,
            path = "/welcome/${loginForm.login}",
            shouldPrefetch = true
        )
    }

    fun createWelcome(user: String) = Screen(
        navigationBar = NavigationBar(title = "Bem-vindo"),
        content = centered(Text("Bem-vindo $user!", alignment = TextAlignment.CENTER))
    )

    private fun centered(widget: Widget) = widget
        .applyFlex(
            flex = Flex(
                grow = 1.0,
                justifyContent = JustifyContent.CENTER,
                alignContent = Alignment.CENTER,
                alignItems = Alignment.CENTER,
                alignSelf = Alignment.CENTER
            )
        )
}
