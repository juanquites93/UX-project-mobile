package com.example.alarmauxproject

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Vibration
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetalleAlarmaScreen(
    onBack: () -> Unit = {},
    onProbarAlarma: () -> Unit = {}
) {
    var alarmEnabled by remember { mutableStateOf(true) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AlarmColors.Clock60)
            .verticalScroll(scrollState)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 28.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back button
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(AlarmColors.Clock100.copy(alpha = 0.2f))
                    .clickable { onBack() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Volver",
                    tint = AlarmColors.White,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Detalle de alarma",
                color = AlarmColors.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal
            )
        }

        // Probar alarma button
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(AlarmColors.White)
                .clickable { onProbarAlarma() }
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Probar alarma",
                color = AlarmColors.Clock60,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = "Play",
                tint = AlarmColors.Clock80,
                modifier = Modifier.size(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Main alarm info card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(AlarmColors.Clock20)
                .padding(24.dp)
        ) {
            // Time + toggle
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = "06:30",
                        color = AlarmColors.Clock100,
                        fontSize = 45.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "AM",
                        color = AlarmColors.Clock80,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 4.dp, bottom = 10.dp)
                    )
                }
                CustomAlarmToggle(
                    checked = alarmEnabled,
                    onCheckedChange = { alarmEnabled = it }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Tags
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                TagChip(icon = Icons.Filled.Work, text = "Lun - Vie")
                TagChip(icon = Icons.Filled.GraphicEq, text = "Perfil: Solo")
            }

            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider(
                color = AlarmColors.White.copy(alpha = 0.3f),
                thickness = 1.dp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Work + time until
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Work,
                        contentDescription = null,
                        tint = AlarmColors.Clock80,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Trabajo",
                        color = AlarmColors.Clock80,
                        fontSize = 14.sp
                    )
                }
                Text(
                    text = "Suena en 8h 25 min",
                    color = AlarmColors.Clock100,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tipo de despertar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 28.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Tipo de despertar",
                color = AlarmColors.White,
                fontSize = 14.sp
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(AlarmColors.White)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Gradual",
                    color = AlarmColors.Clock60,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Settings card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(AlarmColors.Clock20)
                .padding(16.dp)
        ) {
            SettingRow(icon = Icons.Filled.MusicNote, label = "Sonido", value = "Amanecer Suave")
            SettingDivider()
            SettingRow(icon = Icons.AutoMirrored.Filled.VolumeUp, label = "Volumen", value = "Progresivo 0→70%")
            SettingDivider()
            SettingRow(icon = Icons.Filled.Vibration, label = "Vibración", value = "Activada")
            SettingDivider()
            SettingRow(icon = Icons.Filled.DarkMode, label = "Luz", value = "Luz tenue activada")
            Spacer(modifier = Modifier.height(16.dp))
            SettingRow(icon = Icons.Filled.Pause, label = "Snooze", value = "2 máximo · 5 min c/u")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Retos activados
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(AlarmColors.Clock20)
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(AlarmColors.White),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.GraphicEq,
                        contentDescription = null,
                        tint = AlarmColors.Clock60,
                        modifier = Modifier.size(16.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "Retos activados",
                        color = AlarmColors.Clock100,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "Para apagar la alarma",
                        color = AlarmColors.Clock80,
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Challenge pills
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ChallengePill(icon = Icons.Filled.Calculate, label = "Mates")
                ChallengePill(icon = Icons.Filled.CameraAlt, label = "Escaneo")
                ChallengePill(icon = Icons.AutoMirrored.Filled.DirectionsWalk, label = "Caminar")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Footer text
        Text(
            text = "Para editar esta alarma, accede desde la\nplataforma web",
            color = AlarmColors.White,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun TagChip(
    icon: ImageVector,
    text: String
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(AlarmColors.White)
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = AlarmColors.Clock60,
            modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = AlarmColors.Clock80,
            fontSize = 14.sp
        )
    }
}

@Composable
fun SettingRow(
    icon: ImageVector,
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(AlarmColors.White),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = AlarmColors.Clock60,
                    modifier = Modifier.size(16.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = label,
                color = AlarmColors.Clock100,
                fontSize = 14.sp
            )
        }
        Text(
            text = value,
            color = AlarmColors.Clock80,
            fontSize = 14.sp
        )
    }
}

@Composable
fun SettingDivider() {
    HorizontalDivider(
        color = AlarmColors.White.copy(alpha = 0.2f),
        thickness = 1.dp
    )
}

@Composable
fun ChallengePill(
    icon: ImageVector,
    label: String
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(32.dp))
            .background(AlarmColors.Clock60)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(AlarmColors.White),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = AlarmColors.Clock60,
                modifier = Modifier.size(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            color = AlarmColors.White,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}
