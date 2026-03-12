package com.example.alarmauxproject

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.material.icons.filled.BatteryFull
import androidx.compose.material.icons.filled.Backup
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.automirrored.filled.VolumeUp
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class AlarmData(
    val time: String,
    val amPm: String,
    val days: String,
    val profile: String,
    val timeUntil: String,
    val initialEnabled: Boolean = true
)

@Composable
fun MisAlarmasScreen(
    onAlarmClick: () -> Unit = {}
) {
    var isDeviceStatusExpanded by remember { mutableStateOf(true) }
    val scrollState = rememberScrollState()

    val alarms = if (isDeviceStatusExpanded) {
        listOf(
            AlarmData("06:30", "AM", "Lun - Vie", "Perfil: Solo", "Suena en 8h 25 min", true),
            AlarmData("07:00", "AM", "Sábado", "Perfil: Pareja", "Suena en 2d 9h", true),
            AlarmData("07:00", "AM", "Sábado", "Perfil: Pareja", "Suena en 2d 9h", true)
        )
    } else {
        listOf(
            AlarmData("06:30", "AM", "Lun - Vie", "Perfil: Solo", "Suena en 8h 25 min", true),
            AlarmData("07:00", "AM", "Sabado", "Perfil: Pareja", "Suena en 2d 9h", true),
            AlarmData("07:50", "AM", "Sabado", "Perfil: Pareja", "Suena en 2d 9h", true),
            AlarmData("08:00", "AM", "Sabado", "Perfil: Pareja", "Suena en 2d 9h", false),
            AlarmData("08:30", "AM", "Sabado", "Perfil: Pareja", "Suena en 2d 9h", false)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AlarmColors.Clock60)
            .verticalScroll(scrollState)
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // Title
        Text(
            text = "Mis alarmas",
            color = AlarmColors.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Device Status Dropdown
        DeviceStatusSection(
            isExpanded = isDeviceStatusExpanded,
            onToggle = { isDeviceStatusExpanded = !isDeviceStatusExpanded }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Alarm Cards
        alarms.forEach { alarm ->
            AlarmCard(
                alarm = alarm,
                onClick = onAlarmClick
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.height(40.dp))

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

@Composable
fun DeviceStatusSection(
    isExpanded: Boolean,
    onToggle: () -> Unit
) {
    val iconRotation by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
        animationSpec = tween(300),
        label = "dropdownRotation"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(AlarmColors.Clock20)
            .animateContentSize(animationSpec = tween(300))
            .padding(20.dp)
    ) {
        // Header row (always visible)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onToggle() },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "El Estado de tu celular",
                color = AlarmColors.Clock100,
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal
            )
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "Toggle",
                tint = AlarmColors.Clock100,
                modifier = Modifier
                    .size(24.dp)
                    .rotate(iconRotation)
            )
        }

        if (isExpanded) {
            Spacer(modifier = Modifier.height(16.dp))

            // Status grid - 2x2
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                StatusCard(
                    value = "85%",
                    label = "Batería",
                    icon = { Icon(Icons.Filled.BatteryFull, contentDescription = null, tint = AlarmColors.Clock80, modifier = Modifier.size(12.dp)) },
                    modifier = Modifier.weight(1f)
                )
                StatusCard(
                    value = "Alto",
                    label = "Volumen",
                    icon = { Icon(Icons.AutoMirrored.Filled.VolumeUp, contentDescription = null, tint = AlarmColors.Clock80, modifier = Modifier.size(12.dp)) },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                StatusCard(
                    value = "Activo",
                    label = "Respaldo",
                    icon = { Icon(Icons.Filled.Backup, contentDescription = null, tint = AlarmColors.Clock80, modifier = Modifier.size(14.dp)) },
                    modifier = Modifier.weight(1f)
                )
                StatusCard(
                    value = "Ok",
                    label = "Permisos",
                    icon = { Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = AlarmColors.Clock60, modifier = Modifier.size(12.dp)) },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Active alarms row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(AlarmColors.White)
                    .padding(horizontal = 12.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Alarmas activas",
                    color = AlarmColors.Clock100,
                    fontSize = 14.sp
                )
                Text(
                    text = "3 activas",
                    color = AlarmColors.Clock100,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Last sync
            Text(
                text = "Última sincronización: 5 min.",
                color = AlarmColors.Clock100,
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

@Composable
fun StatusCard(
    value: String,
    label: String,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(AlarmColors.White)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            color = AlarmColors.Clock100,
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            icon()
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = label,
                color = AlarmColors.Clock80,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun AlarmCard(
    alarm: AlarmData,
    onClick: () -> Unit = {}
) {
    var isEnabled by remember { mutableStateOf(alarm.initialEnabled) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(AlarmColors.White)
            .clickable { onClick() }
    ) {
        // Left accent bar
        Box(
            modifier = Modifier
                .width(6.dp)
                .height(142.dp)
                .align(Alignment.CenterStart)
                .padding(start = 1.dp)
                .background(AlarmColors.Clock100)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier.weight(1f).padding(start = 16.dp)
            ) {
                // Time row
                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = alarm.time,
                        color = AlarmColors.Clock100,
                        fontSize = 45.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 48.sp
                    )
                    Text(
                        text = alarm.amPm,
                        color = AlarmColors.Clock80,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 4.dp, bottom = 6.dp)
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                // Days and profile
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = alarm.days,
                        color = AlarmColors.Clock100,
                        fontSize = 14.sp
                    )
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(4.dp)
                            .clip(CircleShape)
                            .background(AlarmColors.Clock80.copy(alpha = 0.4f))
                    )
                    Text(
                        text = alarm.profile,
                        color = AlarmColors.Clock60,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                // Time until
                Text(
                    text = alarm.timeUntil,
                    color = AlarmColors.Clock60,
                    fontSize = 14.sp
                )
            }

            // Toggle switch
            CustomAlarmToggle(
                checked = isEnabled,
                onCheckedChange = { isEnabled = it }
            )
        }
    }
}

@Composable
fun CustomAlarmToggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedThumbColor = AlarmColors.White,
            checkedTrackColor = AlarmColors.Clock60,
            checkedBorderColor = AlarmColors.Clock60,
            uncheckedThumbColor = AlarmColors.Clock80,
            uncheckedTrackColor = AlarmColors.Clock60.copy(alpha = 0.3f),
            uncheckedBorderColor = AlarmColors.Clock60.copy(alpha = 0.3f)
        )
    )
}
