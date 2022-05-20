package com.example.laboratorio4

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio4.ui.theme.Laboratorio4Theme
import kotlinx.coroutines.launch

lateinit var counterManager: Data
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginSCreen()
                }
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
    val textSize by remember { mutableStateOf(10.dp) }

        Column(modifier = Modifier.wrapContentSize()) {
        var escuela by rememberSaveable { mutableStateOf("") }
        var periodo by rememberSaveable { mutableStateOf("") }
        var codigo by rememberSaveable { mutableStateOf("") }
            var size by rememberSaveable { mutableStateOf("") }
        //
        Text(
            modifier = Modifier
                .padding(16.dp, 0.dp)
                .alpha(0.6f),
            text = "EMAIL",
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            fontSize = 12.sp
        )
        //email field
        OutlinedTextField(
            value = escuela,
            onValueChange = { escuela = it },

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType
                = KeyboardType.Email
            ),
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .fillMaxWidth(),

            )
        Text(
            modifier = Modifier
                .padding(16.dp, 0.dp)
                .alpha(0.6f),
            text = "PERIODO",
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            fontSize = 12.sp
        )
        //email field
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
        Text(
            modifier = Modifier
                .padding(16.dp, 0.dp)
                .alpha(0.6f),
            text = "Codigo",
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            fontSize = 12.sp
        )
        //email field
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
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                //launch the class in a coroutine scope
                scope.launch {
                    dataStore.saveCodigo(codigo)
                    dataStore.saveEscuela(escuela)
                    dataStore.savePeriodo(periodo)
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

                )
        }

            Text(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .alpha(0.6f),
                text = "Tamaño ",
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                fontSize = 12.sp
            )
            //email field
            OutlinedTextField(
                value = size,
                onValueChange = { size = it },

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
                scope.launch {
                    dataStore.saveSize(size as Float)

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
                text = "Aumentar Tamaño",

                )
        }
        Spacer(modifier = Modifier.height(32.dp))

        val userEmail = dataStore.getEscuela.collectAsState(initial = "")
        val userC = dataStore.getCodigo.collectAsState(initial = "")
        val userP = dataStore.getPeriodo.collectAsState(initial = "")

        Text(text = userEmail.value!!)
        Text(text = userP.value!!)
        Text(text = userC.value!!)


    }
}
@Composable
fun Greeting(context: Context) {

    Surface() {
        Column() {
            Button(onClick = { /*TODO*/ }) {

            }
            Text("")
            Button(onClick = { /*TODO*/ }) {

            }

        }
    }
}

