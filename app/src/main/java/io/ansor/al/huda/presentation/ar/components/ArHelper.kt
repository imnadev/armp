package io.ansor.al.huda.presentation.ar.components

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.google.ar.core.Anchor
import com.google.ar.core.Config
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.Node
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.gorisse.thomas.sceneform.scene.await
import io.ansor.al.huda.domain.model.ModelUnit

@Composable
fun GetAnimation(model: ModelUnit, callback: (node: Node) -> Unit) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        val renderable = ModelRenderable.builder().setSource(context, Uri.parse(model.animation))
            .setIsFilamentGltf(true).await()

        val node = Node()
        node.worldScale = node.worldScale.scaled(model.scale)
        node.renderable = renderable
        node.renderableInstance.animate(true).start()

        callback(node)
    }
}

@Composable
fun SetupFragment(arFragment: ArFragment?, node: Node?) {
    if (arFragment != null) {
        LaunchedEffect(Unit) {
            arFragment.arSceneView.sessionConfig.apply {
                planeFindingMode = Config.PlaneFindingMode.HORIZONTAL

                arFragment.setSessionConfig(this, true)
            }

            arFragment.instructionsController.isEnabled = false
        }
    }

    if (arFragment != null && node != null) {
        LaunchedEffect(Unit) {

            var anchorNode: AnchorNode? = null

            fun set(anchor: Anchor) {
                if (anchorNode != null) return

                anchorNode = AnchorNode(anchor)
                anchorNode?.addChild(node)

                arFragment.arSceneView.scene.addChild(anchorNode)

                arFragment.arSceneView.sessionConfig.apply {
                    planeFindingMode = Config.PlaneFindingMode.DISABLED
                    arFragment.setSessionConfig(this, true)
                }
            }

            arFragment.setOnTapArPlaneListener { hitResult, plane, _ ->
                set(plane.createAnchor(hitResult.hitPose))
            }
        }
    }
}