package pe.edu.idat.appotroscomponentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EjemploRadioButton(nombre: String, onItemSelected: (String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(1.dp)
        ) {
            RadioButton(selected = nombre == "Ciclo 1",
                onClick = { onItemSelected("Ciclo 1") })
            Text(text = "Ciclo 1",Modifier.padding(top = 12.dp))
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(1.dp)
        ) {
            RadioButton(selected = nombre == "Ciclo 2",
                onClick = { onItemSelected("Ciclo 2") })
            Text(text = "Ciclo 2",Modifier.padding(top = 12.dp))
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(1.dp)
        ) {
            RadioButton(selected = nombre == "Ciclo 3",
                onClick = { onItemSelected("Ciclo 3") })
            Text(text = "Ciclo 3",Modifier.padding(top = 12.dp))
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(1.dp)
        ) {
            RadioButton(selected = nombre == "Ciclo 4",
                onClick = { onItemSelected("Ciclo 4") })
            Text(text = "Ciclo 4",Modifier.padding(top = 12.dp))
        }
    }
}

@Composable
fun EjemploSlider01() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var posicion01 by rememberSaveable {
            mutableStateOf(0f)
        }
        Slider(value = posicion01, onValueChange = { posicion01 = it })
        Text(text = posicion01.toString())
    }

}

@Composable
fun EjemploSlider02() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var posicion02 by rememberSaveable {
            mutableStateOf(0f)
        }
        Slider(value = posicion02, onValueChange = { posicion02 = it })
        Text(text = (posicion02 * 100).toString())
    }
}

@Composable
fun EjemploSlider03() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var posicion03 by rememberSaveable {
            mutableStateOf(1f) // Valor inicial entre 1 y 100
        }
        Slider(
            value = posicion03,
            onValueChange = { posicion03 = it },
            valueRange = 1f..100f // Rango del Slider entre 1 y 100
        )
        Text(text = posicion03.toInt().toString()) // Convertir a Int para mostrar valores enteros
    }
}

@Composable
fun EjemploSlider04() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var posicion04 by rememberSaveable {
            mutableStateOf(0f)
        }
        Slider(
            value = posicion04, onValueChange = { posicion04 = it },
            valueRange = 0f..10f,
            steps = 9
        )

        Text(text = posicion04.toString())
    }

}


@Composable
fun EjemploCombo() {
    var texto by rememberSaveable {
        mutableStateOf("")
    }
    var expandir by rememberSaveable {
        mutableStateOf(false)
    }
    val golosinas = listOf("Chocolates", "Caramelos", "Pastelitos", "Grageas", "Mashmellow")
    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(value = texto,
            onValueChange = { texto = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expandir = true }
                .fillMaxWidth())

        DropdownMenu(
            expanded = expandir,
            onDismissRequest = { expandir = false },
            Modifier.background(Color.White)
        ) {
            golosinas.forEach { itemGolosina ->
                DropdownMenuItem(text = { Text(text = itemGolosina) }, onClick = {
                    expandir = false
                    texto = itemGolosina
                }, Modifier.fillMaxWidth()
                )
            }

        }

    }
}


@Composable
fun EjemploCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .size(width = 240.dp, height = 120.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White, contentColor = Color.Green
        ),
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(1.dp, Color.Blue)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = "Hola Card")
            Text(text = "Hola Card")
            Text(text = "Hola Card")
            Text(text = "Hola Card")
        }
    }
}


@Composable
fun EjemploDivider() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(top = 14.dp), color = Color.Red
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ejemploBadgeBox() {
    BadgedBox(badge = {
        Badge(
            containerColor = Color.Red, contentColor = Color.Cyan
        ) {
            Text(text = "20")
        }
    }, Modifier.padding(7.dp)) {
        Icon(Icons.Filled.Star, contentDescription = "Favoritos")


    }
}