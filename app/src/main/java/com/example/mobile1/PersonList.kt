package com.example.mobile1

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext


@Composable
fun PersonList() {
    var nombre by remember {
        mutableStateOf("")
    }
    var edad by remember {
        mutableIntStateOf(0)
    }
    var personas by remember {
        mutableStateOf(listOf<Person>())
    }

    val context = LocalContext.current
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextField(
                value = nombre,
                placeholder = {
                    Text(text = "Nombre")
                },
                onValueChange = { text ->
                   nombre = text
                }
            )
        }
        Spacer(modifier = Modifier
            .size(16.dp)
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextField(
                value = edad.toString(),
                placeholder = {
                    Text(text = "Edad")
                },
                onValueChange = { text ->
                    edad = text.toInt()
                }
            )

        }
        Spacer(modifier = Modifier
            .size(16.dp)
        )

        Button(onClick = {
            if ( nombre.isNotBlank()){
                val persona = Person(nombre, edad.toInt())
                personas = personas + persona
            } else {
                Toast
                    .makeText(context,
                        "Enter a valid name",
                        Toast.LENGTH_SHORT).show()
            }
            nombre = ""
            edad = 0

        }
            ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null

            )
        }
        Spacer(modifier = Modifier
            .size(16.dp)
        )
        Column {
            for (persona in personas) {
                Row {
                    Text(text = persona.name,
                        modifier = Modifier
                            .padding(16.dp))
                    Text(text = persona.age.toString(),
                        modifier = Modifier
                            .padding(16.dp))
                }
                Divider()
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun PersonPreview() {
    PersonList()
}