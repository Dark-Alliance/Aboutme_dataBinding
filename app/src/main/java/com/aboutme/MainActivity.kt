package com.aboutme

import android.content.Context
import android.inputmethodservice.InputMethodService
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Ravinder Rana")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName


        //findViewById<Button>(R.id.button).setOnClickListener {
        //addNickName(it) //context of the view the function needs.
        //}

        binding.button.setOnClickListener {
            addNickName(it)
        }

    }

    private fun addNickName(view: View) {


        binding.apply {
            //nicknameTv.text = binding.nicknameEt.text
            myName.nickName = nicknameEt.text.toString()
            invalidateAll()
            nicknameEt.visibility = View.GONE
            button.visibility = View.GONE
            nicknameTv.visibility = View.VISIBLE

        }

        val imm =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager //accessing keyboard functionality
        imm.hideSoftInputFromWindow(view.windowToken, 0) //hiding keyboard


    }


}