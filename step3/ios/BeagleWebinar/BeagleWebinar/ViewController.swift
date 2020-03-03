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

        registerCustomWidgets()

        let beagle = BeagleScreenViewController(viewModel: .init(
            screenType: .remote("/form-login", fallback: nil)
        ))

        beagle.modalPresentationStyle = .fullScreen
        present(beagle, animated: true, completion: nil)
    }

    func registerCustomWidgets() {
        let dependencies = BeagleDependencies()
        dependencies.baseURL = URL(string: "http://localhost:8080")
        Beagle.dependencies = dependencies

        Beagle.registerCustomComponent(
            "customText",
            componentType: CustomText.self,
            entityType: CustomTextEntity.self
        )

        Beagle.registerCustomComponent(
            "TextField",
            componentType: TextField.self,
            entityType: TextFieldEntity.self
        )
    }
}

