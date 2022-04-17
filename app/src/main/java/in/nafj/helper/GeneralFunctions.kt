package `in`.nafj.helper

import `in`.nafj.R
import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun ImageView.setImage(url: String) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.progress_loader)
        .into(this)
        .clearOnDetach()
}

fun ImageView.setImageWithCenter(url: String) {
    Glide.with(context)
        .load(url)
        .centerInside()
        .placeholder(R.drawable.progress_loader)
        .into(this)
        .clearOnDetach()
}


fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}