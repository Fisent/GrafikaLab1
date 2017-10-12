package com.company.Patterns;

import com.company.Colors;
import com.company.Main;

import java.awt.image.BufferedImage;

/**
 * Created by lukasz on 12/10/2017.
 */
public class ChessDiagonal {

    private int x_res, y_res;
    private int fieldSize;
    private String filename;
    private int primaryColor, secondaryColor;
    private BufferedImage image;

    public ChessDiagonal(int width, int height, int fieldSize, String filename){
        x_res = width;
        y_res = height;
        this.fieldSize = fieldSize;
        this.filename = filename;
        primaryColor = Colors.BLACK;
        secondaryColor = Colors.WHITE;
    }

    public ChessDiagonal(int width, int height, int fieldSize, String filename, int primaryColor, int secondaryColor){
        x_res = width;
        y_res = height;
        this.fieldSize = fieldSize;
        this.filename = filename;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
    }

    public void run(){

        image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);

        int i, j;

        for(i = 0; i<x_res; i++){
            for(j = 0; j<y_res; j++){
                calculationStep(i, j);
            }
        }

        Main.save(image, filename);

    }

    public void mask(BufferedImage existingImage){
        int i,j;

        for(i = 0; i<existingImage.getWidth();i++){
            for(j = 0; j<existingImage.getHeight(); j++){
                calculationMaskedStep(i, j, existingImage);
            }
        }

        Main.save(existingImage, "chessDiagonalMasked");
    }

    private void calculationStep(int i, int j){
        //double diagonalSize = Math.sqrt(fieldSize * fieldSize + fieldSize * fieldSize);

        //numer kratki w ktorej jestesmy wzdłuż prostej obróconej o 45 stopni
        int fieldNumberX = (int) ( Math.abs(i + j) / fieldSize);

        //odległość
        double distance = Math.abs(i - j+x_res);
        int fieldNumberY = (int) (distance / fieldSize);

        if(fieldNumberY % 2 == 0)
            fieldNumberX += 1;

        if(fieldNumberX % 2 == 0){
            image.setRGB(i, j, primaryColor);
        } else{
            image.setRGB(i,j, secondaryColor);
        }
    }

    private void calculationMaskedStep(int i, int j, BufferedImage existingImage){
        int fieldNumberX = (int) ( Math.abs(i + j) / fieldSize);

        //odległość
        double distance = Math.abs(i - j+x_res);
        int fieldNumberY = (int) (distance / fieldSize);

        if(fieldNumberY % 2 == 0)
            fieldNumberX += 1;

        if(fieldNumberX % 2 == 0){
            existingImage.setRGB(i, j, primaryColor);
        }
    }
}