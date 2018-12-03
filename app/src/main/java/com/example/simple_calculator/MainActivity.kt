package com.example.simple_calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.support.design.widget.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plus = findViewById<Button>(R.id.plus_button)
        val minus = findViewById<Button>(R.id.minus_button)
        val division = findViewById<Button>(R.id.division_button)
        val multiplication = findViewById<Button>(R.id.multiplication_button)

        val result = findViewById<TextView>(R.id.result_text_view)
        val first = findViewById<EditText>(R.id.first_number)
        val second = findViewById<EditText>(R.id.second_number)

        val sign = findViewById<TextView>(R.id.sign_textView)

        //проверяет EditText-ы на пустоту, возвращает true, если оба не пусты
        fun checkValidity(first:EditText,second:EditText):Boolean = !((first.text.isEmpty()) || (second.text.isEmpty()))

        val constr = findViewById<View>(R.id.constr_layout) as ConstraintLayout

        plus.setOnClickListener(){
            if (checkValidity(first,second)){
                val returnableNumber = first.text.toString().toBigInteger() + second.text.toString().toBigInteger()
                result.setText("${returnableNumber}")
                sign.setText(R.string.plus)
            } else{
                Snackbar.make(
                    constr,
                    R.string.snackHint,
                    Snackbar.LENGTH_LONG
                ).show()
                sign.setText(R.string.error)
                result.setText("")
            }
        }

        minus.setOnClickListener(){
            if (checkValidity(first,second)){
                val returnableNumber = first.text.toString().toBigInteger() - second.text.toString().toBigInteger()
                result.setText("${returnableNumber}")
                sign.setText(R.string.minus)
            } else{
                Snackbar.make(
                    constr,
                    R.string.snackHint,
                    Snackbar.LENGTH_LONG
                ).show()
                sign.setText(R.string.error)
                result.setText("")
            }
        }

        division.setOnClickListener(){
            if (checkValidity(first,second)){
                if (second.text.toString().toBigInteger() == 0.toBigInteger()){
                    Snackbar.make(
                        constr,
                        R.string.nullDivision,
                        Snackbar.LENGTH_LONG
                    ).show()
                    sign.setText(R.string.error)
                    result.setText("")
                } else{
                    val returnableNumber = first.text.toString().toBigInteger() / second.text.toString().toBigInteger()
                    result.setText("${returnableNumber}")
                    sign.setText(R.string.division)
                }
            } else{
                Snackbar.make(
                    constr,
                    R.string.snackHint,
                    Snackbar.LENGTH_LONG
                ).show()
                sign.setText(R.string.error)
                result.setText("")
            }
        }

        multiplication.setOnClickListener(){
            if (checkValidity(first,second)){
                val returnableNumber = first.text.toString().toBigInteger() * second.text.toString().toBigInteger()
                result.setText("${returnableNumber}")
                sign.setText(R.string.multiplication)
            } else{
                Snackbar.make(
                    constr,
                    R.string.snackHint,
                    Snackbar.LENGTH_LONG
                ).show()
                sign.setText(R.string.error)
                result.setText("")
            }
        }
    }
}
