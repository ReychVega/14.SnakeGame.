package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reychell Vega P.
 */
public class Snake {
    
    private int life = 1;
    private String mov="Right";
    //screen
    private int height = 600;
    private int width = 800;
    private int sizeByCell = 20;
    private int gameCells = (height * width) / sizeByCell;

    //body of our snake
    private int xCells[]=new int[gameCells];
    private int yCells[]=new int[gameCells];
    private int bodyCells=1;

      
    public Snake() {
       
    }//constructor

    //sets and gets
    public int[] getxCells() {
        return xCells;
    }
    
    public int getCellByIndex(int[] array,int index){
        return array[index];
    }

    public void setxCells(int[] xCells) {
        this.xCells = xCells;
    }

    public int[] getyCells() {
        return yCells;
    }

    public void setyCells(int[] yCells) {
        this.yCells = yCells;
    }
    
    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getBodyCells() {
        return bodyCells;
    }

    public void addBodyCells() {
        bodyCells+=1;
    }

       //sets and gets
    public String getMov() {
        return mov;
    }

    public void setMov(String mov) {
        this.mov = mov;
    }
    
    public void draw(Graphics g) {
        
        for (int i = 0; i < this.bodyCells; i++) {
            if (i==0) {//head color
               g.setColor(Color.WHITE);
                g.fill3DRect(xCells[i], yCells[i], sizeByCell, sizeByCell, true);
             }else{
                if(i!=0){//body color
                g.setColor(Color.LIGHT_GRAY);
                g.fill3DRect(xCells[i], yCells[i], sizeByCell, sizeByCell, true);
            }
          }
        }
       
    }

    public void movement() {//snake´s movement
        for (int i = getBodyCells(); i > 0; i--) {
            xCells[i] = xCells[i - 1];
            yCells[i] = yCells[i - 1];
        }
        
        casosMovimientoContinuo(this.getMov());

    }

    public void moveRight() {
        xCells[0]=xCells[0]+sizeByCell;
    }

    public void moveLeft() {
        xCells[0]=xCells[0]-sizeByCell;
    }

    public void moveUp() {
        yCells[0]=yCells[0]-sizeByCell;
    }

    public void moveDown() {
        yCells[0]=yCells[0]+sizeByCell;
    }
    
     private void casosMovimientoContinuo(String s) {try {
         // de acuerdo al boton precionado, inializa un movimiento continuo
        
         Thread.sleep(300);  //para que vaya copilando despacio 
         checkCollition(); //revisa colision.
         switch (s) {
             
             case "Right":
                 this.moveRight();
                 break;
             case "Left":
                 this.moveLeft();
                 break;
             case "Up":
                 this.moveUp();
                 break;
             case "Down":
                 this.moveDown();
                 break;
         }
        } catch (InterruptedException ex) {
            Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void checkCollition(){
        //caso 1, choca con bordes.
        if (xCells[0]<0) {
            this.setLife(0);
        }
        if (xCells[0]>width-this.sizeByCell) {
            this.setLife(0);
        }
        if (yCells[0]< 0) {
            this.setLife(0);
        }
        if (yCells[0]> height-this.sizeByCell) {
            this.setLife(0);
        }

       
        //caso 2. si se come así misma  
            for (int i = this.bodyCells; i >3; i--) {
                if ((xCells[0]==xCells[i])&&(yCells[0]==yCells[i])) {
                    this.setLife(0);
                }
            }
        


    } 
}
