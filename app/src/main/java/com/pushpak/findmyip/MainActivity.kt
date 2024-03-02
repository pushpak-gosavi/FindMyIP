package com.pushpak.findmyip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pushpak.findmyip.ui.theme.FindMyIPTheme
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.annotations.Async

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FindMyIPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GetMyIP()
                }
            }
        }
    }
}
@Composable
fun GetMyIP(){
    val myCorutine = rememberCoroutineScope()

    var setText by remember {
        mutableStateOf("")
    }
    var data by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = data)
        Spacer(modifier = Modifier.height(10.dp))
        TextField( placeholder = {
            "put some Text"
        },value = setText, onValueChange = {
            setText = it
        } )
        Button(onClick = {
            myCorutine.launch {
              val getDataFromAsync = async{ data =  setData(data= setText) }
                getDataFromAsync.await()
            }
        }) {
            Text(text = "Click me")
        }
    }
}

suspend fun setData(data: String):String{
    delay(5000)
    return data
}

@Preview(showBackground = true)
@Composable
fun PreviewGetMyIP(){
    GetMyIP()
}