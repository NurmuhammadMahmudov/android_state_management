package uz.itwithnurmuhammad.androidstatemanegements

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.itwithnurmuhammad.androidstatemanegements.ui.composables.HomeScreenWithMVI
import uz.itwithnurmuhammad.androidstatemanegements.ui.composables.HomeScreenWithRemember
import uz.itwithnurmuhammad.androidstatemanegements.ui.composables.HomeScreenWithStateFlow
import uz.itwithnurmuhammad.androidstatemanegements.ui.composables.HomeScreenWithViewModel
import uz.itwithnurmuhammad.androidstatemanegements.ui.theme.AndroidStateManegementSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidStateManegementSTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterNavigation()
                }
            }
        }
    }
}

@Composable
fun CounterNavigation() {
    val navController = rememberNavController()

    @Composable
    fun HomeScreen(navController: NavHostController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(height = 30.dp))
            Text(
                text = stringResource(id = R.string.state_management_counterlar),
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(height = 16.dp))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
            ) {
                Button(onClick = { navController.navigate(route = "remember_route") }) {
                    Text(text = "Remember")
                }
                Spacer(modifier = Modifier.width(width = 8.dp))
                Button(onClick = { navController.navigate(route = "viewmodel_route") }) {
                    Text(text = "ViewModel")
                }
                Spacer(modifier = Modifier.width(width = 8.dp))
                Button(onClick = { navController.navigate(route = "stateflow_route") }) {
                    Text(text = "StateFlow")
                }
                Spacer(modifier = Modifier.width(width = 8.dp))
                Button(onClick = { navController.navigate(route = "mvi_route") }) {
                    Text(text = "MVI")
                }
            }

            Spacer(modifier = Modifier.height(height = 16.dp))
        }
    }

    NavHost(
        navController = navController,
        startDestination = "home",
    ) {
        composable(route = "home") {
            HomeScreen(navController)
        }
        composable(route = "remember_route") {
            HomeScreenWithRemember()
        }
        composable(route = "viewmodel_route") {
            HomeScreenWithViewModel()
        }
        composable(route = "stateflow_route") {
            HomeScreenWithStateFlow()
        }
        composable(route = "mvi_route") {
            HomeScreenWithMVI()
        }
    }
}