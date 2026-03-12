package com.example.alarmauxproject

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object Routes {
    const val MIS_ALARMAS = "mis_alarmas"
    const val DETALLE_ALARMA = "detalle_alarma"
    const val ALARM_UNLOCK = "alarm_unlock"
    const val RETO_CAMINAR = "reto_caminar"
    const val TAREA_COMPLETADA_1 = "tarea_completada_1"
    const val RETO_MATEMATICO = "reto_matematico"
    const val TAREA_COMPLETADA_2 = "tarea_completada_2"
    const val QR_SCAN = "qr_scan"
    const val TAREA_COMPLETADA_3 = "tarea_completada_3"
    const val GOD_JOB = "god_job"
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Routes.MIS_ALARMAS
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        // 1. Mis Alarmas (pantalla inicial)
        composable(Routes.MIS_ALARMAS) {
            MisAlarmasScreen(
                onAlarmClick = {
                    navController.navigate(Routes.DETALLE_ALARMA)
                }
            )
        }

        // 2. Detalle Alarma
        composable(Routes.DETALLE_ALARMA) {
            DetalleAlarmaScreen(
                onBack = { navController.popBackStack() },
                onProbarAlarma = {
                    navController.navigate(Routes.ALARM_UNLOCK)
                }
            )
        }

        // 3. Alarm Unlock (deslizar para desbloquear)
        composable(Routes.ALARM_UNLOCK) {
            AlarmScreen(
                onUnlock = {
                    navController.navigate(Routes.RETO_CAMINAR) {
                        popUpTo(Routes.ALARM_UNLOCK) { inclusive = true }
                    }
                }
            )
        }

        // 4. Reto Caminar
        composable(Routes.RETO_CAMINAR) {
            RetoCaminarScreen(
                onCompleted = {
                    navController.navigate(Routes.TAREA_COMPLETADA_1) {
                        popUpTo(Routes.RETO_CAMINAR) { inclusive = true }
                    }
                }
            )
        }

        // 5. Tarea Completada (despues de caminar)
        composable(Routes.TAREA_COMPLETADA_1) {
            TareaCompletadaScreen(
                onSiguienteReto = {
                    navController.navigate(Routes.RETO_MATEMATICO) {
                        popUpTo(Routes.TAREA_COMPLETADA_1) { inclusive = true }
                    }
                }
            )
        }

        // 6. Reto Matematico
        composable(Routes.RETO_MATEMATICO) {
            RetoMatematicoScreen(
                onCompleted = {
                    navController.navigate(Routes.TAREA_COMPLETADA_2) {
                        popUpTo(Routes.RETO_MATEMATICO) { inclusive = true }
                    }
                }
            )
        }

        // 7. Tarea Completada (despues de mates)
        composable(Routes.TAREA_COMPLETADA_2) {
            TareaCompletadaScreen(
                onSiguienteReto = {
                    navController.navigate(Routes.QR_SCAN) {
                        popUpTo(Routes.TAREA_COMPLETADA_2) { inclusive = true }
                    }
                }
            )
        }

        // 8. QR Scan (Reto Escaneo)
        composable(Routes.QR_SCAN) {
            QRScanScreen(
                onCompleted = {
                    navController.navigate(Routes.TAREA_COMPLETADA_3) {
                        popUpTo(Routes.QR_SCAN) { inclusive = true }
                    }
                }
            )
        }

        // 9. Tarea Completada (despues de escaneo)
        composable(Routes.TAREA_COMPLETADA_3) {
            TareaCompletadaScreen(
                onSiguienteReto = {
                    navController.navigate(Routes.GOD_JOB) {
                        popUpTo(Routes.MIS_ALARMAS) { inclusive = false }
                    }
                }
            )
        }

        // 10. God Job (pantalla final)
        composable(Routes.GOD_JOB) {
            GodJobScreen()
        }
    }
}
