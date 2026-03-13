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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FiberManualRecord
import androidx.compose.material.icons.outlined.FlashlightOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun QRScanScreen(
    modifier: Modifier = Modifier,
    onCompleted: () -> Unit = {}
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(AlarmColors.Clock80)
    ) {
        val vh = maxHeight
        val vw = maxWidth
        val ts = (maxHeight.value / 800f).coerceIn(0.65f, 1f)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(vh * 0.03f))

            // Title card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(vh * 0.22f),
                colors = CardDefaults.cardColors(
                    containerColor = AlarmColors.Clock20
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Misión de escaneo",
                        textAlign = TextAlign.Center,
                        color = AlarmColors.Clock100,
                        fontSize = (28 * ts).sp,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    Text(
                        text = "Escanea tu cepillo de dientes",
                        textAlign = TextAlign.Center,
                        color = AlarmColors.Clock80,
                        fontSize = (20 * ts).sp,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    Text(
                        text = "Busca el objeto donde lo tenías cuando lo registraste",
                        textAlign = TextAlign.Center,
                        color = AlarmColors.Clock80,
                        fontSize = (13 * ts).sp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(vh * 0.015f))

            // White scan area
            Box(
                modifier = Modifier
                    .size(vh * 0.3f)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(vh * 0.1f)
                    )
            )

            Spacer(modifier = Modifier.height(vh * 0.015f))

            // Scanning indicator
            Card(
                modifier = Modifier
                    .width(170.dp)
                    .height(28.dp),
                colors = CardDefaults.cardColors(
                    containerColor = AlarmColors.Clock20
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
                            imageVector = Icons.Outlined.FiberManualRecord,
                            contentDescription = "scanning",
                            tint = AlarmColors.Clock100
                        )
                        Text(
                            text = "Escaneando",
                            style = MaterialTheme.typography.bodyMedium.copy(color = AlarmColors.Clock100),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(vh * 0.01f))

            Text(
                text = "Manten el código dentro del recuadro",
                style = MaterialTheme.typography.bodySmall.copy(color = AlarmColors.White)
            )

            Spacer(modifier = Modifier.weight(1f))

            // Lantern button
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(vh * 0.13f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AlarmColors.Clock40
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
                shape = Shapes().extraLarge
            ) {
                Icon(
                    imageVector = Icons.Outlined.FlashlightOn,
                    contentDescription = "Lintern",
                    tint = AlarmColors.Clock100,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "Linterna",
                    style = MaterialTheme.typography.headlineSmall.copy(color = AlarmColors.Clock100)
                )
            }

            Spacer(modifier = Modifier.height(vh * 0.015f))

            // Challenge complete card
            Card(
                onClick = { onCompleted() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp),
                colors = CardDefaults.cardColors(
                    containerColor = AlarmColors.Clock100
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
                        Text(
                            text = "Reto completado",
                            style = MaterialTheme.typography.bodyLarge.copy(color = AlarmColors.White),
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        LoadingIndicator(
                            modifier = Modifier.size(24.dp),
                            color = AlarmColors.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(vh * 0.01f))
        }
    }
}
