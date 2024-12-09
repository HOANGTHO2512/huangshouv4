package qimokao.pi.edu.tw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import qimokao.pi.edu.tw.ui.theme.HuangshouqimokaoTheme
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HuangshouqimokaoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                    BackgroundColorSwitcher()
                }
            }
        }
    }
}

@Composable
fun BackgroundColorSwitcher() {
    var Maria = arrayListOf(R.drawable.maria0, R.drawable.maria1,
        R.drawable.maria2, R.drawable.maria3)
    val colors = listOf(
        Color(0xff95fe95),
        Color(0xfffdca0f),
        Color(0xfffea4a4),
        Color(0xffa5dfed))
    var currentIndex by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize().background(colors[currentIndex])
            .pointerInput(Unit) {
                detectHorizontalDragGestures { _, dragAmount ->
                    if (dragAmount > 0) {
                        currentIndex = (currentIndex + 1) % colors.size
                    } else if (dragAmount < 0) {
                        currentIndex = (currentIndex - 1 + colors.size) % colors.size
                    }
                }
            }
    ) {
        Text(
            text = "",
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center)
        )
    }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "2024期末上機考 (資管2B黎黃壽)",
                fontSize = 20.sp,
                color = Color.Black
            )
            Image(
                painter = painterResource(id = R.drawable.class_b),
                contentDescription = "Class A Image",
                modifier = Modifier.height(250.dp).width(700.dp)
            )
            Text(
                text = "遊戲持續時間 0 秒",
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                text = "您的成績 0 分",
                fontSize = 16.sp,
                color = Color.Black
            )
            Button(
                onClick = {},
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "結束App")
            }
            LazyRow {
                items(4) { index ->
                    Text(text = index.toString())
                    Image (
                        painter = painterResource(id = Maria[index % 10]),
                        contentDescription = ("可愛動物圖片"),
                        modifier = Modifier.fillParentMaxWidth(1.0f))
                }
        }
    }
    }
