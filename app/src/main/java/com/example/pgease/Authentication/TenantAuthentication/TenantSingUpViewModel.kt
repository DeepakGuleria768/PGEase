package com.example.pgease.Authentication.TenantAuthentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TenantSingUpViewModel : ViewModel(

) {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // State flow for inputs
    private val _username =
        MutableStateFlow("") // MutableSateFlow is setter for the value (initial value)
    val username = _username.asStateFlow()

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _isPasswordVisible = MutableStateFlow(false)
    val isPasswordVisible = _isPasswordVisible.asStateFlow()

    // add setters
    fun onUsernameChange(newUserName: String) {
        _username.value = newUserName
    }

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun tenantSignUp(onSuccess: () -> Unit, onFailure: (String) -> Unit) {

        if(_username.value.isEmpty() || _email.value.isEmpty() || _password.value.isEmpty()){
            onFailure("please enter all fields")
            return // prevent screen closure
        }
        //A viewModelScope is defined for each ViewModel in our app.
        // Any coroutine launched in this scope is automatically canceled if the ViewModel is cleared.
        // This is useful for any work that needs to be done only when the ViewModel is active.
        // By destroying the scope when the ViewModel is destroyed, it saves us from potentially
        // wasting resources and memory leaks
        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(_email.value, _password.value)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        onSuccess()
                    } else {
                        onFailure(task.exception?.message ?: "SignUp Fail")
                    }
                }
        }

    }
}