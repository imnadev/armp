package io.ansor.al.huda.presentation.prayer_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ansor.al.huda.R
import io.ansor.al.huda.domain.model.ModelGroup
import io.ansor.al.huda.domain.model.ModelUnit
import io.ansor.al.huda.presentation.ui.theme.*

@Preview(showBackground = true)
@Composable
fun ModelUnitItemPreview() {
    AlhudaTheme(darkTheme = true) {
        ModelUnitItem(unit = ModelGroup.CARS.units.first()) {

        }
    }
}

@Composable
fun ModelUnitItem(
    modifier: Modifier = Modifier,
    unit: ModelUnit,
    onPlay: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
            .clip(MaterialTheme.shapes.large)
            .clickable { onPlay() },
        shape = MaterialTheme.shapes.large,
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.layer,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_splash_image),
                contentDescription = null,
                tint = MaterialTheme.colors.subtitleTextSection
            )
            Column(
                modifier = Modifier.padding(start = 12.dp),
                verticalArrangement = Arrangement.SpaceAround,
            ) {
                Text(
                    text = unit.title,
                    style = MaterialTheme.typography.gilroySemiBold,
                    fontSize = 15.sp,
                    color = MaterialTheme.colors.titleText,
                )
                if (unit.subtitle != null) {
                    Text(
                        text = unit.subtitle,
                        style = MaterialTheme.typography.gilroyMedium,
                        color = MaterialTheme.colors.grayX11,
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                modifier = Modifier
                    .background(
                        shape = CircleShape,
                        color = MaterialTheme.colors.playBackground
                    )
                    .size(36.dp),
                onClick = onPlay,
            ) {
                Icon(
                    modifier = Modifier.padding(start = 1.dp, bottom = 1.dp),
                    painter = painterResource(R.drawable.ic_play),
                    contentDescription = null,
                    tint = MaterialTheme.colors.buttonBackground
                )
            }
        }
    }
}