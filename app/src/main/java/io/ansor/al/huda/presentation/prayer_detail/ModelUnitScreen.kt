package io.ansor.al.huda.presentation.prayer_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import io.ansor.al.huda.presentation.destinations.ArScreenDestination
import io.ansor.al.huda.presentation.prayer_detail.components.ModelUnitItem
import io.ansor.al.huda.presentation.ui.theme.AlhudaTheme

@Preview
@Composable
fun ModelUnitScreenPreview() {
    AlhudaTheme(darkTheme = false) {
        ModelUnitScreen(modelGroup = ModelGroup.CARS, navigator = EmptyDestinationsNavigator)
    }
}

@Destination
@Composable
fun ModelUnitScreen(
    modelGroup: ModelGroup,
    navigator: DestinationsNavigator,
) {

    val scrollState = rememberScrollState()
    
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        modelGroup.units.forEachIndexed { index, unit ->
            ModelUnitItem(
                unit = unit,
                modifier = if (index == 0) Modifier.padding(top = 24.dp) else Modifier
            ) {
                navigator.navigate(ArScreenDestination(unit))
            }
        }
    }
}