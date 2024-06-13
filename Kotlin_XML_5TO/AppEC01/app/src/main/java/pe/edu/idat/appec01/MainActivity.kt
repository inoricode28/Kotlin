package pe.edu.idat.appec01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.appec01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalcular.setOnClickListener(this)
    }



    fun calcularCostoEstacionamiento(horas: Double, minutos: Double): Double {
        val tiempoTotalEnHoras = horas + (minutos / 60.0)
        val costoPorHora = 1500 // costo por hora en centavos
        return tiempoTotalEnHoras * costoPorHora
    }

    override fun onClick(v: View?) {
        val calculo = calcularCostoEstacionamiento(
            binding.tbHora.text.toString().toDouble(),
            binding.tbMinutos.text.toString().toDouble()
        )
        val resultado = "El monto a pagar es: $calculo"
        binding.txtResultado.setText(resultado)
    }

}