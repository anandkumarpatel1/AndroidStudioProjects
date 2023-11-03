package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input1 = findViewById<Button>(R.id.button1)
        val input2 = findViewById<Button>(R.id.button2)
        val input3 = findViewById<Button>(R.id.button3)
        val input4 = findViewById<Button>(R.id.button4)
        val input5 = findViewById<Button>(R.id.button5)
        val input6 = findViewById<Button>(R.id.button6)
        val input7 = findViewById<Button>(R.id.button7)
        val input8 = findViewById<Button>(R.id.button8)
        val input9 = findViewById<Button>(R.id.button9)
        val input0 = findViewById<Button>(R.id.buttonZro)
        val inputPoint = findViewById<Button>(R.id.buttonPoint)

        val inputPlus = findViewById<Button>(R.id.buttonPlus)
        val inputMin = findViewById<Button>(R.id.buttonMin)
        val inputMul = findViewById<Button>(R.id.buttonMul)
        val inputDiv = findViewById<Button>(R.id.buttonDiv)
        val inputPer = findViewById<Button>(R.id.buttonPer)

        val inputAC = findViewById<Button>(R.id.buttonAC)
        val inputDel = findViewById<Button>(R.id.buttonDel)
        val inputAns = findViewById<Button>(R.id.buttonAns)

        var input = findViewById<TextView>(R.id.input)
        var output = findViewById<TextView>(R.id.output)

        inputAC.setOnClickListener{
            input.text = ""
            output.text = ""
        }

        //number inputs
        inputPoint.setOnClickListener{
            input.append(".")
        }
        input1.setOnClickListener{
            input.append("1")
        }
        input2.setOnClickListener{
            input.append("2")
        }
        input3.setOnClickListener{
            input.append("3")
        }
        input4.setOnClickListener{
            input.append("4")
        }
        input5.setOnClickListener{
            input.append("5")
        }
        input6.setOnClickListener{
            input.append("6")
        }
        input7.setOnClickListener{
            input.append("7")
        }
        input8.setOnClickListener{
            input.append("8")
        }
        input9.setOnClickListener{
            input.append("9")
        }
        input0.setOnClickListener{
            input.append("0")
        }


        //operations
        inputPlus.setOnClickListener{
            input.append(" + ")
        }
        inputMin.setOnClickListener{
            input.append(" - ")
        }
        inputMul.setOnClickListener{
            input.append(" * ")
        }
        inputDiv.setOnClickListener{
            input.append(" / ")
        }
        inputPer.setOnClickListener{
            input.append("%")
            var str = input.text
            str = str.dropLast(1)
            output.text = ((str.toString().toFloat()) / 100).toString()
        }

        inputDel.setOnClickListener{
            var string = input.text
            string = string.dropLast(1)
            input.text = string
        }

        inputAns.setOnClickListener{

            val expression = ExpressionBuilder(input.text.toString()).build()
            val result = expression.evaluate()
            val longResult = result.toLong()

            if (result == longResult.toDouble()){
                output.text = longResult.toString()
            } else{
                output.text = result.toString()
            }
        }
    }
}