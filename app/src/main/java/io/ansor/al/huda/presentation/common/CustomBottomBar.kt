package io.ansor.al.huda.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popBackStack
import com.ramcosta.composedestinations.navigation.popUpTo
import com.ramcosta.composedestinations.utils.isRouteOnBackStack
import io.ansor.al.huda.domain.model.BottomItem
import io.ansor.al.huda.presentation.NavGraphs
import io.ansor.al.huda.presentation.destinations.Destination
import io.ansor.al.huda.presentation.destinations.HomeScreenDestination
import io.ansor.al.huda.presentation.destinations.SettingsScreenDestination
import io.ansor.al.huda.presentation.ui.theme.bottomIconUnselected
import io.ansor.al.huda.presentation.ui.theme.bottomItemSelectedBackground
import io.ansor.al.huda.presentation.ui.theme.layer
import io.ansor.al.huda.presentation.ui.theme.line

@Composable
fun CustomBottomBar(
    navController: NavController
) {
    Column {

        Divider(
            modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colors.line
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.layer),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BottomItem.values().forEach { destination ->
                val isCurrentDestOnBackStack =
                    navController.isRouteOnBackStack(destination.direction)
                NavItem(
                    item = destination,
                    isSelected = isCurrentDestOnBackStack,
                ) {

                    if (isCurrentDestOnBackStack) {
                        navController.popBackStack(destination.direction, false)
                        return@NavItem
                    }

                    navController.navigate(destination.direction) {
                        popUpTo(NavGraphs.root) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        }
    }
}

@Composable
fun NavItem(
    item: BottomItem, isSelected: Boolean, onSelect: () -> Unit
) {

    val backgroundColor =
        if (isSelected) MaterialTheme.colors.bottomItemSelectedBackground else Color.Transparent
    val iconColor = if (isSelected) Color.White else MaterialTheme.colors.bottomIconUnselected

    IconButton(
        modifier = Modifier
            .padding(12.dp)
            .background(
                color = backgroundColor, shape = CircleShape
            ),
        onClick = { if (isSelected.not()) onSelect() },
    ) {
        Icon(
            modifier = Modifier.padding(16.dp),
            painter = painterResource(id = item.icon),
            contentDescription = stringResource(id = item.title),
            tint = iconColor
        )
    }
}

val Destination.shouldShowBottomBar: Boolean
    get() = when (this) {
        HomeScreenDestination, SettingsScreenDestination -> true
        else -> false
    }