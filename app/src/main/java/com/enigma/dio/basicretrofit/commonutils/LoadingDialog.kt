package com.enigma.dio.basicretrofit.commonutils

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.enigma.dio.basicretrofit.R

class LoadingDialog{

    companion object {
        fun build(context: Context) : AlertDialog {
            val inflater = LayoutInflater.from(context).inflate(R.layout.loading_dialog, null)
            val dialog = AlertDialog.Builder(context).setView(inflater).setCancelable(true).create()
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            return dialog
        }
    }


}