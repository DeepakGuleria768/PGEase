package com.example.pgease.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pgease.R
import com.example.pgease.ui.theme.myFont

@Composable
fun TanantsigninPage() {
    var EmailState by rememberSaveable { mutableStateOf("") }
    var passwordState by rememberSaveable { mutableStateOf("") }
    var eyeState by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.tenantimage),
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Crop,
            contentDescription = "ownerImage"
        )

        Spacer(Modifier.height(100.dp))



        OutlinedTextField(
            value = EmailState,
            singleLine = true,
            onValueChange = { EmailState = it },
            leadingIcon = {
                Icon(
                    Icons.Filled.Email,
                    contentDescription = "Username",
                    tint = Color.Black
                )
            },

            colors = TextFieldDefaults.colors(
                cursorColor = Color.Black,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Black

            ),
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = passwordState,
            singleLine = true,
            onValueChange = { passwordState = it },
            leadingIcon = {
                Icon(
                    Icons.Filled.Lock,
                    contentDescription = "Username",
                    tint = Color.Black
                )
            },

            colors = TextFieldDefaults.colors(
                cursorColor = Color.Black,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Black


            ),
            trailingIcon = {
                var eyeImage = if (eyeState) {
                    R.drawable.eyeopen
                } else {
                    R.drawable.eyeclose
                }
                IconButton(onClick = { eyeState = !eyeState }) {
                    Image(
                        painter = painterResource(eyeImage),
                        contentDescription = "image"
                    )
                }
            },
            visualTransformation = if (eyeState) VisualTransformation.None else PasswordVisualTransformation(),
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )
        Spacer(Modifier.height(50.dp))
        Button(
            onClick = {},
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )
        {
            Text("SignIn", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.height(15.dp))

        Text("not having account ? Register", fontSize = 18.sp,
            modifier = Modifier.clickable{})
    }
}

@Preview
@Composable
fun MyPreview(){
    TanantsigninPage()
}