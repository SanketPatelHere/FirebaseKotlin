package com.example.basic

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.getSystemService
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity(){//AppCompatActivity() {
    var count=10
    private lateinit var etName : EditText  //assign value as soon as possible

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addIds()


        //etName.setRawInputType(InputType.TYPE_CLASS_TEXT)
        //etName.setTextIsSelectable(true)

        println("kotlin demo")
        Log.i("My log =","hello world")
        Toast.makeText(applicationContext, "message of kotlin toast", Toast.LENGTH_LONG).show()

        //for(i in 1..10)
        for(i in 10 downTo 1)  //reverse loop
        {
            for(j in 1 until i) //for(j in 0 until(i))  //123456789
            //for(j in i downTo 1)  //10 9 8 7 6 5 4 3 2 1 = reverse loop = downTo
            {
                print(j)
            }
            println("\n")

        }

        var a = arrayOf(10,20,30,40,50)
        for(i in a)
        {
            print(i)
        }
        println()
        for(i in a.indices)
        {
            print("a[$i] = "+a[i]+" ")
        }
        println()

        var t=10
        var x : Int = 1
        while(x<=5)
        {
            print("while x = "+(x++))
        }

        var t1=10
        var x1:Int = 1
        do {
            print("\ndo while x1 = "+(x1++))
        }while (x1<=5)



        val name:String = "Sanket"
        var college:String = "Darshan"
        Toast.makeText(applicationContext, "name = "+name+", college = "+college,Toast.LENGTH_SHORT).show()

        var count=10
        count=15
        var ans:String = if (count==10)
        {
            "no. 10"
        }
        else
        {
            "no ans"
        }
        println("\nif_else ans = "+ans)

        var ans1 = when{
            count==15->"no. 10"
            count>20->"greter 20"
            else->"no ans"
        }
        println("when ans = "+ans1)

        var s:String = getString1() //return type = string
        println("fun simple s = "+s)
        var s1:String = getString1(20) //pass int, return string
        println("fun parameterized s1 = "+s1)

        var s2:(String)->Int={input->input.length} //anonymous function
        val len : Int = s2("Android")
        println("fun anonymous len = "+len)

        /*
        fun s3(str:String, mapper:String)->Int):Int
        {
            return mapper(str)
        }
        s3("Android", {input->input.length})  //or
        s3("Android") {input->input.length} //last parameter = define outside of function
        */

        //Class and objects=
        val car = Car()
        val car2 = Car2(10)
        println("Car = "+car.wheel)
        println("Car2 = "+car2.wheels)
        println("Car2 = "+car2.myvalue()) //private member access via function's return value


        //not working
        /*findViewById<Button>(R.id.btnSubmit).setOnClickListener {object : View.OnClickListener{
            override fun onClick(view: View) {
                addIds()
                var name = etName.text;
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(etName.windowToken, 0)
                //inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
                Toast.makeText(applicationContext,"Button Clicked = "+name,Toast.LENGTH_SHORT).show()
            }*/
        findViewById<Button>(R.id.btnSubmit).setOnClickListener {

            var name = etName.text;
            var btnSubmit = findViewById<Button>(R.id.btnSubmit)
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            //inputMethodManager.hideSoftInputFromWindow(etName.windowToken, 0)
            //inputMethodManager.hideSoftInputFromWindow(btnSubmit.windowToken, 0)
            Toast.makeText(applicationContext,"Button Clicked = "+name,Toast.LENGTH_SHORT).show()
        }

        var btnClass = findViewById<Button>(R.id.btnClass)
        btnClass.setOnClickListener {
            var intent = Intent(this, ClassScreenActivity::class.java).apply()
            {
                putExtra("name","Sanket Ramani")
            }
            startActivity(intent)

        }
    }

    fun getString1():String
    {
        val ans = if(count==10)
        {
            "no 10"
        }
        else if(count==15) "no. 15"
        else
        {
            "no ans"
        }
        return ans
    }
    fun getString1(countParam:Int):String
    {
        val ans = if(count>countParam)
        {
            "greater count"
        }
        else if(count<countParam)
        {
            "smaller count"
        }
        else
        {
            "no ans"
        }
        return  ans
    }

    private fun addIds() //View view => view : View
    {
        var etName = findViewById<EditText>(R.id.etName);
        var btnSubmit = findViewById<Button>(R.id.btnSubmit);

    }
}

class Car
{
    //val wheel = listOf<Wheel>()
    val wheel = 4
}
class Car2(var wheels: Int = 4)
{
    private var name = "Sanket"
    fun myvalue():String
    {
        return name
    }
}


