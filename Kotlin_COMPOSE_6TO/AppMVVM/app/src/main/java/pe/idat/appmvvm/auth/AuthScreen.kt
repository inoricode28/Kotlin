package pe.idat.appmvvm.auth

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import pe.idat.appmvvm.model.Routes

@Composable
fun authScreen(authViewModel: AuthViewModel,
               navController: NavController) {
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState)})
    { paddinInit ->
        Box(
            modifier = Modifier
                .padding(paddinInit)
                .fillMaxSize()
        ) {
            Cabecera(modifier = Modifier.align(Alignment.TopEnd))
            cuerpo(modifier = Modifier.align(Alignment.Center),
                authViewModel, snackbarHostState, navController)

        }
    }
}

@Composable
fun cuerpo(modifier: Modifier, authViewModel: AuthViewModel,
           state: SnackbarHostState,navController: NavController){
    val usuario: String by authViewModel.usuario.observeAsState(initial = "")
    val password: String by authViewModel.password.observeAsState(initial = "")
    Column(modifier = modifier.padding(start = 10.dp, end = 10.dp)) {
        Spacer(modifier = Modifier.size(15.dp))
        txtusuario(usuario) { authViewModel.onLoginTextChanged(it, password) }
        Spacer(modifier = Modifier.size(15.dp))
        txtpassword(password) { authViewModel.onLoginTextChanged(usuario,it) }
        Spacer(modifier = Modifier.size(15.dp))
        authButton(authViewModel,state, navController)


    }
}

@Composable
fun authButton(authViewModel: AuthViewModel,
               state: SnackbarHostState,navController: NavController){
    val scope = rememberCoroutineScope()
    Button(onClick = {
       if (authViewModel.autenticarUsuario()){
           navController.navigate(Routes.homeScreen.paramHome(2))
       }else{
           scope.launch {
               state.showSnackbar(
                   "Usuario y/o password incorrecto",
                   actionLabel = "OK",
                   duration = SnackbarDuration.Short
               )
           }

       }
    }, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Ingresar")

    }
}



@Composable
fun Cabecera(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close,
        contentDescription ="Cerrar",
        modifier = modifier.clickable {  activity.finish()})
}


@Composable
fun txtusuario(usuario: String, onTextChanged: (String) -> Unit){
    OutlinedTextField(value = usuario,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Usuario") },
        maxLines = 1,
        singleLine = true ,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
fun txtpassword(password: String, onTextChanged: (String) -> Unit){
    var visible by rememberSaveable {
        mutableStateOf(false)
    }
    OutlinedTextField(value = password,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Password") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val imagen = if(visible){
                Icons.Filled.VisibilityOff
            }else{
                Icons.Filled.Visibility
            }
            IconButton(onClick = { visible = !visible }) {
                Icon(imageVector = imagen, contentDescription = "password")
                
            }

        },
        visualTransformation = if (visible){
            VisualTransformation.None
        }else PasswordVisualTransformation()
    )
}


