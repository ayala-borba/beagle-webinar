package br.com.zup.beagle.demo.widget

import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.Widget

@RegisterWidget
class CustomText(name: String): Widget() {
    val text = "Hello, $name!"
}
