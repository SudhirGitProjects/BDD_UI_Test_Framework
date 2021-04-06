package com.CucumberCraft.Screenshot;


import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class CheckPixels {
	 public static boolean b;
    public static boolean compareImage()  throws IOException {
       
        File pic1 = new File("C:\\Users\\Ajit\\Downloads\\CRAFTCucumber1\\CRAFTCucumber\\CRAFTCucumber\\target\\cucumber-report\\Smoke\\embedded1.png");
        File pic2 = new File("C:\\Users\\Ajit\\Downloads\\CRAFTCucumber1\\CRAFTCucumber\\CRAFTCucumber\\target\\cucumber-report\\Smoke\\embedded2.png");
        if (Arrays.equals(returnPixelVal(pic1), returnPixelVal(pic2))) {
             b=true; 
        } else {
            System.out.println("No match");
             b=false;
        }
		return b;

    }

    public static byte[] returnPixelVal(File in) {

        BufferedImage img = null;
        File f = null;
        byte[] pixels = null;
        // read image
        try {
            f = in;
            img = ImageIO.read(f);
            pixels = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
        } catch (IOException e) {
            System.out.println(e);
        }

        return pixels;

    }

}
