package uz.itwithnurmuhammad.androidstatemanegements.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.itwithnurmuhammad.androidstatemanegements.ui.controllers.CounterIntent
import uz.itwithnurmuhammad.androidstatemanegements.ui.controllers.CounterMVIViewModel

@Composable
fun HomeScreenWithMVI(
    viewModel: CounterMVIViewModel = viewModel(), onBackClick: (() -> Unit)? = null
) {
    val state by viewModel.state.collectAsState()
    Scaffold(
        topBar = {
            CustomAppBar(onBackClick = onBackClick)
        }) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "MVI Counter: ${state.count}",
                fontSize = 24.sp,
                modifier = Modifier.padding(all = 16.dp)
            )
            Button(
                onClick = { viewModel.sendIntent(intent = CounterIntent.Increment) },
                modifier = Modifier.padding(all = 8.dp)
            ) {
                Text(text = "Oshir (+1)")
            }
            Button(
                onClick = { viewModel.sendIntent(intent = CounterIntent.Decrement) },
                modifier = Modifier.padding(all = 8.dp)
            ) {
                Text(text = "Kamaytir (-1)")
            }
        }

    }
}