package com.company.Patterns;

import com.company.Colors;
import com.company.Main;

import java.awt.image.BufferedImage;

/**
 * Created by Fisent on 16.10.2017.
 */
public class LittleRings {

    public static void run(int width, int height, int fieldSize, int ringWidth, String filename){
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < width; i++){
            for (int j = 0; j<height; j++){
                calculateStep(i, j, fieldSize, ringWidth, image);
            }
        }

        Main.save(image, filename);
    }

    private static void calculateStep(int i, int j, int fieldSize, int ringWidth, BufferedImage image){
        int indexX = i / fieldSize;
        int indexY = j / fieldSize;

        int x_c = (int) (indexX * fieldSize + 0.5 * fieldSize);
        int y_c = (int) (indexY * fieldSize + 0.5 * fieldSize);

        double distance = Math.sqrt((i - x_c) * (i - x_c) + (j - y_c) * (j - y_c));

        int ringIndex = (int) distance / ringWidth;
        if(ringIndex % 2 == 0)
            image.setRGB(i, j, Colors.BLACK);
        else
            image.setRGB(i, j, Colors.WHITE);
    }
}
