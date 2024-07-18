package pe.idat.appmvvmapirest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import pe.idat.appmvvmapirest.posts.view.ListaPostScreen
import pe.idat.appmvvmapirest.posts.view.PostViewModel
import pe.idat.appmvvmapirest.ui.theme.AppMVVMApiRestTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val postViewModel:PostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppMVVMApiRestTheme {
                ListaPostScreen(postViewModel)

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppMVVMApiRestTheme {

    }
}