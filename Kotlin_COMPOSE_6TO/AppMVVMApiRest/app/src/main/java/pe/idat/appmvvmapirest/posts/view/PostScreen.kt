package pe.idat.appmvvmapirest.posts.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListaPostScreen(postViewModel: PostViewModel){
    Box(modifier = Modifier.fillMaxSize().padding(8.dp)){
        postViewModel.getPost()
    }

}

