/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import static java.lang.Byte.SIZE;
import static java.lang.Math.random;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import GUI.GamePanel;/**
 *
 * @author Reychell Vega
 */
public class Apple {
    private int width=800;
    private int height=600;
    private int size=20;
    private int applePosX;
    private int applePosY;
    private int count;
    private Random random;

    public Apple() {
        random=new Random();
        createApple();
        this.count=0;
    }
    
    public void createApple(){
//        System.out.println(" "+random.nextInt((int)width/size)*size);
        this.applePosX=((int)random.nextInt((int)width/size)*size);//position of our apple
        this.applePosY=(int)random.nextInt((int)height/size)*size;//position of our apple
        this.count++;
        
    }

    //gets and sets
    public int getApplePosX() {
        return applePosX;
    }

    public int getApplePosY() {
        return applePosY;
    }

    public int getCount() {
        return count;
    }

    public int getSize() {
        return size;
    }

     private void setApplePosX(int i) {
         this.applePosX=i;
     }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    
    //methods
    public void draw(Graphics g) {

        g.setColor(Color.red);
        g.fillOval(applePosX, applePosY, size, size);

    }

   
}
