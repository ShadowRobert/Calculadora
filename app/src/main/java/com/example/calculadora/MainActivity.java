package com.example.shadowrobert;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import net.objecthunter.exp4j.ExpressionBuilder;

class MainActivity : AppCompatActivity() {

    // Declaración de las variables para los componentes visuales
    private lateinit var entradaEditText: EditText;
    private lateinit var resultadoTextView: TextView;
    private lateinit var calcularButton: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mostrarToast("1. onCreate()")

        // Vincular vistas con sus IDs (asegúrate de que los IDs coincidan con tu XML)
        entradaEditText = findViewById(R.id.editTextNumberDecimal)
        resultadoTextView = findViewById(R.id.text2) // Basado en el ID de tu imagen previa
        calcularButton = findViewById(R.id.button16)

        // Asignar el evento al botón usando lambdas de Kotlin
        calcularButton.setOnClickListener {
            calcularResultado()
        }
    }

    private fun calcularResultado() {
        val expresion = entradaEditText.text.toString().trim()

        if (expresion.isEmpty()) {
            resultadoTextView.text = "Por favor ingresa una expresión"
            return
        }

        try {
            // Evaluar la expresión matemática
            val resultado = evaluarExpresion(expresion)
            resultadoTextView.text = "Resultado: $resultado"
        } catch (e: Exception) {
            resultadoTextView.text = "Error: Expresión inválida"
        }
    }

    // Método para evaluar la expresión matemática usando exp4j
    private fun evaluarExpresion(expresion: String): Double {
        val expression = ExpressionBuilder(expresion).build()
        return expression.evaluate()
    }

    override fun onStart() {
        super.onStart()
        mostrarToast("2. onStart()")
    }

    override fun onResume() {
        super.onResume()
        mostrarToast("3. onResume()")
    }

    override fun onPause() {
        super.onPause()
        mostrarToast("4. onPause()")
    }

    override fun onStop() {
        super.onStop()
        mostrarToast("5. onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        mostrarToast("6. onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        mostrarToast("7. onDestroy()")
    }

    private fun mostrarToast(mensaje: String) {
        Toast.makeText(this, "Callback: $mensaje", Toast.LENGTH_SHORT).show()
    }
}