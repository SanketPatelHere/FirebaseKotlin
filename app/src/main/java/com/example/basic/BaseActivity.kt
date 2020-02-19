package com.example.basic

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener{
    private var mSnackbar: Snackbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(ConnectivityReceiver(), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onResume() {
        super.onResume() //companion object //same as static = same as listener
        ConnectivityReceiver.connectivityReceiverListener = this
    }
    private fun showMessage(isConnected: Boolean)
    {
        if(!isConnected)
        {
            val messageToUser = "You are offline now"
            mSnackbar = Snackbar.make(findViewById(R.id.rootLayout), messageToUser, Snackbar.LENGTH_LONG)
            mSnackbar?.duration = Snackbar.LENGTH_INDEFINITE
            mSnackbar!!.show()
        }
        else
        {
            mSnackbar?.dismiss()
        }
    }
    //main method
    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        showMessage(isConnected)
    }

}