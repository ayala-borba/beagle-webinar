//
//  CustomText.swift
//  BeagleWebinar
//
//  Created by Frederico Franco on 26/02/20.
//  Copyright © 2020 Frederico Franco. All rights reserved.
//

import Foundation
import BeagleUI
import UIKit

struct CustomTextEntity: WidgetEntity {

    let text: String

    var flex: FlexEntity?
    var appearance: AppearanceEntity?
    var accessibility: AccessibilityEntity?

    func mapToComponent() throws -> ServerDrivenComponent {
        return CustomText(
            text: text,
            appearance: try appearance?.mapToUIModel(),
            flex: try flex?.mapToUIModel(),
            accessibility: try accessibility?.mapToUIModel()
        )
    }
}

struct CustomText: Widget {

    let text: String

    var appearance: Appearance?
    var flex: Flex?
    var accessibility: Accessibility?

    func toView(context: BeagleContext, dependencies: RenderableDependencies) -> UIView {
//        let label = UILabel(frame: .zero)
//        label.text = text
//        label.numberOfLines = 0
//        return label

        let view = CustomTextView(text: text)

        view.flex.setupFlex(flex)
        view.applyAppearance(appearance)
        dependencies.accessibility.applyAccessibilityAttributes(accessibility, to: view)
        return view
    }
}


class CustomTextView: UIView {

    private(set) lazy var label: UILabel = {
        let label = UILabel()
        label.font = .systemFont(ofSize: 17.0, weight: .bold)
        label.numberOfLines = 0
        label.textColor = .black
        return label
    }()

    init(text: String) {
        super.init(frame: .zero)

        backgroundColor = .blue

        label.text = text

        addSubview(label)
        label.translatesAutoresizingMaskIntoConstraints = false
        [
            label.topAnchor.constraint(equalTo: self.topAnchor),
            label.leftAnchor.constraint(equalTo: self.leftAnchor),
            label.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            label.rightAnchor.constraint(equalTo: self.rightAnchor)
        ].forEach { $0.isActive = true }
    }

    override func sizeThatFits(_ size: CGSize) -> CGSize {
        return label.sizeThatFits(size)
    }

    @available(*, unavailable)
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}
