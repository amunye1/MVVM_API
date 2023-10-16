package com.tc.beerlist.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tc.beerlist.ui.beeritem.BeerDetailScreen
import com.tc.beerlist.ui.beerlist.BeerScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val targetScreen = rememberSaveable { mutableStateOf(Screens.BeerList) }

    // Nav host integrations
    Scaffold(
        topBar = { Toolbar(targetScreen = targetScreen.value, navController = navController) }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screens.BeerList.route
        ) {
            composable(Screens.BeerList.route) {
                targetScreen.value = Screens.BeerList
                BeerScreen(navController = navController)
            }
            composable("${Screens.Detail.route}/{beerId}") { backStackEntry ->
                targetScreen.value = Screens.Detail
                BeerDetailScreen(
                    backStackEntry.arguments?.getString("beerId")!!.toInt()
                )
            }
        }
    }

}


// Toolbar integration
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    targetScreen: Screens,
    navController: NavController,

) = if (targetScreen != Screens.BeerList) {
    TopAppBar(

        title = { Text(text = targetScreen.header, color = Color.White) },
        navigationIcon = { BackButton(navController = navController) },
//        backgroundColor = Color(0xFF6F7FF7)
       // colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF6F7FF7))
    )
} else {
    TopAppBar(
        title = { Text(text = targetScreen.header, color = Color.White) },
//        backgroundColor = Color(0xFF6F7FF7)
        //colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF6F7FF7))
    )
}

// Back button integration
@Composable
fun BackButton(navController: NavController) {
    IconButton(onClick = { navController.popBackStack() }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.White
        )
    }
}