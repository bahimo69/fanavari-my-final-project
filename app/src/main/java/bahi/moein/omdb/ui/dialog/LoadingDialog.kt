package bahi.moein.omdb.ui.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import dagger.hilt.android.qualifiers.ActivityContext
import bahi.moein.omdb.R
import javax.inject.Inject

/**
 * Baharm MoeinPour <bahi2034@gmail.com>
 */

class LoadingDialog @Inject constructor(@ActivityContext context: Context) : Dialog(context) {

    init {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        this.window?.setGravity(Gravity.CENTER)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.setCancelable(false)
        this.setContentView(R.layout.landing_dialog)

    }

    fun showProgress() {
        if (!this.isShowing) {
            this.show()
        }
    }

    fun dismissProgress() {
        if (this.isShowing) {
            this.dismiss()
        }
    }

}