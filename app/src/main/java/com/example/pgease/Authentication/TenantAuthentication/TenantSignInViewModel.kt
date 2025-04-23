package com.example.pgease.Authentication.TenantAuthentication

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TenantSignInViewModel : ViewModel(){

    private val auth : FirebaseAuth = FirebaseAuth.getInstance()


    private val _tenantemail = MutableStateFlow("")
    val tenantemail = _tenantemail.asStateFlow()

    private val _tenantpassword = MutableStateFlow("")
    val tenantpassword = _tenantpassword.asStateFlow()


    // create setters

    fun getTenantEmail(tenantemail:String){
        _tenantemail.value = tenantemail
    }

    fun getTenantPassword(tenantpassword:String){
        _tenantpassword.value = tenantpassword
    }

    fun tenantSignIn(onSuccess :()->Unit,onFailure :(String)->Unit){
        if(_tenantemail.value.isEmpty() || _tenantpassword.value.isEmpty()){
            onFailure("Please enter all fields")
            return
        }
        auth.signInWithEmailAndPassword(_tenantemail.value,_tenantpassword.value)
            .addOnCompleteListener { task->
                if(task.isSuccessful){
                    onSuccess()
                }else{
                    onFailure(task.exception?.message?:"SignIn Fails")
                }
            }
    }
}