package com.example.materialcomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.materialcomponent.components.BottomAppBarBadgeScreen
import com.example.materialcomponent.components.BottomAppBarScreen
import com.example.materialcomponent.components.MaterialButtonScreen
import com.example.materialcomponent.components.MaterialSelectionUi
import com.example.materialcomponent.components.MaterialTextFieldScreen
import com.example.materialcomponent.components.MaterialToolBarScreen
import com.example.materialcomponent.ui.theme.MaterialComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialComponentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navHostController = rememberNavController()

                    NavHost(navController = navHostController, startDestination = "home_screen") {

                        composable("home_screen"){

                            HomeScreen(navHostController = navHostController)

                        }

                        composable("material_button") {

                            MaterialButtonScreen()

                        }

                        composable("material_text_fields"){

                            MaterialTextFieldScreen()

                        }

                        composable("material_selection"){

                            MaterialSelectionUi()

                        }

                        composable("material_toolbar"){

                            MaterialToolBarScreen()

                        }

                        composable("material_bottom_appBar"){

                            BottomAppBarScreen()

                        }

                        composable("material_bottom_badge"){

                            BottomAppBarBadgeScreen()

                        }

                    }
                }
            }
        }
    }
}


@Composable
fun HomeScreen(navHostController: NavHostController){

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment =  Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Button(onClick = { navHostController.navigate("material_button") }) {

            Text(text = "Material Button")

        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { navHostController.navigate("material_text_fields") }) {

            Text(text = "Material Text")

        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { navHostController.navigate("material_selection") }) {

            Text(text = "Material Selection Ui")

        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { navHostController.navigate("material_toolbar") }) {

            Text(text = "Material Toolbar Ui")

        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { navHostController.navigate("material_bottom_appBar") }) {

            Text(text = "Material Bottom AppBar")

        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { navHostController.navigate("material_bottom_badge") }) {

            Text(text = "Material Bottom Badge")

        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){


}