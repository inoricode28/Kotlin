package pe.edu.idat.appcomponentsadvanced

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog


@Composable
fun EjemploDialogAdvace(
    mostrar: Boolean,
    onDismiss: () -> Unit
) {
    if (mostrar) {
        Dialog(onDismissRequest = { onDismiss }) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                tituloDialog(titulo = "Elegir un email: ")
                itemOption(
                    email = "Ejemplo1@gmail.com",
                    drawable = R.drawable.ic_launcher_foreground
                )
                itemOption(
                    email = "Ejemplo1@gmail.com",
                    drawable = R.drawable.ic_launcher_background
                )
                itemOption(
                    email = "Ejemplo1@gmail.com",
                    drawable = R.drawable.ic_launcher_foreground
                )
                itemOption(
                    email = "Aniadir nuevo",
                    drawable = R.drawable.ic_launcher_foreground)

            }

        }
    }
}


@Composable
fun itemOption(email: String, @DrawableRes drawable: Int) {
    TextButton(onClick = { /*TODO*/ }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = "img",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Text(
                text = email, fontSize = 14.sp,
                color = Color.Gray, modifier = Modifier.padding(8.dp)
            )

        }

    }

}


@Composable
fun EjemploDialogConfirmation(
    mostrar: Boolean,
    onDismiss: () -> Unit
) {
    if (mostrar) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                tituloDialog(titulo = "Titulo Prueba", Modifier.padding(24.dp))
                Divider(
                    Modifier.fillMaxWidth(),
                    color = Color.LightGray
                )
                Row(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(8.dp)
                ) {
                    TextButton(onClick = { onDismiss() }) {
                        Text(text = "Cancelar")
                    }
                    TextButton(onClick = { onDismiss() }) {
                        Text(text = "OK")
                    }

                }


            }

        }
    }
}

@Composable
fun tituloDialog(
    titulo: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)
) {
    Text(
        text = titulo, fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )

}


@Composable
fun EjemploDialogBasic(
    mostrar: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit
) {

    if (mostrar) {
        AlertDialog(onDismissRequest = { onDismiss() },
            confirmButton = {
                TextButton(onClick = { onConfirm }) {
                    Text(text = "Confirmar")

                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss }) {
                    Text(text = "Cerar")

                }
            },
            title = { Text(text = "Titulo Dialog") },
            text = { Text(text = "Hola soy un Dialog en Compose") })

    }


}