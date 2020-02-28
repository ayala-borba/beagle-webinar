//
//  ViewController.swift
//  BeagleWebinar
//
//  Created by Frederico Franco on 26/02/20.
//  Copyright © 2020 Frederico Franco. All rights reserved.
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
                Screen(content: CustomText(text: "Testando"))
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
//            screenType: .remote("http://localhost:8080/custom/testando", fallback: nil)
//        ))
/// To be able to use http (without s) we need to allow App Transport Security

        beagle.modalPresentationStyle = .fullScreen
        present(beagle, animated: true, completion: nil)
    }
}

