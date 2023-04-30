package com.sorrowblue.android.playground.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sorrowblue.android.playground.compose.poke.PokeApi
import com.sorrowblue.android.playground.compose.poke.model.common.PokeName
import com.sorrowblue.android.playground.compose.ui.theme.AndroidPlayGroundTheme

val List<PokeName>.japanease: String?
    get() {
        return find { it.language.name == "ja" }?.name
            ?: find { it.language.name == "ja-Hrkt" }?.name
    }

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val api = PokeApi(applicationContext)
        setContent {
            AndroidPlayGroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "PokeVersionList") {
                        composable("PokeVersionList") {
                            PokeVersionListScreen(api) {
                                navController.navigate("RegionList")
                            }
                        }
                        composable("RegionList") { PokeRegionListScreen(api) }
                    }
                }
            }
        }
    }
}
