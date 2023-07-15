//Panel
package GUI;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Reychell Vega
 */
public class GameFrame extends JFrame {
private Graphics g;
    public GameFrame() {
        
        GamePanel panel=new GamePanel();
        //we add our Panel to our Frame
        this.getContentPane().add(panel);     //add my Panel
       
        this.setTitle("Snake Game.");
        this.setFont(new Font("5",Font.ITALIC,22));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);//para que no cambie el tamaño de mi ventanita
        this.pack();//para que sea del tamaño de mi panel
        this.setLocationRelativeTo(null);//centro
        this.setVisible(true);
        //this.setLayout(null);

    }
    

    
}
