package kr.nyj.jh.deadbydaylight.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kr.nyj.jh.deadbydaylight.MainActivity
import kr.nyj.jh.deadbydaylight.R
import kr.nyj.jh.deadbydaylight.ui.ui.theme.DeadByDayLightTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeadByDayLightTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Handler(Looper.myLooper()!!).sendEmptyMessageDelayed(0, 2000)
                    //Greeting("Android")
                    //splashScreen(this)

                    OnboardingScreen(onContinueClicked = {
                        Intent(applicationContext, MainActivity::class.java).apply {
                            startActivity(this)
                            finish()
                        }
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun splashScreen(activity: Activity) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(3000L)
        //navController.navigate("main_screen")

        Intent(activity.applicationContext, MainActivity::class.java).apply {
            activity.startActivity(this)
            activity.finish()
        }
    }

//    Box(contentAlignment = Alignment.Center,
//        modifier = Modifier.fillMaxSize()) {
//        Image(painter = painterResource(id = R.drawable.ic_home_black_24dp),
//            contentDescription = "Logo",
//            modifier = Modifier.scale(scale.value))
//    }
    
    Text(
        text = "Dead by DayLight",
        color = Color.LightGray,
        style = MaterialTheme.typography.h2,
        modifier = Modifier.scale(scale.value)
    )
}

@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit) {

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Dead by Daylight")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text("Continue")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DeadByDayLightTheme {
        //Greeting("Android")
    }
}