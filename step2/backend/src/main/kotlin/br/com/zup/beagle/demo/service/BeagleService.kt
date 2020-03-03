package br.com.zup.beagle.demo.service

import br.com.zup.beagle.demo.widget.CustomText
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.core.Alignment
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.JustifyContent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.Text
import org.springframework.stereotype.Service

@Service
class BeagleService {
    fun getText(name: String) = centered(Text("Hello, $name!"))

    fun getCustomText(name: String) = centered(CustomText(name))

    private fun centered(widget: Widget) = Container(children = listOf(widget))
        .applyFlex(
            flex = Flex(
                grow = 1.0,
                justifyContent = JustifyContent.CENTER,
                alignItems = Alignment.CENTER
            )
        )
}
