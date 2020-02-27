package br.zup.com.beagle.android.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class MaskApplier(
    private val editText: EditText,
    private val mask: String
) : TextWatcher {

    private var isUpdating: Boolean = false
    private var old = ""
    private var beforeEdit: String = ""
    private var afterEdit: String = ""

    override fun afterTextChanged(s: Editable?) {}

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        beforeEdit = editText.text.toString()
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        afterEdit = editText.text.toString()
        if (beforeEdit.length <= afterEdit.length) {
            var selectionPlus = 0
            val selection = editText.selectionStart
            val str = unmask(s.toString())
            var mascara = ""
            if (isUpdating) {
                old = str
                isUpdating = false
                return
            }
            var i = 0
            for (m in mask.toCharArray()) {
                if (str.length + selectionPlus <= i)
                    break

                if (m == '#') {
                    mascara += str.get(i - selectionPlus)
                } else {
                    mascara += StringBuilder().append(m)
                    selectionPlus++
                }
                i++
            }
            isUpdating = true
            beforeEdit = mascara
            editText.setText(mascara)

            editText.setSelection(
                if (selection + selectionPlus > mascara.length)
                    mascara.length else selection + selectionPlus
            )
        }
    }

    private fun unmask(s: String): String {
        return s.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "")
            .replace("[/]".toRegex(), "").replace("[(]".toRegex(), "")
            .replace("[)]".toRegex(), "")
    }
}