package pe.edu.idat.appcomponentsadvanced

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pe.edu.idat.appcomponentsadvanced.model.Mascota


@Composable
fun EjemploRecycleViewItem(){
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)){
        items(listarMascota()){
            mascota ->
            itemMascota(mascota = mascota)
        }

    }

}


@Composable
fun itemMascota(mascota: Mascota){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            contentColor = Color.White
        )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = mascota.imagen),
                contentDescription = "",
                modifier = Modifier.width(200.dp),
                contentScale = ContentScale.Crop)
            Column(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = mascota.nombre, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = mascota.raza)

            }
            
        }
    }
}

fun listarMascota(): List<Mascota>{
    return listOf(
        Mascota("Pepa", "Cooker",
            10,R.drawable.ic_launcher_background),
        Mascota("Hanna", "Husky",
            10,R.drawable.ic_launcher_background),
        Mascota("Simba", "Labrador",
            10,R.drawable.ic_launcher_background),
        Mascota("Toby", "Pekines",
            10,R.drawable.ic_launcher_background),
        Mascota("Bonnie", "Boxer",
            10,R.drawable.ic_launcher_background),
    )
}

@Composable
fun EjemploSimpleRecyclerView(){
    val listadoMascotas = listOf("Hana", "Pepa", "Simba", "Zeus")
    LazyColumn {
        item { Text(text = "Elemnto 1") }
        item { Text(text = "Elemnto 2") }
        item { Text(text = "Elemnto 3") }
        items(5) {
            Text(text = "Item $it")
        }
        items(listadoMascotas){mascota ->
            Text(text = "Bienvenido $mascota")
        }

    }

}