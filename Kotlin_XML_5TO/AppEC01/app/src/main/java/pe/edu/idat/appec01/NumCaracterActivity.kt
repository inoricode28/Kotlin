package pe.edu.idat.appec01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.appec01.databinding.ActivityMainBinding
import pe.edu.idat.appec01.databinding.ActivityNumCaracterBinding

class NumCaracterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityNumCaracterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumCaracterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnConVersionC.setOnClickListener(this)
    }
    fun obtenerLetra(numero: Int): Char {
        return ('A'.toInt() + numero - 1).toChar()
    }

    override fun onClick(v: View?) {
        val numero = binding.tbCaracteNum.text.toString().toIntOrNull()
        if (numero != null) {
            val letra = obtenerLetra(numero)
            val resultado = "La letra correspondiente al número $numero es: $letra"
            binding.txtResultCN.text = resultado
        } else {
            binding.txtResultCN.text = "Entrada inválida. Por favor, ingrese un número entero válido."
        }
    }
}