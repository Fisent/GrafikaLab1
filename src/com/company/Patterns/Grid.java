package com.company.Patterns;

import com.company.Main;
import com.company.Colors;

import java.awt.image.BufferedImage;

/**
 * Created by lukasz on 10/10/2017.
 */
public class Grid {

    public Grid(int width, int height, int lineWidth, int emptySpaceCentresDistanceX, int emptySpaceCentresDistanceY,  String filename, int primaryColor, int secondaryColor){
        this.filename = filename;
        x_res = width;
        y_res = height;
        w = lineWidth;
        this.emptySpaceCentresDistanceX = emptySpaceCentresDistanceX + 1;
        this.emptySpaceCentresDistanceY = emptySpaceCentresDistanceY + 1;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
    }

    public Grid(int width, int height, int lineWidth, int emptySpaceCentresDistanceX, int emptySpaceCentresDistanceY,  String filename){
        this.filename = filename;
        x_res = width;
        y_res = height;
        w = lineWidth;
        this.emptySpaceCentresDistanceX = emptySpaceCentresDistanceX + 1;
        this.emptySpaceCentresDistanceY = emptySpaceCentresDistanceY + 1;
        this.primaryColor = Colors.BLACK;
        this.secondaryColor = Colors.WHITE;
    }

    private int primaryColor, secondaryColor;

    private String filename;

    //Fixed line width
    private int w ;

    //empty space width
    private int emptySpaceCentresDistanceX;
    private int emptySpaceCentresDistanceY;

    private int x_res, y_res;

    //Predefined black and white RGB representation packed as integers
    private int black, white;

    public void run(){
        System.out.println("Grid pattern synthesis");

        BufferedImage image;

        //Image resolution
        int i,j;

        image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);

        //find coordinates of image center
        for(i = 0; i < y_res; i++){
            for(j = 0; j < x_res; j++){

                calculateStep(i, j, image);

            }
        }

        Main.save(image, filename);
    }

    public void maskImage(BufferedImage exisitngImage){
        System.out.println("Masking existing picture");

        int x_c, y_c, i, j;

        for(i = 0; i < exisitngImage.getWidth();i++){
            for(j = 0; j< exisitngImage.getHeight(); j++){
                calculateMaskingStep(i, j, exisitngImage);
            }
        }

        Main.save(exisitngImage, "masked/sunriseGrid");
    }

    private void calculateStep(int i, int j, BufferedImage image){
        if((i / w) % emptySpaceCentresDistanceX == 0 || (j/w) % emptySpaceCentresDistanceY == 0)
            image.setRGB(j, i, primaryColor);
        else
            image.setRGB(j, i, secondaryColor);
    }

    private void calculateMaskingStep(int i, int j, BufferedImage image){
        if((i / w) % emptySpaceCentresDistanceX == 0 || (j/w) % emptySpaceCentresDistanceY == 0)
            image.setRGB(i, j, primaryColor);
    }


}
