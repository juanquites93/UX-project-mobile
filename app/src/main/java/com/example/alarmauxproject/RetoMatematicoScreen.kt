package com.example.alarmauxproject

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Backspace
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.GifBox
import androidx.compose.material.icons.filled.Keyboard
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SentimentSatisfied
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RetoMatematicoScreen(
    onCompleted: () -> Unit = {}
) {
    var answer by remember { mutableStateOf("") }
    var isKeyboardVisible by remember { mutableStateOf(false) }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(AlarmColors.Clock60)
    ) {
        val vh = maxHeight

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // ~8vh top
            Spacer(modifier = Modifier.height(vh * 0.07f))

            // Title
            Text(
                text = "Reto matemático",
                color = AlarmColors.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )

            // ~3vh
            Spacer(modifier = Modifier.height(vh * 0.025f))

            // Pink area — proportional to viewport
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
                    .height(vh * 0.52f)
                    .clip(RoundedCornerShape(20.dp))
                    .background(AlarmColors.Clock20)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Top bar
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(6.dp)
                            .background(AlarmColors.Clock80)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    // Equation
                    Text(
                        text = "25 + 17 = ?",
                        color = AlarmColors.Clock100,
                        fontSize = 45.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(vh * 0.03f))

                    // Answer input box
                    Box(
                        modifier = Modifier
                            .width(203.dp)
                            .height(vh * 0.08f)
                            .clip(RoundedCornerShape(20.dp))
                            .background(AlarmColors.White)
                            .border(1.dp, AlarmColors.Clock100, RoundedCornerShape(20.dp))
                            .clickable { isKeyboardVisible = true },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (answer.isEmpty()) "?" else answer,
                            color = if (answer.isEmpty()) AlarmColors.Clock80.copy(alpha = 0.5f) else AlarmColors.Clock100,
                            fontSize = 45.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    // Timer pill
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(28.dp))
                            .background(AlarmColors.Clock60)
                            .padding(horizontal = 24.dp, vertical = vh * 0.015f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Schedule,
                            contentDescription = null,
                            tint = AlarmColors.White,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Llevas 42 seg de retraso",
                            color = AlarmColors.White,
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(vh * 0.02f))
                }

                // Scrollbar indicator on the right
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 4.dp)
                        .width(5.dp)
                        .height(vh * 0.18f)
                        .clip(RoundedCornerShape(20.dp))
                        .background(AlarmColors.Clock80.copy(alpha = 0.5f))
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Keyboard
            if (isKeyboardVisible) {
                NumericKeyboard(
                    keyHeight = vh * 0.048f,
                    onKeyPress = { key -> answer += key },
                    onBackspace = {
                        if (answer.isNotEmpty()) {
                            answer = answer.dropLast(1)
                        }
                    },
                    onSend = onCompleted
                )
            }
        }
    }
}

@Composable
fun NumericKeyboard(
    keyHeight: Dp = 41.dp,
    onKeyPress: (String) -> Unit = {},
    onBackspace: () -> Unit = {},
    onSend: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(AlarmColors.Clock20)
    ) {
        // Keyboard navbar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(26.dp)
                    .clip(CircleShape)
                    .background(AlarmColors.White),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.ChevronLeft,
                    contentDescription = null,
                    tint = AlarmColors.Clock100,
                    modifier = Modifier.size(18.dp)
                )
            }

            Spacer(modifier = Modifier.width(24.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardNavIcon(Icons.Filled.GifBox)
                KeyboardNavIcon(Icons.Filled.Settings)
                KeyboardNavIcon(Icons.Filled.Translate)
                KeyboardNavIcon(Icons.Filled.SentimentSatisfied)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(24.dp)
                    .background(AlarmColors.Clock80.copy(alpha = 0.3f))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardNavIcon(Icons.Filled.MoreHoriz)
                KeyboardNavIcon(Icons.Filled.Mic)
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Keyboard grid
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            KeyboardRow(keys = listOf(KeyData("1", false), KeyData("2", false), KeyData("3", false), KeyData("-", true)), keyHeight = keyHeight, onKeyPress = onKeyPress, onBackspace = onBackspace, onSend = onSend)
            KeyboardRow(keys = listOf(KeyData("4", false), KeyData("5", false), KeyData("6", false), KeyData("⏎", true)), keyHeight = keyHeight, onKeyPress = onKeyPress, onBackspace = onBackspace, onSend = onSend)
            KeyboardRow(keys = listOf(KeyData("7", false), KeyData("8", false), KeyData("9", false), KeyData("⌫", true)), keyHeight = keyHeight, onKeyPress = onKeyPress, onBackspace = onBackspace, onSend = onSend)
            KeyboardRow(keys = listOf(KeyData(",", false), KeyData("0", false), KeyData(".", false), KeyData("▶", true, isSend = true)), keyHeight = keyHeight, onKeyPress = onKeyPress, onBackspace = onBackspace, onSend = onSend)
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Bottom navigation indicator
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .width(72.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(AlarmColors.Clock80)
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
    }
}

data class KeyData(
    val label: String,
    val isAccent: Boolean,
    val isSend: Boolean = false
)

@Composable
fun KeyboardRow(
    keys: List<KeyData>,
    keyHeight: Dp = 41.dp,
    onKeyPress: (String) -> Unit = {},
    onBackspace: () -> Unit = {},
    onSend: () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        keys.forEach { key ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(keyHeight)
                    .clip(RoundedCornerShape(100.dp))
                    .background(
                        if (key.isAccent) AlarmColors.Clock60
                        else AlarmColors.White
                    )
                    .clickable {
                        when {
                            key.isSend -> onSend()
                            key.label == "⌫" -> onBackspace()
                            key.label == "⏎" -> { /* keyboard toggle, no-op */ }
                            else -> onKeyPress(key.label)
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                if (key.label == "⌫") {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Backspace,
                        contentDescription = "Backspace",
                        tint = AlarmColors.Clock100,
                        modifier = Modifier.size(22.dp)
                    )
                } else if (key.label == "▶") {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = "Send",
                        tint = AlarmColors.Clock100,
                        modifier = Modifier.size(22.dp)
                    )
                } else if (key.label == "⏎") {
                    Icon(
                        imageVector = Icons.Filled.Keyboard,
                        contentDescription = "Enter",
                        tint = AlarmColors.Clock100,
                        modifier = Modifier.size(22.dp)
                    )
                } else {
                    Text(
                        text = key.label,
                        color = AlarmColors.Clock100,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun KeyboardNavIcon(icon: ImageVector) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = AlarmColors.Clock100,
        modifier = Modifier.size(22.dp)
    )
}
