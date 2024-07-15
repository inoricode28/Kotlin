package pe.idat.appmvvm

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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.idat.appmvvm.auth.AuthViewModel
import pe.idat.appmvvm.auth.authScreen
import pe.idat.appmvvm.home.home
import pe.idat.appmvvm.model.Routes
import pe.idat.appmvvm.ui.theme.AppMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppMVVMTheme {
                val navigation = rememberNavController()
                NavHost(navController = navigation,
                    startDestination = Routes.loginScreen.path,
                    builder = {
                        composable(Routes.loginScreen.path){
                            authScreen(AuthViewModel())
                        }
                        composable(Routes.homeScreen.path,
                            arguments = listOf(navArgument("id"){type = NavType.IntType})
                        ){
                            params ->
                            home(navController = navigation,
                                id = params.arguments?.getInt("id") ?: 0)
                        }
                    })


            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppMVVMTheme {

    }
}