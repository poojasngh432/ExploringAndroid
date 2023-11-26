package com.poojasingh.exploringandroid.utils

import android.widget.TextView

// Get the text view width in pixels
fun TextView.width(): Int{
    this.measure(0,0)
    return this.measuredWidth
}

// Get the text view height in pixels
fun TextView.height(): Int{
    this.measure(0,0)
    return this.measuredHeight
}

// Put some dummy text to text view
fun TextView.dummyText(){
    this.text = "Lorem Ipsum is simply dummy text of the printing and" +
            " typesetting industry. Lorem Ipsum has been the industry's" +
            " standard dummy text ever since the 1500s, when an unknown" +
            " printer took a galley of type and scrambled" +
            " it to make a type specimen book."
}