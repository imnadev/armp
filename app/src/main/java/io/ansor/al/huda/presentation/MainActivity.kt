package io.ansor.al.huda.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.compose.animation.*
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import dagger.hilt.android.AndroidEntryPoint
import io.ansor.al.huda.presentation.common.*
import io.ansor.al.huda.presentation.destinations.HomeScreenDestination
import io.ansor.al.huda.presentation.ui.theme.AlhudaTheme
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel

        installSplashScreen()

        setContent {
            val engine = rememberNavHostEngine()
            val navController = engine.rememberNavController()

            val state by viewModel.state.collectAsState()

            val startRoute =
                state.onboarding?.let { HomeScreenDestination } ?: NavGraphs.root.startRoute

            val configuration = resources.configuration
            val locale = Locale(state.language.name.lowercase())
            configuration.setLocale(locale)
            createConfigurationContext(configuration)
            resources.updateConfiguration(configuration, resources.displayMetrics)

            AlhudaTheme(darkTheme = state.dark ?: isSystemInDarkTheme()) {
                CustomScaffold(
                    navController = navController,
                    startRoute = startRoute,
                    topBar = { dest ->
                        AnimatedVisibility(
                            visible = dest.shouldShowTopBar,
                            enter = fadeIn() + expandVertically(),
                            exit = shrinkVertically() + fadeOut()
                        ) {
                            CustomAppBar(destination = dest, navController = navController)
                        }
                    },
                    bottomBar = {
                        AnimatedVisibility(
                            visible = it.shouldShowBottomBar,
                            enter = fadeIn() + expandVertically(),
                            exit = shrinkVertically() + fadeOut()
                        ) {
                            CustomBottomBar(navController)
                        }
                    }
                ) {
                    DestinationsNavHost(
                        engine = engine,
                        navController = navController,
                        navGraph = NavGraphs.root,
                        modifier = Modifier.padding(it),
                        startRoute = startRoute
                    )
                }
            }
        }
    }
}