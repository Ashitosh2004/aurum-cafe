package com.example

import org.junit.Test
import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage

class ImageProcessorTest {
    @Test
    fun removeWhiteBackground() {
        val inFile = File("src/main/res/drawable/leaf_logo_1782132278080.jpg")
        val outFile = File("src/main/res/drawable/aurum_cafe_logo_transparent_1782131728790.png")
        if (!inFile.exists()) {
            println("File not found: \${inFile.absolutePath}")
            return
        }
        val img = ImageIO.read(inFile)
        val outImg = BufferedImage(img.width, img.height, BufferedImage.TYPE_INT_ARGB)
        for (x in 0 until img.width) {
            for (y in 0 until img.height) {
                val p = img.getRGB(x, y)
                val r = (p shr 16) and 0xFF
                val g = (p shr 8) and 0xFF
                val b = p and 0xFF
                if (r > 240 && g > 240 && b > 240) {
                    outImg.setRGB(x, y, 0x00FFFFFF)
                } else {
                    outImg.setRGB(x, y, p or (0xFF shl 24))
                }
            }
        }
        ImageIO.write(outImg, "png", outFile)
        println("Saved to \${outFile.absolutePath}")
    }
}
