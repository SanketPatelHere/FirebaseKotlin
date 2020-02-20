package com.example.basic
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_rec_demo.*


class RecDemoActivity : AppCompatActivity()
    /*, View.OnClickListener {
    override fun onClick(v: View?) {
    }*/
{
    var animals : ArrayList<Animals> = ArrayList();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rec_demo)
        addAnimals()
        rv_animal_list.layoutManager = LinearLayoutManager(this)

        /*
        var b : Button
        b.setOnClickListener(this)
        */

        //using abstract class = click event
        /*var myadapter = object  : AnimalAdapter(animals, this){
            override fun onItemClick(itm: Animals) {
                Toast.makeText(applicationContext, "item = "+itm.name,Toast.LENGTH_SHORT).show()
            }
        }*/

        //using interface = click event
        var myadapter = AnimalAdapter2(animals, this,
            object : AnimalAdapter2.OnItemClickListener{
                override fun onItemClicked2(itm: Animals) {
                    Toast.makeText(applicationContext, "Item = "+itm.name, Toast.LENGTH_SHORT).show()
                }


            })
        rv_animal_list.adapter = myadapter;

        //simple adapter
        //rv_animal_list.adapter = AnimalAdapter(animals, this);
    }

    fun addAnimals()
    {
        /*animals.add("Cow")
        animals.add("Dog")
        animals.add("Lion")
        animals.add("Tiger")*/

        animals.add(Animals("Cow",4))
        animals.add(Animals("Spider",8))
        animals.add(Animals("Monkey",2))
        animals.add(Animals("Dog",4))
        animals.add(Animals("Lion",4))
        animals.add(Animals("Tiger",4))
    }
}
