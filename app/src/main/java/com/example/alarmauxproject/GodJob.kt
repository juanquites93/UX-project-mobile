package com.example.alarmauxproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.MoreTime
import androidx.compose.material.icons.filled.WbTwilight
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.filled.DoubleArrow
import androidx.compose.material.icons.outlined.FormatQuote
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.material.icons.outlined.WorkspacePremium

@Composable
fun GodJobScreen(modifier: Modifier = Modifier, onComenzarDia: () -> Unit = {}) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AlarmColors.Clock80)
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "!Bien hecho!",
            style = MaterialTheme.typography.headlineMedium.copy(color = AlarmColors.White),
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Text(
            text = "Despertaste en el segundo intento",
            style = MaterialTheme.typography.bodyLarge.copy(color = AlarmColors.Clock20),
            modifier = Modifier.padding(bottom = 32.dp)
        )
        StrikeCard()
        Spacer(modifier = Modifier.height(16.dp))
        DayInfoCard()
        Spacer(modifier = Modifier.height(16.dp))
        DailyMessageCard()
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { onComenzarDia() },
            modifier = Modifier
                .width(280.dp)
                .height(96.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = AlarmColors.Clock40
            ),
            elevation = androidx.compose.material3.ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
            shape = androidx.compose.material3.Shapes().extraLarge
        ) {
            Text(
                text = "Comenzar día",
                style = MaterialTheme.typography.headlineSmall.copy(color = AlarmColors.Clock100)
            )
            Icon(
                imageVector = Icons.Filled.DoubleArrow,
                contentDescription = "Row",
                tint = AlarmColors.Clock100,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun StrikeCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
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
                    .padding(top = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .width(289.dp)
                        .height(36.dp)
                        .align(Alignment.CenterVertically),
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
                                style = MaterialTheme.typography.headlineSmall.copy(color = AlarmColors.Clock100),
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
                    .padding(vertical = 16.dp)
                    .height(7.dp),
                color = AlarmColors.Clock80,
                trackColor = AlarmColors.White,
                strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
            )
            Text(
                text = "¡Sigue así!",
                style = MaterialTheme.typography.headlineSmall.copy(color = AlarmColors.Clock100)
            )
        }
    }


}

@Composable
fun DayInfoCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
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
                    .padding(top = 24.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .width(289.dp)
                        .height(36.dp)
                        .align(Alignment.CenterVertically),
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
                                style = MaterialTheme.typography.headlineSmall.copy(color = AlarmColors.Clock100),
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 24.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .width(140.dp)
                        .height(100.dp)
                        .align(Alignment.CenterVertically),
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
                                style = MaterialTheme.typography.headlineSmall.copy(color = AlarmColors.Clock100)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "22° Soleado",
                                    style = MaterialTheme.typography.bodyLarge.copy(color = AlarmColors.Clock80),
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
                Spacer(modifier = Modifier.width(16.dp))
                Card(
                    modifier = Modifier
                        .width(140.dp)
                        .height(100.dp)
                        .align(Alignment.CenterVertically),
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
                                style = MaterialTheme.typography.headlineSmall.copy(color = AlarmColors.Clock100)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "7.5 h",
                                    style = MaterialTheme.typography.bodyLarge.copy(color = AlarmColors.Clock80),
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
fun DailyMessageCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = AlarmColors.Clock20
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.FormatQuote,
                contentDescription = "Quote",
                tint = AlarmColors.Clock100
            )
            Text(
                text = "Mensaje del día",
                style = MaterialTheme.typography.headlineSmall.copy(color = AlarmColors.Clock100),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "La mejor manera de predecir el futuro es crearlo",
                style = MaterialTheme.typography.bodyMedium.copy(color = AlarmColors.Clock80),
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}