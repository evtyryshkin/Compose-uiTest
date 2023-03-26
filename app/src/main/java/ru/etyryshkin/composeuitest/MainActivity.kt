package ru.etyryshkin.composeuitest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import ru.etyryshkin.composeuitest.ui.theme.ComposeUiTestTheme

private const val START_CLICKER_VALUE = 0

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUiTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content() {
    var count by remember { mutableStateOf(START_CLICKER_VALUE) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(24.dp))
        Clicker(count)

        Spacer(Modifier.height(24.dp))
        Row {
            Button(
                onClick = { count-- },
                modifier = Modifier.testTag("Decrease")
            ) {
                Text(
                    text = stringResource(R.string.decrease_button)
                )
            }
            Spacer(Modifier.width(24.dp))
            Button(
                onClick = { count++ },
                modifier = Modifier.testTag("Increase")
            ) {
                Text(
                    text = stringResource(R.string.increase_button)
                )
            }
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
private fun Clicker(count: Int) {
    Text(
        text = stringResource(R.string.clicker_text, count),
        style = TextStyle(fontSize = TextUnit(32f, TextUnitType.Sp))
    )
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeUiTestTheme {
        Content()
    }
}