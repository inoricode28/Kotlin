package pe.edu.idat.appcomponentsadvanced

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.idat.appcomponentsadvanced.ui.theme.AppComponentsAdvancedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppComponentsAdvancedTheme {


            /* var mostrar by remember {
                 mutableStateOf(false)
             }
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center){
                    Button(onClick = { mostrar = true }) {
                        Text(text = "Mostrar Dialog")

                    }
                    /*EjemploDialogBasic(mostrar, onDismiss = {mostrar = false},
                        onConfirm = {mostrar = false})*/
                    EjemploDialogAdvace(mostrar = mostrar,
                        onDismiss = {mostrar = false})

                }*/
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 35.dp,
                        start = 15.dp, end = 15.dp, bottom = 35.dp
                    )){
                    //EjemploSimpleRecyclerView()
                    EjemploRecycleViewItem()

                }



            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppComponentsAdvancedTheme {

    }
}