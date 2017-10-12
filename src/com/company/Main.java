package com.company;

import com.company.Patterns.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String[] args){
        Ring r = new Ring(1024, 512, 10, "kregi");
        //r.run();
        Grid g = new Grid(1024, 512, 10, 5, 5, "siatka");
        //g.run();
        Chess c = new Chess(1024, 512, 42, "szachy");
        //c.run();
        RingFading rf = new RingFading(1024, 512, 5, "kregiRozmyte");
        //rf.run();
        ChessDiagonal cd = new ChessDiagonal(1024, 512, 30, "szachyWPoprzek");
        cd.run();
        WeirdStuff wf = new WeirdStuff(1024, 512, 10, "weird");
        //wf.run();
    }



    public static void save(BufferedImage image, String filename){
        try{
            ImageIO.write(image, "bmp", new File(filename + ".bmp"));
            System.out.println("Udalo sie :D");
        }catch(IOException e){
            System.out.println("The image cannot be stored");
        }
    }
}
