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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Shapes
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.outlined.FiberManualRecord
import androidx.compose.material.icons.outlined.FlashlightOn
import androidx.compose.material.icons.outlined.Star

@Composable
fun QRScanScreen(
    modifier: Modifier = Modifier,
    onCompleted: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AlarmColors.Clock80)
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleCard()
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .size(320.dp)
                .background(
                    color = androidx.compose.ui.graphics.Color.White,
                    shape = RoundedCornerShape(110.dp)
                )
        )
        Spacer(modifier = Modifier.height(16.dp))
        ScanningCard()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Manten el código dentro del recuadro",
            style = MaterialTheme.typography.bodySmall.copy(color = AlarmColors.White)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LanternButtonCard()
        Spacer(modifier = Modifier.height(16.dp))
        ChallengeCompleteCard(onCompleted = onCompleted)
    }
}

@Composable
fun TitleCard() {
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
            Text(
                text = "Misión de escaneo",
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge.copy(color = AlarmColors.Clock100),
                modifier = Modifier.padding(start = 50.dp, end = 50.dp)
            )
            Text(
                text = "Escanea tu cepillo de dientes",
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall.copy(color = AlarmColors.Clock80),
                modifier = Modifier.padding(start = 40.dp, end = 40.dp)
            )
            Text(
                text = "Busca el objeto donde lo tenías cuando lo registraste",
                style = MaterialTheme.typography.bodyMedium.copy(color = AlarmColors.Clock80)
            )
        }
    }
}

@Composable
fun ScanningCard() {
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
            modifier = Modifier
                .fillMaxSize(),
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

}

@Composable
fun LanternButtonCard() {
    Button(
        onClick = {  },
        modifier = Modifier
            .width(285.dp)
            .height(136.dp),
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
}

@Composable
fun ChallengeCompleteCard(onCompleted: () -> Unit = {}) {
    Card(
        onClick = { onCompleted() },
        modifier = Modifier
            .width(372.dp)
            .height(42.dp),
        colors = CardDefaults.cardColors(
            containerColor = AlarmColors.Clock100
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
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
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "Burst",
                    tint = AlarmColors.White
                )
            }
        }
    }

}
