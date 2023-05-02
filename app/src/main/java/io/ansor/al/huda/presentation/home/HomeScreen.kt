package io.ansor.al.huda.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import io.ansor.al.huda.domain.model.ModelGroup
import io.ansor.al.huda.presentation.destinations.ModelUnitScreenDestination
import io.ansor.al.huda.presentation.home.components.SectionItem
import io.ansor.al.huda.presentation.ui.theme.AlhudaTheme

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AlhudaTheme(darkTheme = true) {
        HomeScreen(EmptyDestinationsNavigator)
    }
}

@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        ModelGroup.values().forEach { item ->
            SectionItem(menu = item) {
                navigator.navigate(ModelUnitScreenDestination(item))
            }
        }
    }
}