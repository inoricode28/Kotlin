package pe.idat.apppatitas_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.idat.apppatitas_compose.auth.view.loginScreen
import pe.idat.apppatitas_compose.auth.view.registroScreen
import pe.idat.apppatitas_compose.ui.theme.ApppatitascomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApppatitascomposeTheme {
//                loginScreen()
                registroScreen()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApppatitascomposeTheme {

    }
}