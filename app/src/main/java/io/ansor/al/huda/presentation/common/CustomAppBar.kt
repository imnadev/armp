package io.ansor.al.huda.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.ansor.al.huda.R
import io.ansor.al.huda.presentation.destinations.*
import io.ansor.al.huda.presentation.ui.theme.*

@Composable
fun CustomAppBar(
    destination: Destination,
    navController: NavController
) {

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(MaterialTheme.colors.layer),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {

                if (navController.previousBackStackEntry != null) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_left),
                            contentDescription = null,
                            tint = MaterialTheme.colors.iconTint
                        )
                    }
                }
            }

            Text(
                text = stringResource(destination.getTitle(navController) ?: R.string.empty),
                modifier = Modifier.weight(3f),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.interExtraBold,
                color = MaterialTheme.colors.titleText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(
                modifier = Modifier
                    .width(1.dp)
                    .weight(1f)
            )
        }

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colors.line
        )
    }

}

private fun Destination.getTitle(navController: NavController): Int? {
    val settings =
        navController.backQueue.any { it.destination.route == SettingsScreenDestination.route }

    return when (this) {
        LanguageScreenDestination -> if (settings) R.string.system_language else R.string.choose_system_language
        AboutScreenDestination -> R.string.about
        else -> null
    }
}

val Destination.shouldShowTopBar: Boolean
    get() = when (this) {
        HomeScreenDestination, SettingsScreenDestination -> false
        else -> true
    }