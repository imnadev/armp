package io.ansor.al.huda.presentation.settings.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.ansor.al.huda.domain.model.SettingsMenu
import io.ansor.al.huda.presentation.ui.theme.interSemiBold
import io.ansor.al.huda.presentation.ui.theme.layer
import io.ansor.al.huda.presentation.ui.theme.titleText


@Composable
fun SettingsItem(
    modifier: Modifier = Modifier,
    settingsMenu: SettingsMenu,
    onClick: () -> Unit,
    trailing: @Composable () -> Unit,
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp, start = 24.dp, end = 24.dp)
            .clip(MaterialTheme.shapes.large)
            .clickable { onClick() },
        shape = MaterialTheme.shapes.large,
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.layer
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                modifier = Modifier.size(36.dp),
                painter = painterResource(id = settingsMenu.icon),
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = stringResource(settingsMenu.title),
                style = MaterialTheme.typography.interSemiBold,
                color = MaterialTheme.colors.titleText
            )

            Spacer(modifier = Modifier.weight(1f))

            trailing()
        }
    }

}