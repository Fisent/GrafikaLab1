package com.company.Patterns;

import com.company.Colors;
import com.company.Main;

import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * Created by Fisent on 16.10.2017.
 */
public class RingsVariableWidth {

    public static double[] distanceOfRingIndex = new double[100];

    private static int distanceToRingIndex(double distance){
        for(int i = 0; i<distanceOfRingIndex.length; i++){
            if(distanceOfRingIndex[i] > distance)
                return i;
        }
        return 100;
    }

    public static void run(int width, int height, int ringWidth, String filename){
        double currentDistance = 0;

        for(int i = 0; i<distanceOfRingIndex.length; i++){
            distanceOfRingIndex[i] = ringWidth + currentDistance;
            currentDistance += distanceOfRingIndex[i] * 0.1;
        }

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        int x_c = width / 2;
        int y_c = height / 2;

        for(int i = 0; i < width; i++){
            for (int j = 0; j<height; j++){
                calculateStep(i, j, x_c, y_c, ringWidth, image);
            }
        }

        Main.save(image, filename);
    }

    private static void calculateStep(int i, int j, int x_c, int y_c, int ringWidth, BufferedImage image){
        double distance = Math.sqrt((i - x_c) * (i - x_c) + (j - y_c) * (j - y_c));

        int index = distanceToRingIndex(distance);
        System.out.println(index);

        if(index % 2 == 0)
            image.setRGB(i, j, Colors.BLACK);
        else
            image.setRGB(i, j, Colors.WHITE);

    }
}
