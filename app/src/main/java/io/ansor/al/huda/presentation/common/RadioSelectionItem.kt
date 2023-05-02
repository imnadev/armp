package io.ansor.al.huda.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ansor.al.huda.domain.model.Language
import io.ansor.al.huda.presentation.ui.theme.AlhudaTheme
import io.ansor.al.huda.presentation.ui.theme.interSemiBold
import io.ansor.al.huda.presentation.ui.theme.layer
import io.ansor.al.huda.presentation.ui.theme.titleText

@Preview(showBackground = true)
@Composable
fun Render() {
    AlhudaTheme(darkTheme = true) {
        RadioSelectionItem(selectionItemModel = Language.UZ, isSelected = true) {

        }
    }
}

@Composable
fun RadioSelectionItem(
    modifier: Modifier = Modifier,
    selectionItemModel: SelectionItemModel,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp, start = 24.dp, end = 24.dp)
            .clip(MaterialTheme.shapes.large)
            .clickable { onSelect() },
        shape = MaterialTheme.shapes.large,
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.layer
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Image(
                modifier = Modifier.size(36.dp),
                painter = painterResource(id = selectionItemModel.icon),
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = stringResource(selectionItemModel.title),
                style = MaterialTheme.typography.interSemiBold,
                color = MaterialTheme.colors.titleText
            )
            Spacer(modifier = Modifier.weight(1f))
            RadioButton(
                selected = isSelected,
                onClick = onSelect
            )
        }


    }
}
