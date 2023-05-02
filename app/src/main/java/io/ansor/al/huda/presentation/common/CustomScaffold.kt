package io.ansor.al.huda.presentation.common

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.spec.Route
import io.ansor.al.huda.presentation.appCurrentDestinationAsState
import io.ansor.al.huda.presentation.destinations.Destination
import io.ansor.al.huda.presentation.startAppDestination

@SuppressLint("RestrictedApi")
@Composable
fun CustomScaffold(
    startRoute: Route,
    navController: NavHostController,
    topBar: @Composable (Destination) -> Unit,
    bottomBar: @Composable (Destination) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    val destination = navController.appCurrentDestinationAsState().value
        ?: startRoute.startAppDestination

    Scaffold(
        topBar = { topBar(destination) },
        bottomBar = { bottomBar(destination) },
        content = content
    )
}