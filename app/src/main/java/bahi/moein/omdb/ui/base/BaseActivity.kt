package bahi.moein.omdb.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import bahi.moein.omdb.ui.dialog.LoadingDialog
import bahi.moein.omdb.utils.NetworkUtils
import javax.inject.Inject

/**
 * Baharm MoeinPour <bahi2034@gmail.com>
 */

/**
 *Base Activity with ViewModel and ViewBinding
 *
 * @param VM ViewBinding
 * @param VB ViewModel
 */
abstract class BaseActivity<VM : ViewModel, VB : ViewBinding> : AppCompatActivity() {

    @Inject
    lateinit var dialog: LoadingDialog

    protected abstract val mViewModel: VM

    protected lateinit var mViewBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = getViewBinding()
        setContentView(mViewBinding.root)
        onCreated(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        networkChanges()
    }


    protected fun showLoading(isLoading: Boolean) {

        if (isLoading) {
            dialog.showProgress()

        } else {
            dialog.dismissProgress()

        }
    }

    /**
     * Network listener
     *
     */
    private fun networkChanges() {
        NetworkUtils.getNetworkLiveData(applicationContext).observe(this) { isConnected ->
            onNetworkChanges(isConnected)
        }
    }

    abstract fun getViewBinding(): VB

    protected abstract fun onCreated(savedInstanceState: Bundle?)

    protected abstract fun onNetworkChanges(isConnected: Boolean)

}
