package com.example.pgease

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pgease.Screens.ChooseType
import com.example.pgease.Screens.OwnerSignIn
import com.example.pgease.Screens.OwnerSignUpPage
import com.example.pgease.Screens.TanantsigninPage
import com.example.pgease.Screens.TenantSignup
import com.example.pgease.ui.theme.PGEaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PGEaseTheme {
                PgEaseApp()
            }
        }
    }
}


@Composable
fun PgEaseApp(
    modifier: Modifier = Modifier
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "choicePage") {
        composable("choicePage") {
            ChooseType(navController = navController)
        }
        composable("OwnerSignUp") {
            OwnerSignUpPage(navController = navController)
        }
        composable("OwnerSignIn") {
            OwnerSignIn(navController = navController)
        }
        composable("TenantSignUp") {
            TenantSignup(navController = navController)
        }
        composable("TenantSignIn") {
            TanantsigninPage(navController = navController)
        }

    }

}
