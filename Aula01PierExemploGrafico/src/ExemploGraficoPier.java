import javax.swing.*;
import java.awt.*;

public class ExemploGraficoPier extends JFrame {
       public ExemploGraficoPier() {
              setSize(800, 600);
              setTitle ("Exemplo");
              setVisible(true);
            }
            
       public void plot(int x, int y)
       {
            Graphics g = getGraphics();
            g.drawOval(x, y, 1, 1);
       }
       public void desenha()
       {
          Graphics g = getGraphics();
          //desenha uma linha (x1, y1, x2, y2)
           g.drawLine(100,100, 200, 200);
          //desenha um retângulo (x, y, w, h)
           g.drawRect(150, 200, 100,100);
          //desenha um retângulo cheio 
           g.fillRect(300,350,50,50);
           //troca a cor da caneta para azul
           g.setColor(new Color(0, 0, 255));
           g.fillRect(400,400,140,60);
           //desenha um oval (x, y, w, h) --> w, h, é o quadrado que 
           //                                 tangencia o circulo
           g.drawOval(450, 500, 60, 90);
           //desenha um círculo preenchido
           g.fillOval(540, 500, 60, 90);
           //coloca tres pontos
           plot (200,400);
           plot (220, 400);
           plot (240, 400);
       }
       public static void main(String args[])
       {
             ExemploGraficoPier p = new ExemploGraficoPier();
             p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
             //tempinho
             try {
                   Thread.sleep(100);
                 } catch (Exception e) {};
             p.desenha();
       }
}