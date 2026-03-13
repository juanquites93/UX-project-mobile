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
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun RetoCaminarScreen(
    onCompleted: () -> Unit = {}
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(AlarmColors.Clock60)
    ) {
        val vh = maxHeight // viewport height
        val vw = maxWidth  // viewport width

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 8vh top padding
            Spacer(modifier = Modifier.height(vh * 0.07f))

            // Title
            Text(
                text = "Alarma activa",
                color = AlarmColors.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )

            // 3.5vh
            Spacer(modifier = Modifier.height(vh * 0.03f))

            // Subtitle
            Text(
                text = "Camina para\ndesactivar",
                color = AlarmColors.White,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                lineHeight = 26.sp
            )

            // 5vh
            Spacer(modifier = Modifier.height(vh * 0.04f))

            // Image placeholder card — 25vh square
            val imageSize = vh * 0.25f
            val innerImageSize = imageSize * 0.85f
            Box(
                modifier = Modifier
                    .size(imageSize)
                    .clip(RoundedCornerShape(16.dp))
                    .background(AlarmColors.White)
                    .border(1.dp, AlarmColors.Clock80.copy(alpha = 0.3f), RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(innerImageSize)
                        .clip(RoundedCornerShape(8.dp))
                        .background(AlarmColors.Clock40),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Shuffle,
                        contentDescription = null,
                        tint = AlarmColors.White.copy(alpha = 0.5f),
                        modifier = Modifier.size(40.dp)
                    )
                }
            }

            // 5vh
            Spacer(modifier = Modifier.height(vh * 0.04f))

            // Steps counter
            Text(
                text = "4",
                color = AlarmColors.White,
                fontSize = 45.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )

            Text(
                text = "pasos restantes",
                color = AlarmColors.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )

            // Flexible space
            Spacer(modifier = Modifier.weight(1f))

            // Progress section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Progreso",
                        color = AlarmColors.White,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "16/20 pasos",
                        color = AlarmColors.White,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Progress bar
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(AlarmColors.White)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(6.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(AlarmColors.Clock100)
                    )
                    // Thumb indicator
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .align(Alignment.CenterStart)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .align(Alignment.CenterEnd)
                                .clip(CircleShape)
                                .background(AlarmColors.Clock100)
                                .border(2.dp, AlarmColors.White, CircleShape)
                        )
                    }
                }
            }

            // 3.5vh
            Spacer(modifier = Modifier.height(vh * 0.035f))

            // Button row
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 34.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(AlarmColors.Clock100)
                        .clickable { onCompleted() },
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Reto completado",
                            color = AlarmColors.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        LoadingIndicator(
                            modifier = Modifier.size(24.dp),
                            color = AlarmColors.White
                        )
                    }
                }
            }

            // 2.5vh
            Spacer(modifier = Modifier.height(vh * 0.025f))

            // Bottom navigation indicator
            Box(
                modifier = Modifier
                    .width(72.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(AlarmColors.Clock80)
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
