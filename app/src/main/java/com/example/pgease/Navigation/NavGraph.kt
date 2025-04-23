package com.example.pgease.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pgease.Screens.ChooseType
import com.example.pgease.Screens.OwnerHomePage
import com.example.pgease.Screens.OwnerSignIn
import com.example.pgease.Screens.TanantsigninPage
import com.example.pgease.Screens.TenantHomeScreen
import com.example.pgease.Screens.TenantSignup
import com.examstyple.pgease.Screens.OwnerSignUpPage

@Composable
fun NavGraphSetup(
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
        composable("OwnerHomeScreen"){
            OwnerHomePage(navController = navController)
        }
        composable("TenantHomeScreen"){
            TenantHomeScreen(navController = navController)
        }

    }
}