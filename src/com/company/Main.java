package com.company;

import com.company.Patterns.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("sunset.png"));

        Ring r = new Ring(1024, 512, 2, "kregi");
        //r.run();
        //r.mask(image);
        Grid g = new Grid(1024, 512, 10, 5, 5, "siatka");
        //g.run();
        //g.maskImage(image);
        Chess c = new Chess(1024, 512, 42, "szachy");
        //c.run();
        //c.mask(image);
        RingFading rf = new RingFading(1024, 512, 5, "kregiRozmyte");
        //rf.run();
        //rf.mask(image);
        ChessDiagonal cd = new ChessDiagonal(1024, 512, 30, "szachyWPoprzek");
        //cd.run();
        //cd.mask(image);
        WeirdStuff wf = new WeirdStuff(1024, 512, 10, "weird");
        //wf.run();
        //wf.mask(image);

        Fan fan = new Fan(1024, 512, 20, "fan");
        //fan.run();
        //fan.mask(image);

        //Dots.run(1024, 512, 50, 0.4f, "kropki");
        //LittleRings.run(1024, 512, 50, 5, "maleKregi");
        //RingsVariableWidth.run(1024, 512, 1, "kregiZmiennaGrubosc");


        BufferedImage mix1 = ImageIO.read(new File("mix1.bmp"));
        BufferedImage mix2 = ImageIO.read(new File("mix2.bmp"));
        //LinearMixing.mix(50, mix1, mix2);
        LinearMixing.mixGrey(10,mix1, mix2, "zmieszane");
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
