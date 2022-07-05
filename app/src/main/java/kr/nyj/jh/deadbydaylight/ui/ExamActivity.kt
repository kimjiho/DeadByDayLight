package kr.nyj.jh.deadbydaylight.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.nyj.jh.deadbydaylight.ui.ui.theme.DeadByDayLightTheme

class ExamActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = arrayListOf("Java", "objc", "Kotlin", "Dart")

        setContent {
            DeadByDayLightTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MakeLazyColumn(names = list)
                }
            }
        }
    }
}

@Composable
private fun MakeText(name: String) {
    Text(text = name)
}

@Composable
private fun MakeLazyColumn(names: List<String> = List(100) { "$it" }) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            MakeText(name = name)
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun DefaultPreview() {
    val list = arrayListOf("Java", "objc", "Kotlin", "Dart")

    DeadByDayLightTheme {
        MakeLazyColumn(names = list)
    }
}




