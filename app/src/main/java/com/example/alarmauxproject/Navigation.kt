package com.example.alarmauxproject

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object Routes {
    const val ALARM_UNLOCK = "alarm_unlock"
    const val MIS_ALARMAS = "mis_alarmas"
    const val DETALLE_ALARMA = "detalle_alarma"
    const val RETO_CAMINAR = "reto_caminar"
    const val RETO_MATEMATICO = "reto_matematico"
    const val TAREA_COMPLETADA_CAMINAR = "tarea_completada_caminar"
    const val TAREA_COMPLETADA_MATES = "tarea_completada_mates"
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Routes.ALARM_UNLOCK
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Routes.ALARM_UNLOCK) {
            AlarmScreen(
                modifier = Modifier,
                onUnlock = {
                    navController.navigate(Routes.RETO_CAMINAR) {
                        popUpTo(Routes.ALARM_UNLOCK) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.RETO_CAMINAR) {
            RetoCaminarScreen(
                onCompleted = {
                    navController.navigate(Routes.TAREA_COMPLETADA_CAMINAR) {
                        popUpTo(Routes.RETO_CAMINAR) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.TAREA_COMPLETADA_CAMINAR) {
            TareaCompletadaScreen(
                onSiguienteReto = {
                    navController.navigate(Routes.RETO_MATEMATICO) {
                        popUpTo(Routes.TAREA_COMPLETADA_CAMINAR) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.RETO_MATEMATICO) {
            RetoMatematicoScreen(
                onCompleted = {
                    navController.navigate(Routes.TAREA_COMPLETADA_MATES) {
                        popUpTo(Routes.RETO_MATEMATICO) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.TAREA_COMPLETADA_MATES) {
            TareaCompletadaScreen(
                onSiguienteReto = {
                    navController.navigate(Routes.MIS_ALARMAS) {
                        popUpTo(Routes.TAREA_COMPLETADA_MATES) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.MIS_ALARMAS) {
            MisAlarmasScreen(
                onAlarmClick = {
                    navController.navigate(Routes.DETALLE_ALARMA)
                }
            )
        }
        composable(Routes.DETALLE_ALARMA) {
            DetalleAlarmaScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
