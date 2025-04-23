package com.example.pgease.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pgease.ui.theme.myFont
import com.google.firebase.auth.FirebaseAuth

@Composable
fun TenantHomeScreen(
    navController: NavController
) {

    val auth = FirebaseAuth.getInstance()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Tenant Home Screen",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = myFont
        )
        Spacer(Modifier.height(30.dp))

        Button(
            onClick = {
                auth.signOut()
                navController.navigate("TenantSignIn")
            }, colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text("LogOut", fontSize = 30.sp, fontFamily = myFont)
        }
    }
}