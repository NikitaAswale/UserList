package com.example.userlist

import android.hardware.camera2.params.BlackLevelPattern
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.userlist.ui.theme.UserListTheme
import com.google.ai.client.generativeai.type.content


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserListTheme {
                User()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun User() {
    var myList = sampleUsers()
    val outlinedText = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize(),// Make the Column take up all available screen space vertically
        //.padding(8.dp)// Optional padding around the Column
        verticalArrangement = Arrangement.Center // Optional space between rows
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(color = Color.Blue).weight(0.5f),  // Assign weight
            //.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = outlinedText.value,
                onValueChange = { outlinedText.value = it },
                label = {
                    Text("Search")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                )
            )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)     // Assign weight 2 (double the size of Row 1 and 3)
                .background(Color.Black), // Background to visualize size
            //.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            LazyColumn {
                content {
                    itemsIndexed(myList, itemContent = { index, item ->
                        UserItem(item = item)
                    })
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f)     // Assign weight 1 (same as Row 1)
                .background(Color.DarkGray), // Background to visualize size
            //.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
          Icon(
              imageVector = Icons.Filled.Person,
              contentDescription = "Profile"
          )
            Spacer(modifier = androidx.compose.ui.Modifier.width(4.dp))
            Text(text = "Profile", color = Color.White)
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menu Button"
            )
            Spacer(modifier = androidx.compose.ui.Modifier.width(4.dp))
            Text(text = "More", color = Color.White)

                    // Icons.Filled.ChatBubble,
                    // Icons.Filled.Groups,
                    //Icons.Filled.Person,
                    //Icons.Filled.Menu
                //)

            }
        }
    }

@Composable
fun UserItem(item : UserdataClass) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = item.username,
            modifier = Modifier.clip(CircleShape).size(64.dp).scale((1.0f))
        )
        Column(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = item.username,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White

                )
            )
            Text(
                text = item.msg,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            )
        }
    }
}