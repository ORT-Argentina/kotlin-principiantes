package ort.tp3.cars.ui.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import ort.tp3.cars.R

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton: Button = findViewById(R.id.loginButton)
        val usernameInput: TextView = findViewById(R.id.emailLogin)
        val passwordInput: TextView = findViewById(R.id.passwordLogin)

        loginButton.setOnClickListener {
            val email: String = usernameInput.text.toString()
            val password: String = passwordInput.text.toString()

            if (validateInputs(email, password)) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", email)
                startActivity(intent)
            }
        }

    }

    private fun validateInputs(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            showToast("Por favor ingresa un email.")
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("Por favor ingresa un email valido.")
            return false
        }

        if (password.isEmpty()) {
            showToast("Por favor ingresa una password.")
            return false
        }

        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
