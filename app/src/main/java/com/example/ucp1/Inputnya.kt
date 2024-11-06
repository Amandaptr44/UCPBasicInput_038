package com.example.ucp1

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text


@Preview (showBackground = true)
@Composable
fun Inputnya(modifier: Modifier = Modifier){
    Column {
    HeaderSection()}
    var origin by remember { mutableStateOf( "") }
    var departure by remember { mutableStateOf( "") }
    var arrival by remember { mutableStateOf( "") }
    var transport by remember { mutableStateOf( "") }

    var originsv by remember { mutableStateOf( "") }
    var departuresv by remember { mutableStateOf( "") }
    var arrivalsv by remember { mutableStateOf( "") }
    var transportsv by remember { mutableStateOf( "") }

    val listTr = listOf("Bus", "Ship", "Train", "Plane")

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Amanda Putri", fontSize = 16.sp,
            fontWeight = FontWeight.Bold)

        Text("Jawa Tengah", fontSize = 16.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier
            .padding(16.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth() .padding(5.dp),
            value = origin,
            onValueChange = {origin = it},
            label = {Text("Origin")}
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = departure,
            onValueChange = {departure = it},
            label = {Text("Departure")}
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = arrival,
            onValueChange = {arrival = it},
            label = { Text("Arrival") }
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = transport,
            onValueChange = {transport = it},
            label = { Text("Choose Transportation") }
        )

        Button(onClick = {
            originsv = origin
            departuresv = departure
            arrivalsv = arrival
            transportsv = transport
        }) {
            Text("Submit")
        }
            Row {
            listTr.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically) { RadioButton(
                    selected = transport == item,
                    onClick = {
                        transport = item
                    }
                )
                    Text(item)
                }
            }


            }
            ElevatedCard(
                colors = CardDefaults.cardColors(containerColor = Color.Blue), modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Blue)
            ) {
                Detail(judul = "Origin", isinya = originsv)
                Detail(judul = "Departure", isinya = departuresv)
                Detail(judul = "Arrival", isinya = arrivalsv)
                Detail(judul = "Transport", isinya = transportsv)

            }
        }

    }


@Composable
fun HeaderSection() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Blue)
        .padding(20.dp))
}

@Composable
fun Detail(
    judul : String, isinya : String
){
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        ){

    }

    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(2.dp)
    ){
        Text(text = judul,
            modifier = Modifier.weight(0.8f))
        Text(text = ":")
    }
}