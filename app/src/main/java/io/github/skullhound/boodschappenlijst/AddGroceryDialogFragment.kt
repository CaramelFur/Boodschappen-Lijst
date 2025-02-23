package io.github.skullhound.boodschappenlijst

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class AddGroceryDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity.let {
            val builder = AlertDialog.Builder(it)
            val textInput = EditText(it)

            builder.setTitle("Add Grocery")
                .setView(textInput)
                .setCancelable(true)
                .setPositiveButton(R.string.ok
                ) { _, _ ->
                    if (textInput.text.isNotEmpty()) {
                        if (it is MainActivity)
                            it.addItem(textInput.text.toString())
                    }
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }

    companion object {
        const val TAG = "AddGroceryDialog"
    }

}