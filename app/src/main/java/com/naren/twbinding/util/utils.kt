package com.naren.twbinding.util

import android.content.Context
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.BindingAdapter

@BindingAdapter("app:textChangedListener")
fun bindTextWatcher(editText: EditText , textWatcher: TextWatcher){
    editText.addTextChangedListener(textWatcher)
}

fun showMessage(context: Context , msg : String){
    Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
}