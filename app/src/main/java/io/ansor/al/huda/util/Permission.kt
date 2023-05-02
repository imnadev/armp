package io.ansor.al.huda.util

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionsRequired
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import io.ansor.al.huda.R
import io.ansor.al.huda.presentation.ui.theme.*

@ExperimentalPermissionsApi
@Composable
fun Permission(
    @StringRes rationale: Int,
    vararg permissions: String,
    content: @Composable () -> Unit = { }
) {
    val context = LocalContext.current

    val multiplePermissionsState =
        rememberMultiplePermissionsState(permissions = permissions.asList())

    PermissionsRequired(
        multiplePermissionsState = multiplePermissionsState,
        permissionsNotGrantedContent = {
            Rationale(
                text = rationale,
                onRequestPermission = {
                    multiplePermissionsState.launchMultiplePermissionRequest()
                }
            )
        },
        permissionsNotAvailableContent = {
            Column(
                modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = rationale),
                    style = MaterialTheme.typography.gilroyRegular,
                    color = MaterialTheme.colors.titleText
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                            data = Uri.fromParts("package", context.packageName, null)
                        }
                        context.startActivity(intent)
                    },
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.buttonBackground
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.open_settings),
                        style = MaterialTheme.typography.gilroySemiBold,
                        color = MaterialTheme.colors.buttonText
                    )
                }
            }
        },
        content = content,
    )
}

@Composable
private fun Rationale(
    @StringRes text: Int,
    onRequestPermission: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { },
        title = {
            Text(
                text = stringResource(id = R.string.permission_rationale_title),
                style = MaterialTheme.typography.gilroySemiBold,
                color = MaterialTheme.colors.titleText,
                fontSize = 18.sp
            )
        },
        text = {
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.gilroyRegular,
                color = MaterialTheme.colors.subtitleTextSection
            )
        },
        confirmButton = {
            Button(
                modifier = Modifier.padding(end = 12.dp, bottom = 6.dp),
                onClick = onRequestPermission,
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.buttonBackground
                )
            ) {
                Text(
                    text = stringResource(id = R.string.understood),
                    style = MaterialTheme.typography.gilroySemiBold,
                    color = MaterialTheme.colors.buttonText
                )
            }
        }
    )
}