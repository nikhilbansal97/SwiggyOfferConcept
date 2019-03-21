package com.app.nikhil.swiggyofferconcept

import android.content.Context
import android.support.constraint.ConstraintSet
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.app.nikhil.swiggyofferconcept.FoodRvAdapter.FoodItemViewHolder
import kotlinx.android.synthetic.main.layout_food_list_item.view.ivFoodImage
import kotlinx.android.synthetic.main.layout_food_list_item.view.ivOfferStar
import kotlinx.android.synthetic.main.layout_food_list_item.view.listItemContainer
import kotlinx.android.synthetic.main.layout_food_list_item.view.tvFoodCategory
import kotlinx.android.synthetic.main.layout_food_list_item.view.tvFoodTitle

class FoodRvAdapter(
  private val context: Context,
  private val foodList: List<Food>
) : RecyclerView.Adapter<FoodItemViewHolder>() {

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): FoodItemViewHolder = FoodItemViewHolder(
      LayoutInflater.from(context).inflate(R.layout.layout_food_list_item, parent, false)
  )

  override fun getItemCount(): Int = foodList.size

  override fun onBindViewHolder(
    viewHolder: FoodItemViewHolder,
    position: Int
  ) {
    viewHolder.bind(foodList[position])
  }

  fun recyclerViewScrolled(
    recyclerView: RecyclerView,
    scrollAmount: Int
  ) {
    var holder: FoodItemViewHolder?
    val startPos = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
    val endPos = (recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
    for (i in startPos .. endPos) {
      holder = recyclerView.findViewHolderForLayoutPosition(i) as FoodItemViewHolder?
      holder?.rotateOfferView(scrollAmount)
    }
  }

  class FoodItemViewHolder(itemView: View) : ViewHolder(itemView) {
    fun bind(food: Food) {
      itemView.tvFoodTitle.text = food.title
      itemView.tvFoodCategory.text = food.category
    }

    fun rotateOfferView(scrollAmount: Int) {
      itemView.ivOfferStar.rotate(scrollAmount)
    }
  }
}