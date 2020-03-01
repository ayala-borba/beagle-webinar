package br.com.zup.beagle.sample.widget

import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.form.InputWidget

@RegisterWidget
data class TextField(
    val description: String = "",
    val hint: String = "",
    val color: String = "#000000",
    val mask: String? = null,
    val inputType: TextFieldInputType? = null
) : InputWidget()

enum class TextFieldInputType {
    NUMBER,
    PASSWORD,
    TEXT
}
