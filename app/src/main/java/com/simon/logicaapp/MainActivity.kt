package com.simon.logicaapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.simon.logicaapp.R.string.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        buttonSubmit.setOnClickListener{ checkAnswers() }
    }

    private fun checkAnswers() {
        var corAnswers = 0

        if (validateAnswer(firstRowAnswer, getString(value_true))) corAnswers++
        if (validateAnswer(secondRowAnswer, getString(value_false))) corAnswers++
        if (validateAnswer(thirdRowAnswer, getString(value_false))) corAnswers++
        if (validateAnswer(fourthRowAnswer, getString(value_false))) corAnswers++

        Toast.makeText(this, getString(result_message, corAnswers), Toast.LENGTH_SHORT)
            .show()
    }

    private fun validateAnswer(input: EditText, s: String): Boolean {
        return input.text.toString().equals(s, true)
    }

}
