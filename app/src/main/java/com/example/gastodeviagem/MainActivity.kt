package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalcular.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalcular) {
            calculate()
        }
    }

    private fun calculate() {
        if (validationOK()) {
            try {
                val distancia = editDistancia.text.toString().toFloat()
                val preco = editPreco.text.toString().toFloat()
                val autonomia = editAutonomia.text.toString().toFloat()
                val total = (distancia * preco) / autonomia
                textTotalValue.text = "R$ ${"%.2f".format(total)}"

            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.number_valid), Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, getString(R.string.required), Toast.LENGTH_LONG).show()
        }

    }

    private fun validationOK(): Boolean {
        return (editDistancia.text.toString() != ""
                && editPreco.text.toString() != ""
                && editAutonomia.text.toString() != "")
    }

}