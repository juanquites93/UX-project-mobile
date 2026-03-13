package com.example.alarmauxproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.automirrored.outlined.VolumeUp
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.DoubleArrow
import androidx.compose.material.icons.outlined.Vibration
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import kotlinx.coroutines.launch
import androidx.compose.ui.unit.IntOffset

object AlarmColors {

    val Clock100 = Color(0xFF31111D)
    val Clock80 = Color(0xFF633B48)
    val Clock60 = Color(0xFF7D5260)
    val Clock40 = Color(0xFFF2B8C6)
    val Clock20 = Color(0xFFFFD9E4)
    val White = Color(0xFFFFFFFF)
}

@Composable
fun AlarmScreen(modifier: Modifier = Modifier, onUnlock: () -> Unit = {}) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AlarmColors.Clock80)
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "BUENOS DÍAS",
            style = MaterialTheme.typography.headlineMedium.copy(color = AlarmColors.White),
            modifier = Modifier.padding(bottom = 32.dp)
        )
        TimeCard()
        Text(
            text = "2 Retos faltantes",
            style = MaterialTheme.typography.bodyLarge.copy(color = AlarmColors.White),
            modifier = Modifier.padding(top = 32.dp, bottom = 32.dp)
        )
        UnlockBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            onUnlock = onUnlock
        )
        Text(
            text = "Posponer (2 Backups)",
            style = MaterialTheme.typography.bodyLarge.copy(color = AlarmColors.White),
            modifier = Modifier.padding(top = 32.dp, bottom = 32.dp)
        )
    }
}

@Composable
fun TimeCard() {
    var currentTime by remember { mutableStateOf(getCurrentTime()) }
    var currentTimeMarker by remember { mutableStateOf(getCurrentTimeMarker()) }
    LaunchedEffect(Unit) {
        while (true) {
            currentTime = getCurrentTime()
            currentTimeMarker = getCurrentTimeMarker()
            delay(1000)
        }
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = AlarmColors.Clock20
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = currentTime,
                style = MaterialTheme.typography.displayLarge.copy(color = AlarmColors.Clock100)
            )
            Text(
                text = currentTimeMarker,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier.weight(1f).padding(end = 8.dp),
            colors = androidx.compose.material3.CardDefaults.cardColors(
                containerColor = AlarmColors.Clock20
            )
        ) {
            Row(
                modifier = Modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.Vibration,
                    contentDescription = "Vibración",
                    tint = AlarmColors.Clock80
                )
                Text(
                    text = "Vibración",
                    style = MaterialTheme.typography.bodyMedium.copy(color = AlarmColors.Clock80),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        // Segundo recuadro: Volumen
        Card(
            modifier = Modifier.weight(1f).padding(start = 8.dp),
            colors = androidx.compose.material3.CardDefaults.cardColors(
                containerColor = AlarmColors.Clock20
            )
        ) {
            Row(
                modifier = Modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.VolumeUp,
                    contentDescription = "Volumen",
                    tint = AlarmColors.Clock80
                )
                Text(
                    text = "40%",
                    style = MaterialTheme.typography.bodyMedium.copy(color = AlarmColors.Clock80),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }

}

@Composable
fun UnlockBar(
    modifier: Modifier = Modifier,
    barHeight: Dp = 64.dp,
    circleSize: Dp = 56.dp,
    onUnlock: () -> Unit = {}
) {
    val barColor = AlarmColors.Clock20
    val buttonColor = AlarmColors.Clock60
    val textColor = AlarmColors.Clock80
    val iconColor = AlarmColors.Clock100
    val scope = rememberCoroutineScope()
    val density = LocalDensity.current
    var barWidthPx by remember { mutableStateOf(0f) }
    val circleSizePx = with(density) { circleSize.toPx() }
    val maxOffset = (barWidthPx - circleSizePx - with(density) { 8.dp.toPx() }).coerceAtLeast(0f)
    val offsetX = remember { Animatable(20f) }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(barHeight)
            .background(barColor, shape = CircleShape)
            .onGloballyPositioned { barWidthPx = it.size.width.toFloat() }
    ) {
        Row(
            modifier = Modifier.align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Empezar reto",
                color = textColor,
                style = MaterialTheme.typography.headlineMedium
            )
            Icon(
                imageVector = Icons.Filled.DoubleArrow,
                contentDescription = "Deslizar para desbloquear",
                tint = iconColor,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        // Botón deslizable
        Surface(
            shape = CircleShape,
            color = buttonColor,
            shadowElevation = 8.dp,
            modifier = Modifier
                .size(circleSize)
                .align(Alignment.CenterStart)
                .offset { IntOffset(offsetX.value.toInt(), 0) }
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onHorizontalDrag = { _, dragAmount ->
                            val newOffset = (offsetX.value + dragAmount).coerceIn(0f, maxOffset)
                            scope.launch { offsetX.snapTo(newOffset) }
                        },
                        onDragEnd = {
                            if (offsetX.value > maxOffset * 0.8f) {
                                scope.launch {
                                    offsetX.animateTo(maxOffset, tween(200))
                                    onUnlock()
                                    offsetX.snapTo(0f)
                                }
                            } else {
                                scope.launch { offsetX.animateTo(0f, tween(300)) }
                            }
                        }
                    )
                }
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Icon(
                    imageVector = Icons.Filled.ChevronRight,
                    contentDescription = "Desbloqueo",
                    tint = iconColor
                )
            }
        }
    }
}

fun getCurrentTime(): String {
    val sdf = SimpleDateFormat("hh:mm", Locale.getDefault())
    return sdf.format(Date())
}

fun getCurrentTimeMarker(): String {
    val sdf = SimpleDateFormat("a", Locale.getDefault())
    return sdf.format(Date())
}
