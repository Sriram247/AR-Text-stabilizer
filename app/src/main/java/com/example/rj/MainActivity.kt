package com.example.rj
import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.Anchor
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import com.google.ar.sceneform.rendering.ViewRenderable
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var arFragment: ArFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the ARFragment in the layout (make sure your layout has the <fragment> defined)
        arFragment = supportFragmentManager.findFragmentById(R.id.ux_fragment) as ArFragment

        // Set up AR plane detection and tap handling
        arFragment.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            // Create an anchor at the tapped position
            val anchor = hitResult.createAnchor()
            placePdfInAR(anchor)
        }
    }
git 
    private fun placePdfInAR(anchor: Anchor) {
        // Create an AnchorNode to attach the content to the AR scene
        val anchorNode = AnchorNode(anchor)
        anchorNode.setParent(arFragment.arSceneView.scene)

        // Create and render the PDF as an AR object
        createPdfRenderable(anchorNode)
    }

    private fun createPdfRenderable(anchorNode: AnchorNode) {
        // Load the PDF file (ensure you have the PDF in your assets or file directory)
        val pdfFile = File(filesDir, "example.pdf")

        // Open the PDF file
        val fileDescriptor = ParcelFileDescriptor.open(pdfFile, ParcelFileDescriptor.MODE_READ_ONLY)
        val pdfRenderer = PdfRenderer(fileDescriptor)

        // Render the first page of the PDF as a bitmap
        val page = pdfRenderer.openPage(0)
        val bitmap = Bitmap.createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888)
        page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
        page.close()

        // Create an ImageView to display the bitmap
        val imageView = ImageView(this)
        imageView.setImageBitmap(bitmap)

        // Use ViewRenderable to convert the ImageView into a 3D object for AR
        ViewRenderable.builder()
            .setView(this, imageView)
            .build()
            .thenAccept { renderable ->
                // Attach the renderable to a TransformableNode so it can be moved, rotated, etc.
                val transformableNode = TransformableNode(arFragment.transformationSystem)
                transformableNode.renderable = renderable
                transformableNode.setParent(anchorNode)
                transformableNode.select() // Automatically select the node for transformation
            }
            .exceptionally { throwable ->
                // Handle any errors that occur during ViewRenderable building
                throwable.printStackTrace()
                null
            }

        // Close the PdfRenderer
        pdfRenderer.close()
    }
}
