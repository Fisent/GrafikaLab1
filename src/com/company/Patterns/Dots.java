package com.company.Patterns;

import com.company.Colors;
import com.company.Main;

import java.awt.image.BufferedImage;

/**
 * Created by Fisent on 16.10.2017.
 */
public class Dots {

    public static void run(int width, int height, int fieldSize, float dotSize, String filename){
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < width; i++){
            for(int j = 0; j<height; j++){
                calculateStep(i, j, fieldSize, dotSize, image);
            }
        }

        Main.save(image, filename);
    }

    private static void calculateStep(int i, int j, int fieldSize, float dotSize, BufferedImage image){
        int indexX = i / fieldSize;
        int indexY = j / fieldSize;

        int x_c = (int) (indexX * fieldSize + 0.5 * fieldSize);
        int y_c = (int) (indexY * fieldSize + 0.5 * fieldSize);

        double distance = Math.sqrt((i - x_c) * (i - x_c) + (j - y_c) * (j - y_c));

        if(distance < dotSize * fieldSize)
            image.setRGB(i, j, Colors.BLACK);
        else
            image.setRGB(i, j, Colors.WHITE);
    }

    private static void calculateMaskedStep(int i, int j, BufferedImage existingImage){

    }
}
