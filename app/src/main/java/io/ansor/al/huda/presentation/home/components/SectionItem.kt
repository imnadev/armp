package io.ansor.al.huda.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ansor.al.huda.R
import io.ansor.al.huda.domain.model.ModelGroup
import io.ansor.al.huda.presentation.ui.theme.*

@Composable
fun SectionItem(
    menu: ModelGroup, onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp, start = 24.dp, end = 24.dp)
            .clip(MaterialTheme.shapes.large)
            .clickable { onClick() },
        shape = MaterialTheme.shapes.large,
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.layer,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(
                    text = stringResource(menu.title),
                    style = MaterialTheme.typography.gilroySemiBold,
                    color = MaterialTheme.colors.titleText,
                    fontSize = 20.sp
                )
                Text(
                    text = stringResource(R.string.count, menu.units.count()),
                    style = MaterialTheme.typography.gilroyRegular,
                    color = MaterialTheme.colors.subtitleTextSection
                )
            }
            Icon(
                modifier = Modifier.padding(8.dp),
                painter = painterResource(id = menu.icon),
                tint = MaterialTheme.colors.subtitleTextSection,
                contentDescription = null
            )
        }
    }
}