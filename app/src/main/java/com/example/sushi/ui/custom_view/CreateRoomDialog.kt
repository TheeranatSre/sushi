package com.example.sushi.ui.custom_view

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.sushi.R
import com.example.sushi.databinding.CreateRoomDialogBinding

class CreateRoomDialog(context: Context) {
    private val binding = CreateRoomDialogBinding.inflate(LayoutInflater.from(context))
    private var alertDialog = Dialog(context, R.style.Dialog_Theme)
    private var isimpleDialog: ISimpleDialog? = null

    init {
        alertDialog.setContentView(binding.root)
        handleCancelable(false)
    }

    fun dismiss() {
        alertDialog.dismiss()
    }

    fun show() {
        alertDialog.show()
    }

    private fun handleCancelable(isCancel: Boolean) {

        binding.closeDialog.setOnClickListener {
            dismiss()
        }

        if (isCancel) {
            handleClickedView(true, binding.dialogDimBackground)
        } else {
            handleClickedView(false, binding.dialogDimBackground)
        }
        handleClickedView(false, binding.dialogBox)
    }

    private fun handleClickedView(isDismiss: Boolean, view: View, listener: (() -> Unit)? = null) {
        view.setOnClickListener {
            isimpleDialog?.onDialogDismiss()
            listener?.invoke()
            if (isDismiss) {
                alertDialog.dismiss()
            }
        }
    }
}

interface ISimpleDialog {
    fun onDialogDismiss()
}