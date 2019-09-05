package aula03;

import java.awt.Graphics;
import javax.swing.JFrame;

public class CirculoPadrao extends JFrame {

	private static final long serialVersionUID = 1L;

	public CirculoPadrao() {
		setSize(500, 500);
		setTitle("Círculo padrão");
		setVisible(true);
	}

	public void plot(int x1, int y1) {
		Graphics g = getGraphics();
		g.drawOval(x1, y1, 1, 1);
	}

	public void desenhaQuadrante(int x, int y) {
		
		int dx = 250;
		int dy = 250;
		
		if(x > y) {
			x = y;
		}
		
		int r = 200;
		
		while (x < r) {
			if (y > 0) {
				y = (int)Math.sqrt(r*r - x*x);
				y = -y;
			} else {
				y = (int)Math.sqrt(r*r - x*x);
			}
			
			plot(x + dx, y + dy);
			x++;
			
			//um tempinho pra fazer graça
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				System.out.println(e);
			};			
		}
	}

	public static void main(String[] args) {
		CirculoPadrao circulo = new CirculoPadrao();
		circulo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// tempinho
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		};

		circulo.desenhaQuadrante(0, 0);
		circulo.desenhaQuadrante(-200, 0);
		circulo.desenhaQuadrante(0, 200);
	}
}
