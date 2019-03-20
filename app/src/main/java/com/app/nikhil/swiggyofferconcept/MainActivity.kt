package com.app.nikhil.swiggyofferconcept

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.OnScrollListener
import kotlinx.android.synthetic.main.activity_main.rvFood

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val adapter = FoodRvAdapter(this, getSampleFoodList())
    rvFood.apply {
      this.adapter = adapter
      this.layoutManager = LinearLayoutManager(context)
      this.addOnScrollListener(object : OnScrollListener() {
        override fun onScrolled(
          recyclerView: RecyclerView,
          dx: Int,
          dy: Int
        ) {
          adapter.recyclerViewScrolled(recyclerView, dy)
        }
      })
    }
  }

  private fun getSampleFoodList(): List<Food> {
    val list = ArrayList<Food>()
    for (i in 1..10)
      list.add(Food("Food $i", "Category $i"))
    return list
  }
}
