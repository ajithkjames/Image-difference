import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
 
public class ImgDiff
{
	
  public static void main(String args[])
  {

       
	String s1=null;
	String s2=null;
	URL url1 = null;
	URL url2 = null;
	BufferedImage img1 = null;
        BufferedImage img2 = null;
 try {
Scanner scan= new Scanner(System.in);
       
 System.out.print("Please enter the first url : ");
             s1=scan.nextLine();
 System.out.print("Please enter the second url : ");
      	    s2=scan.nextLine();
 	url1 = new URL(s1);
 	url2 = new URL(s2);
	img1 = ImageIO.read(url1);
	img2 = ImageIO.read(url2);
      
        } catch (IOException e) {
            e.printStackTrace();
        } 
    

  
int width1 = img1.getWidth(null);
    int width2 = img2.getWidth(null);
    int height1 = img1.getHeight(null);
    int height2 = img2.getHeight(null);
    if ((width1 != width2) || (height1 != height2)) {
      System.err.println("The dimensions of images are Different. Please enter two images of same dimensions!!");
      System.exit(1);
    }
    long diff = 0;
    for (int y = 0; y < height1; y++) {
      for (int x = 0; x < width1; x++) {
        int rgb1 = img1.getRGB(x, y);
        int rgb2 = img2.getRGB(x, y);
        int r1 = (rgb1 >> 16) & 0xff;
        int g1 = (rgb1 >>  8) & 0xff;
        int b1 = (rgb1      ) & 0xff;
        int r2 = (rgb2 >> 16) & 0xff;
        int g2 = (rgb2 >>  8) & 0xff;
        int b2 = (rgb2      ) & 0xff;
        diff += Math.abs(r1 - r2);
        diff += Math.abs(g1 - g2);
        diff += Math.abs(b1 - b2);
      }
    }
    double n = width1 * height1 * 3;
    double p = diff / n / 255.0;
    System.out.println("difference percentage: " + (p * 100.0));
  }
}
