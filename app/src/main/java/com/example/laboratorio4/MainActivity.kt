package com.example.laboratorio4

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.laboratorio4.ui.theme.Laboratorio4Theme
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio4Theme {
                // A surface container using the 'background' color from the theme

                    LoginSCreen()

            }
        }
    }
}
@Composable
fun LoginSCreen() {
    //context
    val context = LocalContext.current
    // a coroutine scope
    val scope = rememberCoroutineScope()
    // we instantiate the saveEmail class
    val dataStore = Data(context)

    Column(
            modifier = Modifier
                .wrapContentSize()
                .verticalScroll(rememberScrollState())

    ) {
            var escuela by rememberSaveable { mutableStateOf("") }
            var periodo by rememberSaveable { mutableStateOf("") }
            var codigo by rememberSaveable { mutableStateOf("") }
            var nombre by rememberSaveable { mutableStateOf("") }
            var semestre by rememberSaveable { mutableStateOf("") }
            var duracion by rememberSaveable { mutableStateOf("") }
            var size by rememberSaveable { mutableStateOf("0") }

            var textSize by rememberSaveable { mutableStateOf("0") }
            scope.launch {
                dataStore.getSize.collect { data ->
                    textSize = data.toString()
                }
            }

            // Componente periodo
            Text(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .alpha(0.6f),
                text = "PERIODO ",
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                fontSize = textSize.toInt().sp
            )

            OutlinedTextField(
                value = periodo,
                onValueChange = { periodo = it },

                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType
                    = KeyboardType.Email
                ),
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .fillMaxWidth(),
            )


            // Componente ESCUELA
            Text(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .alpha(0.6f),
                text = "ESCUELA ",
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                fontSize = textSize.toInt().sp
            )

            OutlinedTextField(
                value = escuela,
                onValueChange = { escuela= it },

                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType
                    = KeyboardType.Email
                ),
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .fillMaxWidth(),

                )


            // Componente CODIGO
            Text(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .alpha(0.6f),
                text = "Codigo",
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                fontSize = textSize.toInt().sp
            )

            OutlinedTextField(
                value = codigo,
                onValueChange = { codigo = it },

                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType
                    = KeyboardType.Email
                ),
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .fillMaxWidth(),

                )

            // Componente NOMBRE
            Text(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .alpha(0.6f),
                text = "NOMBRE  ",
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                fontSize = textSize.toInt().sp
            )

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },

                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType
                    = KeyboardType.Email
                ),
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .fillMaxWidth(),
            )
            //COMPONENTE SEMESTRE
            Text(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .alpha(0.6f),
                text = "SEMESTRE: ",
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                fontSize = textSize.toInt().sp
            )

            OutlinedTextField(
                value = semestre,
                onValueChange = { semestre = it },

                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType
                    = KeyboardType.Text
                ),
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .fillMaxWidth(),
            )

            //COMPONENET DURACION
            Text(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .alpha(0.6f),
                text = "DURACION  ",
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                fontSize = textSize.toInt().sp
            )

            OutlinedTextField(
                value = duracion,
                onValueChange = { duracion = it },

                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType
                    = KeyboardType.Email
                ),
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .fillMaxWidth(),
            )


            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    //launch the class in a coroutine scope
                    scope.launch {
                        dataStore.saveCodigo(codigo)
                        dataStore.saveEscuela(escuela)
                        dataStore.savePeriodo(periodo)
                        dataStore.saveNombre(nombre)
                        dataStore.saveSemestre(semestre)
                        dataStore.saveDuracion(duracion)
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
            ) {
                Text(
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White,
                    text = "Guardar Datos",
                    fontSize = textSize.toInt().sp
                )
            }

            Text(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .alpha(0.6f),
                text = "Tamaño ",
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                fontSize = textSize.toInt().sp
            )
            //email field
            OutlinedTextField(

                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType
                    = KeyboardType.Number
                ),

                value = size,
                onValueChange = { size = it },
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .fillMaxWidth(),

                )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    scope.launch {

                        dataStore.saveSize(size.toFloat().toInt())
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
            ) {
                Text(
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White,
                    text = "Cambiar tamaño de letra",
                    fontSize = textSize.toInt().sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))



            Spacer(modifier = Modifier.height(32.dp))

            val userEscuela = dataStore.getEscuela.collectAsState(initial = "")
            val userC = dataStore.getCodigo.collectAsState(initial = "")
            val userP = dataStore.getPeriodo.collectAsState(initial = "")
            val userNom = dataStore.getEscuela.collectAsState(initial = "")
            val userSem = dataStore.getCodigo.collectAsState(initial = "")
            val userDur = dataStore.getPeriodo.collectAsState(initial = "")
            val userS = dataStore.getSize.collectAsState(initial = "")

            Text(text = "ESCUELA :  ${userEscuela.value!!}")
            Text(text = "PERIODO :  ${userP.value!!}")
            Text(text = "CODIGO :  ${userC.value!!}")
            Text(text = "NOMBRE :  ${userNom.value!!}")
            Text(text = "SEMESTRE :  ${userSem.value!!}")
            Text(text = "DURACION :  ${userDur.value!!}")

            Text(text = "TAMAÑO DE LETRA ${userS.value!!}")

        }

}








