package com.company;

/**
 * Created by lukasz on 12/10/2017.
 */
public class Colors {
    public static final int BLACK = int2RGB(0,0,0);
    public static final int WHITE = int2RGB(255,255,255);
    public static final int RED = int2RGB(255, 0 ,0);
    public static final int GREEN = int2RGB(0, 255, 0);
    public static final int BLUE = int2RGB(0,0, 255);


    public static int int2RGB(int red, int green, int blue){
        red = red & 0x000000FF;
        green = green & 0x000000FF;
        blue = blue & 0x000000FF;

        return (red << 16) + (green << 8) + blue;
    }
}
