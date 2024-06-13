package pe.edu.idat.appec01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.appec01.databinding.ActivityAnioBisiestoBinding
import pe.edu.idat.appec01.databinding.ActivityMainBinding

class AnioBisiestoActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityAnioBisiestoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnioBisiestoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnValidarA.setOnClickListener(this)
    }

    fun esBisiesto(anio: Int): Boolean {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)
    }

    override fun onClick(v: View?) {
        val anio = binding.txtAnio.text.toString().toIntOrNull()

        if (anio != null) {
            val esBisiesto = esBisiesto(anio)
            val resultado = "El año $anio ${if (esBisiesto) "es" else "no es"} bisiesto."
            binding.txtResultBS.text = resultado
        } else {
            binding.txtResultBS.text = "Por favor, ingrese un año válido."
        }
    }
}

