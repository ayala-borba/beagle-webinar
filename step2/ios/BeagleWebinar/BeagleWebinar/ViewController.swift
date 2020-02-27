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
        // Do any additional setup after loading the view.
    }

    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)

        let beagle = BeagleScreenViewController(viewModel: .init(
            screenType: .declarative(
                Screen(content: CustomText(text: "TEstando"))
            )
        ))
        beagle.modalPresentationStyle = .fullScreen
        present(beagle, animated: true, completion: nil)
    }

}

