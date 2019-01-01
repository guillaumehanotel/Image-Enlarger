package com.guillaumehanotel;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImageEnlarger {


        /*
        BufferedImage buff_original_image = ImageIO.read(new File(pathImage));
        BufferedImage imgDestination = new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = imgDestination.createGraphics();
        AffineTransform affinetransformation = AffineTransform.getScaleInstance(4, 4);
        g.drawRenderedImage(buff_original_image, affinetransformation);
        ImageIO.write(imgDestination, "JPG", new File("D:\\Images\\test.png"));
        */


    void enlargeImage(String inputImageName, String outputImageName, int multiplier) throws IOException {
        Image inputImage = getImageFromImageName(inputImageName);
        Image outputImage = inputImage.enlargeBy(multiplier);
        this.storeImage(outputImage, outputImageName);
    }

    private Image getImageFromImageName(String imageName) throws IOException {
        File imageFile = new File(imageName);
        BufferedImage inputImageBuffered = ImageIO.read(imageFile);
        Image image = new Image(inputImageBuffered.getWidth(), inputImageBuffered.getHeight());
        image.init(inputImageBuffered);
        return image;
    }


    private void storeImage(Image img, String name) {
        BufferedImage imageBuffered = img.getBufferedImage();
        String imageFormat = name.split("\\.")[1];
        try {
            File outputFile = new File(name);
            ImageIO.write(imageBuffered, imageFormat, outputFile);
        } catch (IOException e) {
            e.getMessage();
        }
    }

}

