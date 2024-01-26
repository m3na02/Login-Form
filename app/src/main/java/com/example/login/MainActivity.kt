package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material.icons.sharp.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Displaying the login screen
                    DefaultLogin()
                }
            }
        }
    }
}

// Composable function for the login screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun login() {
    // Stating the variables to hold the user input
    var emailInput: String by remember { mutableStateOf("") }
    var passwordInput: String by remember { mutableStateOf("") }

    Column() {
        Text(
            // Displaying the text  "Login" with styling
            text = stringResource(R.string.login),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Start,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )
        // Email input filed with trailing email icon
        OutlinedTextField(
            value = emailInput,
            onValueChange = {emailInput = it},
            label = { Text(text = stringResource(id = R.string.email))},
            trailingIcon = {
                Icon(
                    imageVector = Icons.Sharp.Email,
                    contentDescription = stringResource(R.string.emailIcon)
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        // Password input  field with the trailing lock icon and visual transformation for password
        OutlinedTextField(
            value = passwordInput,
            onValueChange = {passwordInput = it.replace(" ", "•")},
            label ={ Text(text = stringResource(R.string.password))},
            trailingIcon = {
                Icon(
                    imageVector = Icons.Sharp.Lock,
                    contentDescription = stringResource(R.string.passwordIcon)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        // Button to sumbit login
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onClick = { submit() },
        ){
            Text(
                text = stringResource(R.string.submit),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultLogin() {
    LoginTheme {
        login()
    }
}

fun submit(){
    println("You have successful logged in!!")
}
