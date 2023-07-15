/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Reychell Vega
 */
public class Stones {

    private int width = 800;
    private int height = 600;
    private int size = 20;
    private int stonePosX;
    private int stonePosY;
    private Random random;
    private ArrayList <Integer> xCells=new ArrayList<>();   //guarda las posibles posiciones de x
    private ArrayList <Integer> yCells=new ArrayList<>();    //guarda las posibles posiciones de y

    
    //constructor
    public Stones(int stonePosX,int stonePosY ) {
            this.stonePosX=stonePosX;
            this.stonePosY=stonePosY;
            this.random=new Random();
            //createStones(); CAMBIO3
            
         
    }
    
    
//gets and sets
    public int getStonePosX() {
        return stonePosX;
    }

    public void setStonePosX(int stonePosX) {
        this.stonePosX = stonePosX;
    }

    public int getStonePosY() {
        return stonePosY;
    }

    public void setStonePosY(int stonePosY) {
        this.stonePosY = stonePosY;
    }
    
    //CAMBIO2
//    public void createStones() {
//        this.stonePosX = random.nextInt((int) width / size) * size;//position of our apple
//        this.stonePosY = random.nextInt((int) height / size) * size;//position of our apple
//
//    }

    public void dibujar(Graphics g) {
       
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(stonePosX, stonePosY, size, size);

    }
  

}
/*   // Generamos un random para que extraigamos los indices aleatoriamente de la matriz.
        Random rand = new Random();    
        /**
         * Generamos un wihle el cual va a recorrer el vector(List) y va a ir
         * generando numeros aleatorios, en este caso el numero aleatorio puede
         * ser el mismo pero vamos a ir removiendo los contenidos del vector y
         * los numeros no se van a repetir
         
        while (numeros.size() > 0) {
            int numAleatorio = rand.nextInt(numeros.size());//Genera numero aleatorio
            
                    matriz1[i][j] = numeros.get(numAleatorio);//Asigna el contenido de la posicion del vector "numeros"
                }
            }
            numeros.remove(numAleatorio);//remueve el contenido de la posicion
        }
       // System.out.println(matriz1);
    }*/