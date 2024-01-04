package site.aohan.compose_study_daily.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StateAndRecompositionScreen() {
    var name by rememberSaveable { mutableStateOf("admin") }
    var inputName by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "hello, $name")
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = inputName,
            onValueChange = { inputName = it }
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(onClick = { name = inputName }) {
            Text(text = "Display")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewStateAndRecomposition() {
    StateAndRecompositionScreen()
}