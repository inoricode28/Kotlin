package pe.edu.idat.appec01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.appec01.databinding.ActivityPromedioNotasBinding

class PromedioNotasActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPromedioNotasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPromedioNotasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BtnCalcular.setOnClickListener(this)

    }

    fun calcularPromedio(nota1: Double, nota2: Double, nota3: Double, nota4: Double): Double {
        // Crear una lista con las notas
        val notas = listOf(nota1, nota2, nota3, nota4)

        // Encontrar la nota más baja
        val notaMinima = notas.minOrNull() ?: 0.0

        // Eliminar la nota más baja de la lista de notas
        val notasSinMinima = notas.filter { it != notaMinima }

        // Calcular el promedio con la fórmula dada
        val promedio = notasSinMinima[0] * 0.2 + notasSinMinima[1] * 0.3 + notasSinMinima[2] * 0.5

        return promedio
    }


    override fun onClick(v: View?) {
        val calculo = calcularPromedio(
            binding.TbN1.text.toString().toDouble(),
            binding.TbN2.text.toString().toDouble(),
            binding.TbN3.text.toString().toDouble(),
            binding.TbN4.text.toString().toDouble()
        )
        val resultado = "La nota es: $calculo"
        binding.TxtResulNotas.setText(resultado)
    }
}

