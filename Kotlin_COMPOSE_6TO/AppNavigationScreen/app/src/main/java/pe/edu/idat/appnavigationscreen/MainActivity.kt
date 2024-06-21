package pe.edu.idat.appnavigationscreen

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.idat.appnavigationscreen.ui.theme.AppNavigationScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigationScreenTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "pantallaA",
                    builder = {
                        composable("pantallaA"){
                            PantallaA(navController)
                        }
                        composable("pantallaB"){
                            PantallaB(navController)
                        }
                    })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppNavigationScreenTheme {

    }
}