//
//  TextField.swift
//  BeagleWebinar
//
//  Created by Frederico Franco on 28/02/20.
//  Copyright © 2020 Frederico Franco. All rights reserved.
//

import Foundation
import BeagleUI
import UIKit

struct TextFieldEntity: WidgetEntity {

    let placeHolder: String

    var flex: FlexEntity?
    var appearance: AppearanceEntity?
    var accessibility: AccessibilityEntity?

    func mapToComponent() throws -> ServerDrivenComponent {
        return TextField(
            placeHolder: placeHolder,
            appearance: try appearance?.mapToUIModel(),
            flex: try flex?.mapToUIModel(),
            accessibility: try accessibility?.mapToUIModel()
        )
    }
}

struct TextField: Widget {

    var placeHolder: String

    var appearance: Appearance?
    var flex: Flex?
    var accessibility: Accessibility?

    func toView(context: BeagleContext, dependencies: RenderableDependencies) -> UIView {
        let textField = TextFieldView()
        textField.borderStyle = .roundedRect
        textField.placeholder = placeHolder

        textField.applyAppearance(appearance)
        textField.flex.setupFlex(flex)
        dependencies.accessibility.applyAccessibilityAttributes(accessibility, to: textField)
        return textField
    }
}


class TextFieldView: UITextField, UITextFieldDelegate, InputValue, WidgetStateObservable {

    private(set) var observable = Observable<WidgetState>(value: WidgetState(value: text))

    override init(frame: CGRect) {
        super.init(frame: frame)
        delegate = self
        addTarget(self, action: #selector(textChanged), for: .editingChanged)
    }

    @available(*, unavailable)
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }

    func getValue() -> Any {
        return text ?? ""
    }

    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        endEditing(true)
        return true
    }

    @objc private func textChanged() {
        observable.value.value = text
    }
}
