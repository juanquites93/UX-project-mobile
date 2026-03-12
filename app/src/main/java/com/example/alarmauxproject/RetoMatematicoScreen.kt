package com.example.alarmauxproject

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Schedule
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RetoMatematicoScreen(
    onCompleted: () -> Unit = {}
) {
    var answer by remember { mutableStateOf("") }

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

        // Pink area with answer input
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .height(320.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(AlarmColors.Clock20)
        ) {
            // Answer input box - now a real TextField
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
                BasicTextField(
                    value = answer,
                    onValueChange = { newValue ->
                        answer = newValue
                    },
                    textStyle = TextStyle(
                        color = AlarmColors.Clock100,
                        fontSize = 45.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    decorationBox = { innerTextField ->
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            if (answer.isEmpty()) {
                                Text(
                                    text = "?",
                                    color = AlarmColors.Clock80.copy(alpha = 0.5f),
                                    fontSize = 45.sp,
                                    fontWeight = FontWeight.Normal,
                                    textAlign = TextAlign.Center
                                )
                            }
                            innerTextField()
                        }
                    }
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
    }
}
