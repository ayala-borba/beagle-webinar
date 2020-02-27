package br.com.zup.beagle.demo.service

import br.com.zup.beagle.demo.widget.CustomText
import br.com.zup.beagle.widget.ui.Text
import org.springframework.stereotype.Service

@Service
class BeagleService {
    fun getText(name: String) = Text("Hello, $name!")

    fun getCustomText(name: String) = CustomText(name)
}
