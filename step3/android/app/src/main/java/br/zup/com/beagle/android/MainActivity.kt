package br.zup.com.beagle.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.beagle.core.Appearance
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.utils.toView
import br.com.zup.beagle.view.BeagleActivity
import br.com.zup.beagle.view.ScreenRequest
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.form.Form
import br.com.zup.beagle.widget.form.FormInput
import br.com.zup.beagle.widget.form.FormMethodType
import br.com.zup.beagle.widget.form.FormSubmit
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.NetworkImage
import br.zup.com.beagle.android.widgets.TextField
import br.zup.com.beagle.android.widgets.TextFieldInputType

class MainActivity : AppCompatActivity() {

    private val url = "/form-login"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val formName = ComposeFormLogin()
//        setContentView(formName.toView(this))

        startActivity(
            BeagleActivity.newIntent(
                this,
                ScreenRequest(url)
            )
        )

    }

}

//class ComposeFormLogin : ComposeComponent() {
//    override fun build(): ServerDrivenComponent {
//        return Form(
//            path = "/validate-login",
//            method = FormMethodType.POST,
//            child = Container(
//                children = listOf(
//                    buildContent(),
//                    buildFooter()
//                )
//            ).applyFlex(
//                flex = Flex(
//                    justifyContent = JustifyContent.SPACE_BETWEEN,
//                    grow = 1.0
//                )
//            )
//        )
//    }
//
//    private fun buildContent() = Container(
//        children = listOf(
//            NetworkImage(
//                path = "https://cdn-images-1.medium.com/max/1200/1*kjiNJPB3Y-ZVmjxco_bORA.png"
//            ).applyFlex(
//                Flex(
//                    alignSelf = Alignment.CENTER,
//                    size = Size(
//                        height = UnitValue(50.0, UnitType.REAL),
//                        width = UnitValue(50.0, UnitType.REAL)
//                    )
//                )
//            ).applyAppearance(
//                Appearance(
//                    cornerRadius = CornerRadius(25.0)
//                )
//            ),
//            FormInput(
//                name = "login",
//                child = TextField(
//                    hint = "usuario",
//                    inputType = TextFieldInputType.TEXT
//                )
//            ),
//            FormInput(
//                name = "senha",
//                child = TextField(
//                    hint = "senha",
//                    inputType = TextFieldInputType.TEXT
//                )
//            )
//        )
//    ).applyFlex(
//        flex = Flex(
//            margin = EdgeValue(all = UnitValue(20.0, UnitType.REAL))
//        )
//    )
//
//    private fun buildFooter() = Container(
//        children = listOf(
//            (FormSubmit(
//                child = Button("login", style = "default")
//            ))
//        )
//    ).applyFlex(
//        flex = Flex(
//            size = Size(
//                width = UnitValue(
//                    value = 100.0,
//                    type = UnitType.PERCENT
//                )
//            ),
//            padding = EdgeValue(
//                left = UnitValue(
//                    value = 15.0,
//                    type = UnitType.REAL
//                ),
//                right = UnitValue(
//                    value = 15.0,
//                    type = UnitType.REAL
//                ),
//                bottom = UnitValue(
//                    value = 15.0,
//                    type = UnitType.REAL
//                )
//            )
//        )
//    )
//}