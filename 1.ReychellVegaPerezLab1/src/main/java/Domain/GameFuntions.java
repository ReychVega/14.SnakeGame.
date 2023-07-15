package Domain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Reychell Vega P.
 */
public class GameFuntions {

    private Snake snake = new Snake();
    private Stones stone;
    private Apple apple;

    private int height = 600;
    private int width = 800;
    private int sizeByCell = 20;
    private int gameCells = (height * width) / sizeByCell;
    private int appleCount;

    Random random = new Random();
    private ArrayList<Stones> piedritas;//memoria dinámica

    public GameFuntions() {

        startGame();
        //createStone(); //create a new stone
    }

    public Snake getSnake() {
        return snake;
    }

    public ArrayList<Stones> getPiedritas() {
        return piedritas;
    }

    public void setPiedritas(ArrayList<Stones> piedritas) {
        this.piedritas = piedritas;
    }

    public void startGame() {
        apple = new Apple();
        this.appleCount=1;

        //this.stone = new Stones();//CAMBIO
        this.piedritas = new ArrayList<Stones>();//save the stones places.
        
     

    }

    public void drawAllObjects(Graphics g) {
        //show apples
        this.apple.draw(g);  eatApple();  stoneCollition();
        //show snake
        if (this.snake.getLife() == 1) {
            this.snake.draw(g);
        } else {
            System.out.println("It´s death");
        }
        
        //show stones
        if (this.piedritas.size()>1) {
          for (int i = 0; i < this.piedritas.size(); i++) {
            this.piedritas.get(i).dibujar(g);
        }   
      }
       
    }

    public void createStone() {
        this.piedritas.add(new Stones(unrepeatedPosX(),unrepeatedPosY()));//
        this.piedritas.add(new Stones(unrepeatedPosX(),unrepeatedPosY()));//CAMBIO4
    }

    public void newApple() {
       // System.out.println(this.snake.getBodyCells());

        if (this.appleCount%10==0) {//10
              createStone();//********************
        }
        this.apple = new Apple();
        this.appleCount++;
        this.snake.addBodyCells();//crece añadiendo una celda a su cuerpo
    }

    public void eatApple() {
        if ((this.snake.getCellByIndex(this.snake.getxCells(), 0) == this.apple.getApplePosX())&&
                (this.snake.getCellByIndex(this.snake.getyCells(), 0) == this.apple.getApplePosY())) {
                newApple();
                //System.out.println("Comió.");
        }

    }

    public void stoneCollition(){
            //caso 3. piedrita
        if (this.piedritas.size() > 1) {
            for (int i = 0; i < this.piedritas.size(); i++) {
                if ((this.snake.getCellByIndex(this.snake.getxCells(), i)==this.piedritas.get(i).getStonePosX())
                        &&(this.snake.getCellByIndex(this.snake.getyCells(), i)==this.piedritas.get(i).getStonePosY() ) ) {
                             this.snake.setLife(0);
                }
            }
        }
    }   
    
          
    private int unrepeatedPosX() {
        int numAleatorio = 0;
                int count=0;

        numAleatorio = random.nextInt((int) width / sizeByCell) * sizeByCell;
        while(count<this.piedritas.size()) {
            
            if ((this.piedritas.get(count).getStonePosX()!=numAleatorio)&& (this.piedritas.get(count).getStonePosX())
                    !=this.apple.getApplePosX()){
                count++;
            }else{
               numAleatorio = random.nextInt((int) width / sizeByCell) * sizeByCell;

            }
        }
        //xCells.remove(numAleatorio);//remueve el contenido de la posicion
        return numAleatorio;
    }
    
    private int unrepeatedPosY() {
        int numAleatorio = 0;
                int count=0;

        numAleatorio = random.nextInt((int) height / sizeByCell) * sizeByCell;
        while(count<this.piedritas.size()) {
            
            if (this.piedritas.get(count).getStonePosY()!=numAleatorio && (this.piedritas.get(count).getStonePosY())
                    !=this.apple.getApplePosY()){
                count++;
            }else{
               numAleatorio = random.nextInt((int) height / sizeByCell) * sizeByCell;

            }
        }
        //xCells.remove(numAleatorio);//remueve el contenido de la posicion
        return numAleatorio;
    }  
}
