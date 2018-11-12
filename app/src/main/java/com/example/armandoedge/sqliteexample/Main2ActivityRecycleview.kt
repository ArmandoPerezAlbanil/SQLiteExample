package com.example.armandoedge.sqliteexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2_recycleview.*

class Main2ActivityRecycleview : AppCompatActivity(){

    val avisos: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2_recycleview)

        // Loads animals into the ArrayList
        addAnimals()

        // Creates a vertical Layout Manager
        rv_avisos_list.layoutManager = LinearLayoutManager(this)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_animal_list.layoutManager = GridLayoutManager(this, 2)

        // Access the RecyclerView Adapter and load the data into it
        rv_avisos_list.adapter = AvisosAdapter(avisos, this)

    }
    fun addAnimals() {
        avisos.add("dog")
        avisos.add("cat")
        avisos.add("owl")
        avisos.add("cheetah")
        avisos.add("raccoon")
        avisos.add("bird")
        avisos.add("snake")
        avisos.add("lizard")
        avisos.add("hamster")
        avisos.add("bear")
        avisos.add("lion")
        avisos.add("tiger")
        avisos.add("horse")
        avisos.add("frog")
        avisos.add("fish")
        avisos.add("shark")
        avisos.add("turtle")
        avisos.add("elephant")
        avisos.add("cow")
        avisos.add("beaver")
        avisos.add("bison")
        avisos.add("porcupine")
        avisos.add("rat")
        avisos.add("mouse")
        avisos.add("goose")
        avisos.add("deer")
        avisos.add("fox")
        avisos.add("moose")
        avisos.add("buffalo")
        avisos.add("monkey")
        avisos.add("penguin")
        avisos.add("parrot")

    }
}



