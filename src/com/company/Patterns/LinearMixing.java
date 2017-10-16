package com.company.Patterns;

import com.company.Colors;
import com.company.Main;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Fisent on 16.10.2017.
 */
public class LinearMixing {

    public static void mix(int fieldSize, BufferedImage image1, BufferedImage image2){
        BufferedImage mixedImage = new BufferedImage(image1.getWidth(), image1.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < mixedImage.getWidth(); i++){
            for(int j = 0; j < mixedImage.getHeight(); j++){
                mixStep(i, j, fieldSize, image1, image2, mixedImage);
            }
        }

        Main.save(mixedImage, "mixedImage");

    }

    private static void mixStep(int i, int j, int fieldSize, BufferedImage image1, BufferedImage image2, BufferedImage newImage){
        int fieldNumberX = i / fieldSize;
        int fieldNumberY = j / fieldSize;

        if(fieldNumberY % 2 == 0)
            fieldNumberX += 1;


        if(fieldNumberX % 2 == 0){
            newImage.setRGB(i, j, image1.getRGB(i, j));
        } else{
            newImage.setRGB(i, j, image2.getRGB(i, j));
        }
    }

    public static void mixGrey(int width, BufferedImage image1, BufferedImage image2, String filename){
        BufferedImage newImage = new BufferedImage(image1.getWidth(), image1.getHeight(), BufferedImage.TYPE_INT_RGB);

        System.out.println(image2.getWidth() + ", " + image2.getHeight());

        int x_c = image1.getWidth()/2;
        int y_c = image1.getHeight() / 2;

        for(int i = 0; i < image1.getWidth(); i++){
            for(int j = 0; j<image1.getHeight(); j++){
                mixGreyStep(i, j, x_c, y_c, width, image1, image2, newImage);
            }
        }

        Main.save(newImage, filename);

    }

    private static void mixGreyStep(int i, int j, int x_c, int y_c, int w,  BufferedImage image1, BufferedImage image2, BufferedImage newImage){
        double d = Math.sqrt( (i-x_c) * (i-x_c) + (j-y_c) * (j-y_c) );


        double f = 0.5 * Math.cos(d / w) + 0.5;
        double fade = f;
        Color c1 = new Color(image1.getRGB(i, j));
        Color c2 = new Color(image2.getRGB(i, j));
        int mixedRed = (int) (fade * c1.getRed() + (1-fade) * c2.getRed()) / 2;
        int mixedGreen = (int) (fade * c1.getGreen() + (1-fade) * c2.getGreen()) / 2;
        int mixedBlue = (int) (fade * c1.getBlue() + (1-fade) * c2.getBlue()) / 2;

        int mixedColor = Colors.int2RGB(mixedRed, mixedGreen, mixedBlue);
        //if (fade > 0.5)
        newImage.setRGB(i, j, mixedColor);
    }
}
