package com.example.alarmauxproject

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DoubleArrow
import androidx.compose.material.icons.filled.MoreTime
import androidx.compose.material.icons.filled.WbTwilight
import androidx.compose.material.icons.outlined.FormatQuote
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.material.icons.outlined.WorkspacePremium
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GodJobScreen(modifier: Modifier = Modifier, onComenzarDia: () -> Unit = {}) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(AlarmColors.Clock80)
    ) {
        val vh = maxHeight
        // Scale factor: 1.0 on 800dp+ screens, shrinks proportionally on smaller
        val ts = (maxHeight.value / 800f).coerceIn(0.65f, 1f)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(vh * 0.03f))

            Text(
                text = "!Bien hecho!",
                color = AlarmColors.White,
                fontSize = (28 * ts).sp,
                modifier = Modifier.padding(bottom = vh * 0.015f)
            )
            Text(
                text = "Despertaste en el segundo intento",
                color = AlarmColors.Clock20,
                fontSize = (16 * ts).sp,
                modifier = Modifier.padding(bottom = vh * 0.02f)
            )

            // Strike card
            StrikeCard(cardHeight = vh * 0.18f, ts = ts)

            Spacer(modifier = Modifier.height(vh * 0.012f))

            // Day info card
            DayInfoCard(cardHeight = vh * 0.2f, infoCardHeight = vh * 0.09f, ts = ts)

            Spacer(modifier = Modifier.height(vh * 0.012f))

            // Daily message card
            DailyMessageCard(cardHeight = vh * 0.17f, ts = ts)

            Spacer(modifier = Modifier.weight(1f))

            // Comenzar día button
            Button(
                onClick = { onComenzarDia() },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(vh * 0.09f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AlarmColors.Clock40
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
                shape = Shapes().extraLarge
            ) {
                Text(
                    text = "Comenzar día",
                    color = AlarmColors.Clock100,
                    fontSize = (20 * ts).sp
                )
                Icon(
                    imageVector = Icons.Filled.DoubleArrow,
                    contentDescription = "Row",
                    tint = AlarmColors.Clock100,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(vh * 0.02f))
        }
    }
}

@Composable
fun StrikeCard(cardHeight: Dp = 200.dp, ts: Float = 1f) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight),
        colors = CardDefaults.cardColors(
            containerColor = AlarmColors.Clock20
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(36.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = AlarmColors.Clock40
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.WorkspacePremium,
                                contentDescription = "Racha",
                                tint = AlarmColors.Clock100
                            )
                            Text(
                                text = "Racha actual 13 días",
                                color = AlarmColors.Clock100,
                                fontSize = (18 * ts).sp,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
            }
            LinearProgressIndicator(
                progress = { 0.80f },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(vertical = 8.dp)
                    .height(7.dp),
                color = AlarmColors.Clock80,
                trackColor = AlarmColors.White,
                strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
            )
            Text(
                text = "¡Sigue así!",
                color = AlarmColors.Clock100,
                fontSize = (20 * ts).sp
            )
        }
    }
}

@Composable
fun DayInfoCard(cardHeight: Dp = 200.dp, infoCardHeight: Dp = 100.dp, ts: Float = 1f) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight),
        colors = CardDefaults.cardColors(
            containerColor = AlarmColors.Clock20
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 6.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(36.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = AlarmColors.Clock40
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.WbTwilight,
                                contentDescription = "Mañana",
                                tint = AlarmColors.Clock100
                            )
                            Text(
                                text = "Tu mañana",
                                color = AlarmColors.Clock100,
                                fontSize = (18 * ts).sp,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(infoCardHeight),
                    colors = CardDefaults.cardColors(
                        containerColor = AlarmColors.Clock40
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text(
                                text = "CLIMA",
                                color = AlarmColors.Clock100,
                                fontSize = (18 * ts).sp
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "22° Soleado",
                                    color = AlarmColors.Clock80,
                                    fontSize = (14 * ts).sp,
                                    modifier = Modifier.padding(end = 8.dp)
                                )
                                Icon(
                                    imageVector = Icons.Outlined.WbSunny,
                                    contentDescription = "Sol",
                                    tint = AlarmColors.Clock100
                                )
                            }
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(infoCardHeight),
                    colors = CardDefaults.cardColors(
                        containerColor = AlarmColors.Clock40
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text(
                                text = "SUEÑO",
                                color = AlarmColors.Clock100,
                                fontSize = (18 * ts).sp
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "7.5 h",
                                    color = AlarmColors.Clock80,
                                    fontSize = (14 * ts).sp,
                                    modifier = Modifier.padding(end = 8.dp)
                                )
                                Icon(
                                    imageVector = Icons.Filled.MoreTime,
                                    contentDescription = "clock",
                                    tint = AlarmColors.Clock100
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DailyMessageCard(cardHeight: Dp = 120.dp, ts: Float = 1f) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight),
        colors = CardDefaults.cardColors(
            containerColor = AlarmColors.Clock20
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.FormatQuote,
                contentDescription = "Quote",
                tint = AlarmColors.Clock100
            )
            Text(
                text = "Mensaje del día",
                color = AlarmColors.Clock100,
                fontSize = (18 * ts).sp
            )
            Text(
                text = "La mejor manera de predecir el futuro es crearlo",
                color = AlarmColors.Clock80,
                fontSize = (13 * ts).sp
            )
        }
    }
}
