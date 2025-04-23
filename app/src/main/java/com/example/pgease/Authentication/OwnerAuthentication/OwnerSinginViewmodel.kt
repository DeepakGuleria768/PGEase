package com.example.pgease.Authentication.OwnerAuthentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApiNotAvailableException
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OwnerSinginViewmodel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _owneremail = MutableStateFlow("")
    val owneremail = _owneremail.asStateFlow()

    private val _ownerpassword = MutableStateFlow("")
    val ownerpassword = _ownerpassword.asStateFlow()


    // create setters

    fun getOwnerEmail(ownerEmail: String) {
        _owneremail.value = ownerEmail
    }

    fun getOwnerPassword(ownerPassword: String) {
        _ownerpassword.value = ownerPassword
    }

    // sign in

    fun ownerSignIn(onSuccess: () -> Unit, onFailure: (String) -> Unit) {

        if(_owneremail.value.isEmpty() || _ownerpassword.value.isEmpty()){
            onFailure("Please enter all fields")
            return
        }
        viewModelScope.launch {
            auth.signInWithEmailAndPassword(_owneremail.value, _ownerpassword.value)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        onSuccess()
                    } else {
                        onFailure(task.exception?.message ?: "Sign in Failed")
                    }
                }
        }
    }


}