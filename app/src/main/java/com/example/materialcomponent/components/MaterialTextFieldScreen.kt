package com.example.materialcomponent.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.materialcomponent.ui.theme.MaterialComponentTheme

@Composable
fun MaterialTextFieldScreen(){

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            var filledText by remember {
                mutableStateOf("")
            }

            TextField(value = filledText, onValueChange = {
                filledText = it
            },
                textStyle = LocalTextStyle.current.copy(),
                label = {
                    
                    Text(text = "Enter your email")
                    
                },
                placeholder = {
                    
                    Text(text = "Email")
                    
                },
                leadingIcon = {

                    Icon(imageVector = Icons.Outlined.Email, contentDescription = "Email")

                },
                trailingIcon = {

                    Icon(imageVector = Icons.Outlined.Person, contentDescription = "Email")

                },
                suffix = {

                    Text(text = ".com")
                    
                },
                supportingText = {

                    Text(text = "Please enter valid email address")

                },
                isError = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onNext = {

                        Log.d("Submit","Submit Successfully...")

                    }
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            var outlinedText by remember {
                mutableStateOf("")
            }

            OutlinedTextField(value = outlinedText, onValueChange = {
                outlinedText = it
            },
                textStyle = LocalTextStyle.current.copy(),
                label = {

                    Text(text = "Enter your email")

                },
                placeholder = {

                    Text(text = "Email")

                },
                leadingIcon = {

                    Icon(imageVector = Icons.Outlined.Email, contentDescription = "Email")

                },
                trailingIcon = {

                    Icon(imageVector = Icons.Outlined.Person, contentDescription = "Email")

                },
                suffix = {

                    Text(text = ".com")

                },
                supportingText = {

                    Text(text = "Please enter valid email address")

                },
                isError = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onNext = {

                        Log.d("Submit","Submit Successfully...")

                    }
                )
            )
        }

}

@Preview(showBackground = true)
@Composable
fun MaterialTextFieldScreenPreview(){

    MaterialComponentTheme {

        MaterialTextFieldScreen()

    }

}