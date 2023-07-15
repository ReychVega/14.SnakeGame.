//myPanel
package GUI;

import Domain.GameFuntions;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author Reychell Vega P.
 */


public class GamePanel extends JPanel implements KeyListener {

    //panel size
    private int height=600;
    private int width = 800;
    private int sizeByCell=20;
    private int  gameCells=(height*width)/sizeByCell;
    
    private JLabel indicaFin = new JLabel();
    private GameFuntions game;

//constructor
    public GamePanel() {
        game=new GameFuntions();

        this.setPreferredSize(new Dimension(width,height));
        this.setFocusable(true);
        this.setRequestFocusEnabled(true);//foco
        this.addKeyListener(this);
        
    }
    
    public GameFuntions getGame() {
        return game;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(0, 0, Color.BLACK, 0, height, new Color(0, 100, 0));
        g2D.setPaint(gp);
        g2D.fillRect(0, 0, width, height);
        this.game.drawAllObjects(g);
        this.game.getSnake().movement();
        if (this.game.getSnake().getLife()==1) {
            repaint();
        }
        
        if(this.game.getSnake().getLife()==0){
            this.game.getSnake().setMov("movimientoNulo.");
            g.setFont(new Font("Serif",Font.ITALIC, 45));
            g.setColor(Color.RED);
            g.drawString("Game Over", 300, 300);
        }
       
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
     
        if ((this.game.getSnake().getMov() != "Left") && (e.getKeyCode() == KeyEvent.VK_RIGHT)) {
            this.game.getSnake().setMov("Right");
        }

        if ((this.game.getSnake().getMov() != "Right") && (e.getKeyCode() == KeyEvent.VK_LEFT)) {
            this.game.getSnake().setMov("Left");

        }
        if ((this.game.getSnake().getMov() != "Down") &&(e.getKeyCode() == KeyEvent.VK_UP)) {
            this.game.getSnake().setMov("Up");

        }

        if ((this.game.getSnake().getMov() != "Up") && (e.getKeyCode() == KeyEvent.VK_DOWN)) {
            this.game.getSnake().setMov("Down");

        }
        
          repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
    
}