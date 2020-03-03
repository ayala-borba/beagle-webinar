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

        let margin = Flex(margin: Flex.EdgeValue(all: UnitValue(value: 10, type: .real)))

        let children: [ServerDrivenComponent] = [
            FormInput(name: "username", child:
                TextField(hint: "Usuario", flex: margin)
            ),
            FormInput(name: "password", child:
                TextField(hint: "Senha", flex: margin)
            ),
            FormSubmit(child: Button(text: "Entrar", flex: margin))
        ]

        let content = Container(
            children: children,
            flex: Flex(flexDirection: .column, justifyContent: .center, grow: 1),
            appearance: Appearance(backgroundColor: "#AA1232")
        )

        let form = Form(path: "submitForm", method: .post, child: content)


//        let beagle = BeagleScreenViewController(viewModel: .init(
//            screenType: .declarative(
//                Screen(content: form)
//            )
//        ))

        let beagle = BeagleScreenViewController(viewModel: .init(
            screenType: .remote("http://localhost:8080/form-login", fallback: nil)
        ))

        beagle.modalPresentationStyle = .fullScreen
        present(beagle, animated: true, completion: nil)
    }

    func registerCustomWidgets() {
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

