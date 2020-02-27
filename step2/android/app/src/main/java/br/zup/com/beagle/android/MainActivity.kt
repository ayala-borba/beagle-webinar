package br.zup.com.beagle.android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.beagle.utils.loadView
import br.com.zup.beagle.utils.setBeagleStateChangedListener
import br.com.zup.beagle.view.BeagleViewState
import br.com.zup.beagle.view.StateChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val url = "http://10.0.2.2:8080/text/Borracha"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Load the url content into this view

        container.loadView(this, url)

        //Setting the state listener
        container.setBeagleStateChangedListener(object : StateChangedListener {
            override fun onStateChanged(state: BeagleViewState) {
                when (state) {
                    is BeagleViewState.Error -> {
                        state.throwable.printStackTrace()
                    }
                    is BeagleViewState.LoadStarted -> {
                        Log.d("BEAGLE_DEMO", "Loading view $url")
                    }
                    is BeagleViewState.LoadFinished -> {
                        Log.d("BEAGLE_DEMO", "Finished loading view $url")
                    }
                }
            }
        })

    }
}
