package com.example.pgease.Screens

import android.widget.Toast
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pgease.Authentication.OwnerAuthentication.OwnerSinginViewmodel
import com.example.pgease.R
import com.example.pgease.ui.theme.myFont
import com.example.pgease.ui.theme.primaryLight

@Composable
fun OwnerSignIn(
    navController: NavController,
    viewmodel: OwnerSinginViewmodel = viewModel()
) {

    val context = LocalContext.current
    
    val EmailState by viewmodel.owneremail.collectAsState()
    val passwordState by viewmodel.ownerpassword.collectAsState()
    var eyeState by rememberSaveable { mutableStateOf(false) }


    val initialText = "not having account ? "
    val signUpText  = "SignUp"
    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = primaryLight)){
           pushStringAnnotation(tag = signUpText , annotation = signUpText)
            append(signUpText)
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(R.drawable.ownerimage),
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Crop,
            contentDescription = "ownerImage"
        )

           Spacer(Modifier.height(50.dp))

        OutlinedTextField(
            value = EmailState,
            singleLine = true,
            onValueChange = {viewmodel.getOwnerEmail(it)},
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
            onValueChange = {viewmodel.getOwnerPassword(it)},
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
            onClick = {
              viewmodel.ownerSignIn(
                  onSuccess = {
                      navController.navigate("OwnerHomeScreen")
                  },
                  onFailure = {
                      Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
                  }
              )
            },
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )
        {
            Text("SignIn",  fontSize = 25.sp, fontWeight = FontWeight.Bold, fontFamily = myFont)
        }

        Spacer(Modifier.height(15.dp))

        Text(text = annotatedString, fontFamily = myFont,
            modifier = Modifier.clickable{navController.navigate("OwnerSignUp"){
                launchSingleTop = true
                restoreState = true
                popUpTo("OwnerSignIn"){
                    inclusive = true
                }
            }},
            fontSize = 18.sp)
    }
}


@Preview
@Composable
fun OwnerSignInPreview() {
    OwnerSignIn(navController = rememberNavController())
}