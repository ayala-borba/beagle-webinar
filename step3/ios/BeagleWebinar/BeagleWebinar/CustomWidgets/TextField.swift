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

    var hint: String?
    var description: String?
    var color: String?
    var placeHolder: String?
    var mask: String?
    var inputType: TextFieldInputType?

    var id: String?
    var flex: FlexEntity?
    var appearance: AppearanceEntity?
    var accessibility: AccessibilityEntity?

    func mapToComponent() throws -> ServerDrivenComponent {
        return TextField(
            hint: hint,
            description: description,
            color: color,
            mask: mask,
            inputType: inputType,
            appearance: try appearance?.mapToUIModel(),
            flex: try flex?.mapToUIModel(),
            accessibility: try accessibility?.mapToUIModel()
        )
    }
}

enum TextFieldInputType: String, Codable {
    case NUMBER
    case PASSWORD
    case TEXT
}

struct TextField: Widget {

    var hint: String?
    var description: String?
    var color: String?
    var mask: String?
    var inputType: TextFieldInputType?

    var appearance: Appearance?
    var flex: Flex?
    var accessibility: Accessibility?
    var id: String?

    func toView(context: BeagleContext, dependencies: RenderableDependencies) -> UIView {
        let textField = TextFieldView(widget: self, context: context)
        textField.borderStyle = .roundedRect

        textField.applyAppearance(appearance)
        textField.flex.setupFlex(flex)
        dependencies.accessibility.applyAccessibilityAttributes(accessibility, to: textField)
        return textField
    }
}

class TextFieldView: UITextField, UITextFieldDelegate, InputValue, WidgetStateObservable, ValidationErrorListener {

    private(set) var observable = Observable<WidgetState>(value: WidgetState(value: text))

    private weak var context: BeagleContext?

    init(widget: TextField, context: BeagleContext) {
        self.context = context
        super.init(frame: .zero)

        placeholder = widget.hint

        if let color = widget.color {
            textColor = UIColor(hex: color)
        }

        if let input = widget.inputType {
            textContentType = textContentType(for: input)
        }

        delegate = self
        addTarget(self, action: #selector(textChanged), for: .editingChanged)
    }

//    override func sizeThatFits(_ size: CGSize) -> CGSize {
//        return size
//    }

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

    private func textContentType(for input: TextFieldInputType) -> UITextContentType {
        switch input {
        case .NUMBER:
            return .telephoneNumber
        case .PASSWORD:
            return .password
        case .TEXT:
            return .username
        }
    }

    func onValidationError(message: String?) {
        guard let context = context else { return }

        let alert = ShowNativeDialog(
            title: "Error",
            message: message ?? "Error",
            buttonText: "OK"
        )

        Beagle.dependencies.actionExecutor.doAction(alert, sender: self, context: context)
    }

    @available(*, unavailable)
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}
