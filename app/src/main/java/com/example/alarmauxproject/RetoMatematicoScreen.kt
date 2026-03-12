package com.example.alarmauxproject

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RetoMatematicoScreen(
    onCompleted: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AlarmColors.Clock60),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(72.dp))

        // Title
        Text(
            text = "Reto matemático",
            color = AlarmColors.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Equation
        Text(
            text = "25 + 17 = ?",
            color = AlarmColors.Clock100,
            fontSize = 45.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Pink area with answer
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .height(320.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(AlarmColors.Clock20)
        ) {
            // Answer input box
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(203.dp)
                    .height(70.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(AlarmColors.White)
                    .border(1.dp, AlarmColors.Clock100, RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "42",
                    color = AlarmColors.Clock100,
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )
            }

            // Scrollbar indicator on the right
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 4.dp)
                    .width(5.dp)
                    .height(160.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(AlarmColors.Clock80.copy(alpha = 0.5f))
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Timer pill
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(28.dp))
                .background(AlarmColors.White)
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(28.dp))
                    .background(AlarmColors.Clock60)
                    .padding(horizontal = 24.dp, vertical = 16.dp),
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
        }

        Spacer(modifier = Modifier.weight(1f))

        // Numeric Keyboard
        NumericKeyboard(onCompleted = onCompleted)
    }
}

@Composable
fun NumericKeyboard(
    onCompleted: () -> Unit = {}
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
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back chevron
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

            // Center icons
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

            // Divider
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(24.dp)
                    .background(AlarmColors.Clock80.copy(alpha = 0.3f))
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Right icons
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardNavIcon(Icons.Filled.MoreHoriz)
                KeyboardNavIcon(Icons.Filled.Mic)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Keyboard grid
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Row 1: 1, 2, 3, -
            KeyboardRow(
                keys = listOf(
                    KeyData("1", false),
                    KeyData("2", false),
                    KeyData("3", false),
                    KeyData("-", true)
                )
            )
            // Row 2: 4, 5, 6, enter
            KeyboardRow(
                keys = listOf(
                    KeyData("4", false),
                    KeyData("5", false),
                    KeyData("6", false),
                    KeyData("⏎", true)
                )
            )
            // Row 3: 7, 8, 9, backspace
            KeyboardRow(
                keys = listOf(
                    KeyData("7", false),
                    KeyData("8", false),
                    KeyData("9", false),
                    KeyData("⌫", true)
                )
            )
            // Row 4: comma, 0, dot, send
            KeyboardRow(
                keys = listOf(
                    KeyData(",", false),
                    KeyData("0", false),
                    KeyData(".", false),
                    KeyData("▶", true, isSend = true)
                ),
                onSend = onCompleted
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

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
        Spacer(modifier = Modifier.height(8.dp))
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
                    .height(41.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(
                        if (key.isAccent) AlarmColors.Clock60
                        else AlarmColors.White
                    )
                    .clickable { if (key.isSend) onSend() },
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
