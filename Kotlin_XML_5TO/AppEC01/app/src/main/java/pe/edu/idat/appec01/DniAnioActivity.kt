package pe.edu.idat.appec01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.appec01.databinding.ActivityDniAnioBinding
import java.util.Calendar

class DniAnioActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDniAnioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDniAnioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnValidar.setOnClickListener(this)

    }

    private fun obtenerMensajeDNI(anioNacimiento: Int?): String {
        return if (anioNacimiento != null) {
            val anioActual = Calendar.getInstance().get(Calendar.YEAR)
            val edad = anioActual - anioNacimiento

            if (edad >= 18) {
                "Debe sacar su DNI."
            } else {
                "No es necesario sacar su DNI."
            }
        } else {
            "Por favor, ingrese un año válido."
        }
    }

    override fun onClick(v: View?) {
        val anioText = binding.tbAnioReniec.text.toString()
        val anioNacimiento = anioText.toIntOrNull()
        val mensaje = obtenerMensajeDNI(anioNacimiento)
        binding.txtValidacionResultado.text = mensaje
    }
}