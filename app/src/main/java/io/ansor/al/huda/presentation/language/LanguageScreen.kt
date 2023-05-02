package io.ansor.al.huda.presentation.language

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import io.ansor.al.huda.presentation.language.LanguageViewModel.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import io.ansor.al.huda.R
import io.ansor.al.huda.domain.model.Language
import io.ansor.al.huda.presentation.common.CustomButton
import io.ansor.al.huda.presentation.common.RadioSelectionItem
import io.ansor.al.huda.presentation.destinations.HomeScreenDestination
import io.ansor.al.huda.presentation.language.LanguageViewModel.Input.SetLanguage
import io.ansor.al.huda.presentation.ui.theme.AlhudaTheme

@Preview(showBackground = true)
@Composable
fun LanguageScreenPreview() {
    AlhudaTheme(darkTheme = false) {
        LanguageScreen(
            onboarding = false, navigator = EmptyDestinationsNavigator
        )
    }
}

@RootNavGraph(start = true)
@Destination
@Composable
fun LanguageScreen(
    onboarding: Boolean = true,
    navigator: DestinationsNavigator,
    viewModel: LanguageViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {

        Language.values().forEachIndexed { index, item ->
            RadioSelectionItem(
                modifier = if (index == 0) Modifier.padding(top = 24.dp) else Modifier,
                selectionItemModel = item,
                isSelected = item == state.appLanguage
            ) {
                viewModel.processInput(SetLanguage(item))
            }
        }

        if (onboarding) {
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .defaultMinSize(minHeight = 120.dp)
            )

            CustomButton(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                text = R.string.to_continue,
            ) {
                viewModel.processInput(Input.SetOnboarding(false))
                navigator.navigate(HomeScreenDestination())
            }
        }
    }
}