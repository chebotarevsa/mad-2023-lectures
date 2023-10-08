package ru.bsuedu.lec04.listview.core

import android.app.Activity
import android.widget.Toast


 fun Activity.toast(text: String): Unit {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}