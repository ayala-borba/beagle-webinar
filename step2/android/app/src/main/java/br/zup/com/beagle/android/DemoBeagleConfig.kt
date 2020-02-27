package br.zup.com.beagle.android

import br.com.zup.beagle.annotation.BeagleComponent
import br.com.zup.beagle.setup.BeagleConfig
import br.com.zup.beagle.setup.Environment

@BeagleComponent
class DemoBeagleConfig : BeagleConfig {
    override val environment: Environment get() = Environment.DEBUG // return the current build state of your app
    override val baseUrl: String get() = Constants.ADDRESS_SERVER // return the base url based on your environment
}