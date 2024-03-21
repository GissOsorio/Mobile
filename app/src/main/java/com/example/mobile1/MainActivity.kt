package com.example.mobile1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.mobile1.ui.theme.Mobile1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column (
        modifier = Modifier
            .background(Color.Cyan)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .background(Color.White)
        ){
            Text(
                text = "Hola",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(16.dp)
            )
            Text(
                text = "Bonjour",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(16.dp)
            )
            Text(
                text = "Ciao",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
        Text(
            text = "Hello $name!",
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Black)
        )
        Text(
            text = "How are you?",
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Black)
        )
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true

)
@Composable
fun GreetingPreview() {
    Mobile1Theme {
        Greeting("Giss")
    }
}