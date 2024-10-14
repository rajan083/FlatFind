package com.example.flatfind

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest

class Login : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        var edt_name = findViewById<TextInputEditText>(R.id.name)
        var edt_email = findViewById<TextInputEditText>(R.id.email)
        var edt_password = findViewById<TextInputEditText>(R.id.password)
        var bt_login = findViewById<MaterialButton>(R.id.bt_login).setOnClickListener(){

            val name = edt_name.text.toString()
            val email = edt_email.text.toString()
            val password = edt_password.text.toString()
            login(name, email, password)
        }
    }
    private fun login(name: String, email: String, password: String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    val user = mAuth.currentUser
                    startActivity(Intent(this@Login, MainActivity::class.java))
                    val profileUpdate = userProfileChangeRequest {
                        displayName  = name
                    }
                    user?.updateProfile(profileUpdate)
                        ?.addOnCompleteListener{ profileUpdateTask->
                            if(profileUpdateTask.isSuccessful){
                                Log.d("Firebase", "User update with name: $name")
                            }else{
                                Log.e("Firebase", "User profile update failed")
                            }
                        }
                }else{
                    Log.e("Firebase","User registration failed", task.exception)
                }
            }

    }
}