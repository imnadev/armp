package io.ansor.al.huda.presentation.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ansor.al.huda.R
import io.ansor.al.huda.presentation.ui.theme.AlhudaTheme
import io.ansor.al.huda.presentation.ui.theme.buttonBackground
import io.ansor.al.huda.presentation.ui.theme.buttonText
import io.ansor.al.huda.presentation.ui.theme.interBold

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    AlhudaTheme(darkTheme = true) {
        CustomButton(
            modifier = Modifier.fillMaxWidth(0.8f),
            text = R.string.about
        ) {

        }
    }
}

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.height(50.dp),
        onClick = onClick,
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.buttonBackground
        )
    ) {
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.interBold,
            color = MaterialTheme.colors.buttonText,
        )
    }
}