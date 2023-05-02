package io.ansor.al.huda.presentation.settings

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import io.ansor.al.huda.R
import io.ansor.al.huda.domain.model.SettingsMenu
import io.ansor.al.huda.presentation.common.CustomSwitch
import io.ansor.al.huda.presentation.destinations.AboutScreenDestination
import io.ansor.al.huda.presentation.destinations.LanguageScreenDestination
import io.ansor.al.huda.presentation.settings.SettingsViewModel.Input
import io.ansor.al.huda.presentation.settings.components.SettingsItem
import io.ansor.al.huda.presentation.ui.theme.AlhudaTheme
import io.ansor.al.huda.presentation.ui.theme.gilroyMedium
import io.ansor.al.huda.presentation.ui.theme.grayX11

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    AlhudaTheme(darkTheme = true) {
        SettingsScreen(navigator = EmptyDestinationsNavigator)
    }
}

@Destination
@Composable
fun SettingsScreen(
    navigator: DestinationsNavigator, viewModel: SettingsViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        SettingsItem(settingsMenu = SettingsMenu.APP_LANGUAGE, onClick = {
            navigator.navigate(
                LanguageScreenDestination(
                    onboarding = false
                )
            )
        }) {
            Text(
                text = stringResource(state.appLanguage.title),
                style = MaterialTheme.typography.gilroyMedium,
                fontSize = 13.sp,
                color = MaterialTheme.colors.grayX11
            )
        }

        SettingsItem(settingsMenu = SettingsMenu.ABOUT, onClick = {
            navigator.navigate(AboutScreenDestination())
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_row_forward),
                tint = MaterialTheme.colors.grayX11,
                contentDescription = null,
            )
        }

        SettingsItem(settingsMenu = SettingsMenu.DARK_THEME, onClick = {}) {
            CustomSwitch(
                enabled = state.darkTheme ?: isSystemInDarkTheme()
            ) {
                viewModel.processInput(Input.SetTheme(it))
            }
        }
    }
}