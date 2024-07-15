package pe.idat.appmvvm.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun home(navController: NavController,id: Int){
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Bienvenido $id",
            Modifier.align(Alignment.Center))
    }
}