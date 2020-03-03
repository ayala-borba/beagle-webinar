package br.zup.com.beagle.android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.beagle.utils.loadView
import br.com.zup.beagle.utils.setBeagleStateChangedListener
import br.com.zup.beagle.utils.toView
import br.com.zup.beagle.view.BeagleActivity
import br.com.zup.beagle.view.BeagleViewState
import br.com.zup.beagle.view.ScreenRequest
import br.com.zup.beagle.view.StateChangedListener
import br.com.zup.beagle.widget.core.Alignment
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.JustifyContent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val url = "http://10.0.2.2:8080/custom/borracha"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(
            BeagleActivity.newIntent(
                this,
                ScreenRequest(url)
            )
        )
    }
}
