package uz.itwithnurmuhammad.androidstatemanegements.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenWithRemember(
    onBackClick: (() -> Unit)? = null
) {
    var count by remember { mutableIntStateOf(value = 0) }
    Scaffold(
        topBar = {
            CustomAppBar(onBackClick = onBackClick)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Remember Counter: $count",
                fontSize = 24.sp,
                modifier = Modifier.padding(all = 16.dp)
            )
            Button(
                onClick = { count++ },
                modifier = Modifier.padding(all = 8.dp)
            ) {
                Text(text = "Oshir (+1)")
            }
            Button(
                onClick = { count-- },
                modifier = Modifier.padding(all = 8.dp)
            ) {
                Text(text = "Kamaytir (-1)")
            }
        }
    }
}