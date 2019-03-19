package com.app.nikhil.swiggyofferconcept

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.ImageView

class RotatingStarView : ImageView, ScrollListener {

  override fun onListScrolled(isScrolledTop: Boolean) {
    if (isScrolledTop)
      rotation += 5
    else
      rotation -= 5
  }

  constructor(context: Context) : super(context)

  constructor(
    context: Context,
    attrs: AttributeSet?
  ) : super(context, attrs)

  constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int
  ) : super(context, attrs, defStyleAttr)

  init {
    setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_star))
  }

  fun rotateMe(isScrollUp: Boolean) {
    if (isScrollUp) {
      rotation += 5
    } else {
      rotation -= 5
    }
  }
}

interface ScrollListener {
  fun onListScrolled(isScrolledTop: Boolean)
}