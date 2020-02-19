package com.example.basic

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_class_screen.view.*

class ClassScreenActivity : BaseActivity(){//AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_screen)
        var message = intent.getStringExtra("name")
        var tvMessage = findViewById<TextView>(R.id.tvMessage).apply {
            text = message //call block function and return = with this value
        }

        if(!isNetworkAvailable(applicationContext))
        {
            Toast.makeText(applicationContext, "Internet is off", Toast.LENGTH_LONG).show()
        }

    }
    /*InternetCheck(object : InternetCheck.Consumer)
    {
        override fun accept(internet:Boolean?)
        {
            Log.i("My internet = ",internet+"");
        }
    }*/

    fun isNetworkAvailable(context: Context):Boolean
    {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as  ConnectivityManager
        var activeNetworkInfo: NetworkInfo?=null
        activeNetworkInfo = cm.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }

    override fun onResume() {
        super.onResume()
        if(!isNetworkAvailable(applicationContext))
        {
            Toast.makeText(applicationContext, "Internet is off", Toast.LENGTH_LONG).show()
        }
    }
}
