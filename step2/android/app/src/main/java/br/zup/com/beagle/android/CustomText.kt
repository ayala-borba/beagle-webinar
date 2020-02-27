package br.zup.com.beagle.android

import android.content.Context
import android.widget.TextView
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.WidgetView

@RegisterWidget
class CustomText(val name: String) : WidgetView() {
    override fun toView(context: Context) = TextView(context).apply {
        text = name
    }
}
