package io.ansor.al.huda.presentation.about

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import io.ansor.al.huda.R
import io.ansor.al.huda.presentation.ui.theme.*

@Destination
@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        Text(
            text = stringResource(R.string.about_app_title),
            color = MaterialTheme.colors.titleText,
            fontSize = 20.sp,
            style = MaterialTheme.typography.gilroyBold
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = stringResource(R.string.about_app_body),
            style = MaterialTheme.typography.gilroyMedium,
            fontSize = 16.sp,
            color = MaterialTheme.colors.bodyWithOpacity
        )
        Card(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colors.greenStroke,
                    shape = MaterialTheme.shapes.large
                ),
            elevation = 0.dp,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = stringResource(R.string.about_disclaimer_title),
                    color = MaterialTheme.colors.titleText,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.gilroyBold
                )
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = stringResource(R.string.about_disclaimer_body),
                    style = MaterialTheme.typography.gilroyMedium,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.bodyWithOpacity
                )
            }
        }
    }
}
