package com.poojasingh.exploringandroid.utils

import android.widget.Button
import android.widget.LinearLayout.LayoutParams
import androidx.core.content.ContextCompat
import androidx.core.widget.TextViewCompat
import com.poojasingh.exploringandroid.R

fun Button.create(btnText: String): Button {
    val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    params.setMargins(8, 16, 8, 0)
    this.run {
        text = btnText
        TextViewCompat.setTextAppearance(this, R.style.BodySmall_SemiBold_White)
        background = ContextCompat.getDrawable(this.context, R.drawable.rounded_corner_purple_bg)
        layoutParams = params
    }
    return this
}