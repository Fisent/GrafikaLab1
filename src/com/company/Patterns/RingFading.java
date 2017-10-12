package com.company.Patterns;

import com.company.Colors;
import com.company.Main;

import java.awt.image.BufferedImage;

/**
 * Created by lukasz on 12/10/2017.
 */
public class RingFading {

    public RingFading(int width, int height, int ringsWidth, String filename, int primaryColor, int secondaryColor){

        this.filename = filename;
        this.w = ringsWidth;

        x_res = width;
        y_res = height;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;

    }

    public RingFading(int width, int height, int ringsWidth, String filename){

        this.filename = filename;
        this.w = ringsWidth;

        x_res = width;
        y_res = height;
        this.primaryColor = Colors.BLACK;
        this.secondaryColor = Colors.WHITE;

    }

    private String filename;

    private int primaryColor, secondaryColor;

    //Fixed ring width
    private int w = 10;

    private int x_res, y_res;

    //Predefined black and white RGB representation packed as integers
    private int black, white;

    public void run(){
        System.out.println("Ring pattern synthesis");

        BufferedImage image;

        // Ring center coordinates
        int x_c, y_c;

        int i,j;

        image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);

        //find coordinates of image center
        x_c = x_res / 2;
        y_c = y_res / 2;

        for(i = 0; i < y_res; i++){
            for(j = 0; j < x_res; j++){

                calculateStepRings(i, j, x_c, y_c, image);

            }
        }

        Main.save(image, filename);
    }

    private void calculateStepRings(int i, int j, int x_c, int y_c, BufferedImage image){
        double d;
        int r;

        //calculate distance to the image center
        d = Math.sqrt( (i-y_c) * (i-y_c) + (j-x_c) * (j-x_c) );

        double fade = 0.5 * Math.cos(d / w) + 0.5;


        int color = Colors.int2RGB((int)(fade * 255), (int) (fade * 255),(int) (fade * 255));

        image.setRGB(j, i, color);
    }
}


