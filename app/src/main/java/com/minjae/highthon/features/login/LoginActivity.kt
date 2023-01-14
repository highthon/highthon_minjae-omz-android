package com.minjae.highthon.features.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.minjae.highthon.core.theme.OmzTheme
import com.minjae.highthon.features.login.screen.LoginScreen
import com.minjae.highthon.root.MainActivity

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OmzTheme {
                val intent = Intent(this, MainActivity::class.java)
                LoginScreen {
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}