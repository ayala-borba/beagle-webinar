//
//  Copyright © 2020 Zup IT. All rights reserved.
//

import UIKit
import BeagleUI

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)

        let beagle = BeagleScreenViewController(viewModel: .init(
            screenType: .declarative(
                Screen(content: Text("Hello Beagle!"))
            )
        ))

/// Receiving from server
//        Beagle.registerCustomComponent(
//            "customText",
//            componentType: CustomText.self,
//            entityType: CustomTextEntity.self
//        )
//
//        let beagle = BeagleScreenViewController(viewModel: .init(
//            screenType: .remote("http://10.0.1.139:8080/custom/testando", fallback: nil)
//        ))
/// To be able to use http (without s) we need to allow App Transport Security

        beagle.modalPresentationStyle = .fullScreen
        present(beagle, animated: true, completion: nil)
    }
}

