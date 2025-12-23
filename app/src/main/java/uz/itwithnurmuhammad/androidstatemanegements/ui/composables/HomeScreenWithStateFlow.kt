package uz.itwithnurmuhammad.androidstatemanegements.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.itwithnurmuhammad.androidstatemanegements.ui.controllers.CounterStateFlowViewModel

@Composable
fun HomeScreenWithStateFlow(
    viewModel: CounterStateFlowViewModel = viewModel()
) {
    val count by viewModel.count.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "StateFlow Counter: $count",
            fontSize = 24.sp,
            modifier = Modifier.padding(all = 16.dp)
        )
        Button(
            onClick = { viewModel.increment() },
            modifier = Modifier.padding(all = 8.dp)
        ) {
            Text(text = "Oshir (+1)")
        }
        Button(
            onClick = { viewModel.decrement() },
            modifier = Modifier.padding(all = 8.dp)
        ) {
            Text(text = "Kamaytir (-1)")
        }
    }
}