package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val etPrimeiroNumero = findViewById<EditText>(R.id.etPrimeiroNumero)
        val etSegundoNumero = findViewById<EditText>(R.id.etSegundoNumero)

        val btSomar = findViewById<Button>(R.id.btSomar)
        val btSubtrair = findViewById<Button>(R.id.btSubtrair)
        val btDividir = findViewById<Button>(R.id.btDividir)
        val btMultiplicar = findViewById<Button>(R.id.btMultiplicar)

        val tvResult = findViewById<TextView>(R.id.tvResultado)

        var operacao = ""

        btSomar.setOnClickListener {
            operacao = "+"

            btSomar.setBackgroundColor(getColor(R.color.buttonSelected))
            btSubtrair.setBackgroundColor(getColor(R.color.button))
            btDividir.setBackgroundColor(getColor(R.color.button))
            btMultiplicar.setBackgroundColor(getColor(R.color.button))

        }
        btSubtrair.setOnClickListener {
            operacao = "-"

            btSomar.setBackgroundColor(getColor(R.color.button))
            btSubtrair.setBackgroundColor(getColor(R.color.buttonSelected))
            btDividir.setBackgroundColor(getColor(R.color.button))
            btMultiplicar.setBackgroundColor(getColor(R.color.button))
        }
        btDividir.setOnClickListener {
            operacao = "/"

            btSomar.setBackgroundColor(getColor(R.color.button))
            btSubtrair.setBackgroundColor(getColor(R.color.button))
            btDividir.setBackgroundColor(getColor(R.color.buttonSelected))
            btMultiplicar.setBackgroundColor(getColor(R.color.button))
        }
        btMultiplicar.setOnClickListener {
            operacao = "*"

            btSomar.setBackgroundColor(getColor(R.color.button))
            btSubtrair.setBackgroundColor(getColor(R.color.button))
            btDividir.setBackgroundColor(getColor(R.color.button))
            btMultiplicar.setBackgroundColor(getColor(R.color.buttonSelected))
        }

        val btCalcular = findViewById<Button>(R.id.btCalcular)

        btCalcular.setOnClickListener{

            val num1String = etPrimeiroNumero.text.toString()
            val num2String = etSegundoNumero.text.toString()

            if (operacao != "") {
                if (num1String.isNotEmpty() && num2String.isNotEmpty()) {
                    var result = 0.0

                    if (operacao == "+")
                        result = num1String.toDouble() + num2String.toDouble()
                    else if (operacao == "-")
                        result = num1String.toDouble() - num2String.toDouble()
                    else if (operacao == "/")
                        result = num1String.toDouble() / num2String.toDouble()
                    else if (operacao == "*")
                        result = num1String.toDouble() * num2String.toDouble()

                    //Toast.makeText(this, "O Resultado é: $result", Toast.LENGTH_LONG).show()
                    tvResult.text = "O Resultado é: " + result

                } else {
                    Toast.makeText(this, "Informe os 2 numeros para continuar", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Selecione a operação para continuar", Toast.LENGTH_SHORT).show()
            }
        }

    }
}