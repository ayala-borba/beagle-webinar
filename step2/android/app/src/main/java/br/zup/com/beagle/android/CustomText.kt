package br.zup.com.beagle.android

import android.content.Context
import android.widget.TextView
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.WidgetView

@RegisterWidget
data class CustomText(val text: String) : WidgetView() {
    override fun toView(context: Context) = TextView(context).apply {
        this.text = this@CustomText.text
    }
}
