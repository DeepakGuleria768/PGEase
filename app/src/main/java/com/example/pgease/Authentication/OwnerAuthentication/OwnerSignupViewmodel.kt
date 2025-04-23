package com.example.pgease.Authentication.OwnerAuthentication

import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OwnerSignupViewmodel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()


    // State flow for inputs
    private val _username = MutableStateFlow("") // MutableSateFlow is setter for the value (initial value)
    val username = _username.asStateFlow()

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _isPasswordVisible = MutableStateFlow(false)
    val isPasswordVisible  = _isPasswordVisible.asStateFlow()

    // add setters
    fun onUsernameChange(newUserName:String){
        _username.value = newUserName
    }
    fun onEmailChange(newEmail:String){
        _email.value = newEmail
    }
    fun onPasswordChange(newPassword:String){
        _password.value = newPassword
    }


    // SignUp method
    fun signUpOwner(onSuccess : ()->Unit, onFailure :(String)->Unit){


        if(username.value.isEmpty() || email.value.isEmpty() || password.value.isEmpty()){
            onFailure("please enter all fields")
            return // prevent screen closure
        }

        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(_email.value,_password.value)
                .addOnCompleteListener { task->
                    if(task.isSuccessful){
                        onSuccess()
                    } else {
                        onFailure(task.exception?.message?:"SignIn failed")
                    }
                }
        }
    }



}