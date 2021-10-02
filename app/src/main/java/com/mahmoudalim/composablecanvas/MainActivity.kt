package com.mahmoudalim.composablecanvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.mahmoudalim.composablecanvas.ui.theme.ComposableCanvasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableCanvasTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    FirstCanvas()
                    DrawCanvas(Shape.PackMan)
                    DrawCanvas(Shape.ProgressBar)

                }
            }
        }
    }

    enum class Shape {
        PackMan,
        ProgressBar;
    }

    @Composable
    private fun DrawCanvas(shape: Shape) {
        Canvas(
            modifier = Modifier
                .size(60.dp)
                .offset(if (shape == Shape.ProgressBar) 50.dp else 0.dp)
        ) {
            drawArc(
                color = Color.Green,
                startAngle = 0f,
                sweepAngle = 275f,
                useCenter = shape == Shape.PackMan,
                topLeft = Offset(40f, 40f),
                style = if (shape == Shape.ProgressBar) Stroke(width = 3.dp.toPx()) else Fill
            )


        }
    }


    @Composable
    fun FirstCanvas() {
        Canvas(
            modifier = Modifier
                .size(300.dp)
                .padding(40.dp)
        ) {
            drawRect(
                color = Color.Blue,
                size = size
            )
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(Color.Red, Color.Yellow),
                    center = center,
                    radius = 50.dp.toPx()
                ),
                radius = 50.dp.toPx(),
                center = center
            )

        }
    }
}