package com.example.pgease

import android.R
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pgease.Screens.ChooseType
import com.example.pgease.Screens.OwnerSignIn
import com.example.pgease.Screens.TanantsigninPage
import com.example.pgease.Screens.TenantSignup
import com.example.pgease.ui.theme.AppTheme
import com.examstyple.pgease.Screens.OwnerSignUpPage

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
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
