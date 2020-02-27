package br.zup.com.beagle.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.utils.toView
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.form.Form
import br.com.zup.beagle.widget.form.FormInput
import br.com.zup.beagle.widget.form.FormMethodType
import br.com.zup.beagle.widget.form.FormSubmit
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.ui.Button
import br.zup.com.beagle.android.widgets.TextField
import br.zup.com.beagle.android.widgets.TextFieldInputType

class MainActivity : AppCompatActivity() {
    private val url = "http://10.0.2.2:8080/text/Borracha"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        //Load the url content into this view
//        container.loadView(this, url)
//
//        //Setting the state listener
//        container.setBeagleStateChangedListener(object : StateChangedListener {
//            override fun onStateChanged(state: BeagleViewState) {
//                when (state) {
//                    is BeagleViewState.Error -> {
//                        state.throwable.printStackTrace()
//                    }
//                    is BeagleViewState.LoadStarted -> {
//                        Log.d("BEAGLE_DEMO", "Loading view $url")
//                    }
//                    is BeagleViewState.LoadFinished -> {
//                        Log.d("BEAGLE_DEMO", "Finished loading view $url")
//                    }
//                }
//            }
//        })

        val formName = ITIFormName()

        setContentView(formName.toView(this))

    }


}

class ITIFormName : ComposeComponent() {
    override fun build(): ServerDrivenComponent {
        return Form(
            path = "/validate-name",
            method = FormMethodType.POST,
            child = Container(
                children = listOf(
                    buildContent(),
                    buildFooter()
                )
            ).applyFlex(
                flex = Flex(
                    justifyContent = JustifyContent.SPACE_BETWEEN,
                    grow = 1.0
                )
            )
        )
    }

    private fun buildContent() = Container(
        children = listOf(
            FormInput(
                name = "name",
                child = TextField(
                    description = "digite seu nome",
                    hint = "nome",
//                color = "#FFFFFF",
                    inputType = TextFieldInputType.TEXT
                )
            )
        )
    ).applyFlex(
        flex = Flex(
            size = Size(
                width = UnitValue(
                    value = 100.0,
                    type = UnitType.PERCENT
                )
            ),
            margin = EdgeValue(
                all = UnitValue(
                    value = 15.0,
                    type = UnitType.REAL
                )
            )
        )
    )

    private fun buildFooter() = Container(
        children = listOf(
            (FormSubmit(
                child = Button("cadastrar", style = "primaryButton")
            ))
        )
    ).applyFlex(
        flex = Flex(
            size = Size(
                width = UnitValue(
                    value = 100.0,
                    type = UnitType.PERCENT
                )
            ),
            padding = EdgeValue(
                left = UnitValue(
                    value = 15.0,
                    type = UnitType.REAL
                ),
                right = UnitValue(
                    value = 15.0,
                    type = UnitType.REAL
                ),
                bottom = UnitValue(
                    value = 15.0,
                    type = UnitType.REAL
                )
            )
        )
    )
}
