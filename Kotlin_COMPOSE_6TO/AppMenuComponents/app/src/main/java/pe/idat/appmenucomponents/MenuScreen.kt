package pe.idat.appmenucomponents

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploDrawer(){
    val items = listOf("Opcion 1", "Opcion 2", "Opcion 3")
    var itemSeleccionado by remember {
        mutableStateOf(items[0])
    }
    val scope = rememberCoroutineScope()
    val estado = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = estado,
        drawerContent = {
            Column {
                items.forEach {
                        item ->
                    NavigationDrawerItem(
                        icon = {Icon(imageVector = Icons.Filled.Check, contentDescription = "")},
                        label = { Text(text = item) },
                        selected = item == itemSeleccionado,
                        onClick = { itemSeleccionado = item
                            scope.launch {
                                estado.close()
                            }

                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding).clip(
                            RectangleShape))
                }
            }
        }) {
        Scaffold(
            topBar = {
                     TopAppBar(title = { Text(text = "App IDAT") },
                         navigationIcon = { IconButton(onClick = {
                             scope.launch {
                                 if (estado.isClosed){
                                     estado.open()
                                 }else{
                                     estado.close()
                                 }
                             }
                         }) {
                             Icon(imageVector = Icons.Filled.Menu, contentDescription = "")

                         }
                         },
                     colors = TopAppBarDefaults.topAppBarColors(
                         containerColor = Color.Blue,
                         titleContentColor = Color.White
                     ))
            },
            content = {
                innerPadding ->
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)){
                    Text(text = "Contenido del Screen")
                }
            }
        )
    }
}



@Composable
fun EjemploBottomBar(){
    val items = listOf("Home", "Contactos", "Perfil", "Buzon")
    var itemSeleccionado by remember {
        mutableStateOf(0)
    }

    BottomAppBar(
        containerColor = Color.Red,
        contentColor = Color.White
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(selected = itemSeleccionado == index,
                onClick = { itemSeleccionado = index },
                icon = { 
                    Icon(imageVector = Icons.Filled.Home, contentDescription = "") },
                label = { Text(text = item)})
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploToolBar(){
    TopAppBar(title = { Text(text = "Mi APP IDAT") },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = Color.White
        ),
        navigationIcon = { IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "",tint = Color.White)

        }},
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Call,
                    contentDescription = "",tint = Color.White)

            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "",tint = Color.White)

            }
        })
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EjemploScaffold(){
    var estado = remember {
        SnackbarHostState()
    }
    val corutineScope = rememberCoroutineScope()

    Scaffold(topBar = { EjemploToolBar()},
        snackbarHost = {
            SnackbarHost(hostState = estado)
        },
        content = {
            Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
                Button(onClick = {
                    corutineScope.launch {
                        estado.showSnackbar("Hola Clickeaste el Boton",
                            actionLabel = "OK",
                            duration = SnackbarDuration.Long)
                    }
                }) {
                    Text(text = "Mostrar SnackBar")

                }

            }
        },
    bottomBar = { EjemploBottomBar()})
}