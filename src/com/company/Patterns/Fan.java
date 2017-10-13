package com.company.Patterns;

import com.company.Colors;
import com.company.Main;

import java.awt.image.BufferedImage;

/**
 * Created by Fisent on 12.10.2017.
 */
public class Fan {

    private int x_res, y_res, segmentWidth;
    private String filename;
    private int primaryColor, secondaryColor;
    private BufferedImage image;

    public Fan(int width, int height, int segmentWidth, String filename, int primaryColor, int secondaryColor){
        this.x_res = width;
        this.y_res = height;
        this.segmentWidth = segmentWidth;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
    }

    public Fan(int width, int height, int segmentWidth, String filename){
        this.x_res = width;
        this.y_res = height;
        this.segmentWidth = segmentWidth;
        this.primaryColor = Colors.BLACK;
        this.secondaryColor = Colors.WHITE;
    }

    public void run(){
        image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);

        int x_c = x_res / 2;
        int y_c = y_res / 2;

        for(int i = 0; i< x_res; i++){
            for(int j = 0; j < y_res; j++){
                calculateStep(i, j, x_c, y_c);
            }
        }
        Main.save(image, "fan");
    }

    public void mask(BufferedImage existingImage){
        x_res = existingImage.getWidth();
        y_res = existingImage.getHeight();

        int x_c = x_res / 2;
        int y_c = y_res / 2;

        for(int i = 0; i< x_res; i++){
            for(int j = 0; j < y_res; j++){
                calculateMaskedStep(i, j, x_c, y_c, existingImage);
            }
        }

        Main.save(existingImage, "masked/fractalsMasked");
    }

    private void calculateStep(int i, int j, int x_c, int y_c){
        double przyprostokatna = Math.abs(x_c - i);
        double przeciwprostokatna = Math.sqrt((i - x_c) * (i - x_c) + (j - y_c) * (j - y_c));

        double angle = Math.acos(przyprostokatna / przeciwprostokatna);

        int ang = (int) (angle * 100);

        if(ang / segmentWidth % 2 == 0)
            image.setRGB(i, j, primaryColor);
        else
            image.setRGB(i, j, secondaryColor);
    }

    private void calculateMaskedStep(int i, int j, int x_c, int y_c, BufferedImage existingImage){
        double przyprostokatna = Math.abs(x_c - i);
        double przeciwprostokatna = Math.sqrt((i - x_c) * (i - x_c) + (j - y_c) * (j - y_c));

        double angle = Math.atan(przyprostokatna / przeciwprostokatna);

        int ang = (int) (angle * 1000);

        if(ang / segmentWidth % 2 == 0)
            existingImage.setRGB(i, j, primaryColor);
    }
}
