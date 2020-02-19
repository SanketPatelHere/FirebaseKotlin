package com.example.basic

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class ConnectivityReceiver : BroadcastReceiver()
{
    interface ConnectivityReceiverListener
    {
        fun onNetworkConnectionChanged(isConnected: Boolean)
    }
    companion object{
        var connectivityReceiverListener: ConnectivityReceiverListener?=null
    }  //static jevu = access using class name = no need to make object
    //use for access outside of class also = everywhere in project

    override fun onReceive(context: Context?, intent: Intent?) {
        if(connectivityReceiverListener!=null)
        {
            //ConnectivityReceiver.connectivityReceiverListener!!.onNetworkConnectionChanged(isConnectedOrConnecting(context))
            connectivityReceiverListener!!.onNetworkConnectionChanged(isConnectedOrConnecting(context))
        }
    }

    private fun isConnectedOrConnecting(context: Context?):Boolean
    {
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnectedOrConnecting
    }

}