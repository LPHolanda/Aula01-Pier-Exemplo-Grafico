package atividadeA13;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TemplateKeyListener extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private int altura = 200, largura = 200, Tx = 0, Ty = 0;

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(100 + Tx, 100 + Ty, largura, altura);
    }
    public TemplateKeyListener() {
        KeyListener listener = new KeyListener() {

			
			public void keyTyped(KeyEvent e) {
			}

			
			public void keyPressed(KeyEvent e) {
				//System.out.println("Tecla: " + KeyEvent.getKeyText(e.getKeyCode()));
                //System.out.println("Tecla:  "+e.getKeyCode());
                

                int captura = e.getKeyCode();

                switch(captura) {
                    case 40: // move para baixo
                        Ty = Ty + 1;
                        break;
                    case 38: // move para cima
                        Ty = Ty - 1;
                        break;
                    case 37: // move para esquerda
                        Tx = Tx - 1;
                        break;
                    case 39: // move para direita
                        Tx = Tx + 1;
                        break;
                }
                repaint();
                
			}

			
			public void keyReleased(KeyEvent e) {
			}
		};
		addKeyListener(listener);
		setFocusable(true);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.getContentPane().add(new TemplateKeyListener());
        frame.setLocationRelativeTo(null);
       // frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("KeyListener: Computação Gráfica 2019.2");
    }  
}