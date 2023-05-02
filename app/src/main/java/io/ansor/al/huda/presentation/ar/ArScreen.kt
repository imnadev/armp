package io.ansor.al.huda.presentation.ar

import android.Manifest
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.ar.core.*
import com.google.ar.sceneform.Node
import com.google.ar.sceneform.ux.ArFragment
import com.ramcosta.composedestinations.annotation.Destination
import io.ansor.al.huda.R
import io.ansor.al.huda.databinding.ArFragmentBinding
import io.ansor.al.huda.domain.model.ModelUnit
import io.ansor.al.huda.presentation.ar.components.GetAnimation
import io.ansor.al.huda.presentation.ar.components.SetupFragment
import io.ansor.al.huda.util.Permission
import java.util.*

@OptIn(ExperimentalPermissionsApi::class)
@Destination
@Composable
fun ArScreen(
    model: ModelUnit,
) {

    Permission(R.string.ar_camera_rationale, Manifest.permission.CAMERA) {
        ArUI(model)
    }
}

@Composable
fun ArUI(model: ModelUnit) {

    var node: Node? by remember { mutableStateOf(null) }

    GetAnimation(model) { animationNode ->
        node = animationNode
    }

    var arFragment: ArFragment? by remember { mutableStateOf(null) }

    AndroidViewBinding(modifier = Modifier.fillMaxSize(), factory = ArFragmentBinding::inflate) {
        arFragment = root.getFragment<ArFragment>()
    }

    SetupFragment(arFragment, node)
}