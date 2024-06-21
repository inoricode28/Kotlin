package pe.edu.idat.appcomponentsadvanced

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun tituloDialog(titulo: String,
                 modifier: Modifier = Modifier.padding(bottom = 12.dp)){
    Text(text = titulo,
        fontWeight = FontWeight.SemiBold,
        //fontSize = 20.dp,
        modifier = modifier)

}



@Composable
fun EjemploDialogBasic(
    mostrar: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {

    if (mostrar) {
        AlertDialog(onDismissRequest = { onDismiss() },
            confirmButton = {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Confirmar")

                }
            },
            dismissButton = {
                            TextButton(onClick = { onDismiss }) {
                                Text(text = "Cerar")
                                
                            }
            },
            title = { Text(text = "Titulo Dialog") },
            text = { Text(text = "Hola soy un Dialog en Compose") }
        )

    }


}