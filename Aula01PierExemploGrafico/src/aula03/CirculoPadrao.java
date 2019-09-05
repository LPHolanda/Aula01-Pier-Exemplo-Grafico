package aula03;

import java.awt.Graphics;
import javax.swing.JFrame;

public class CirculoPadrao extends JFrame {

	private static final long serialVersionUID = 1L;

	public static final int largura = 500;
	public static final int altura = 500;

	public CirculoPadrao() {
		setSize(500, 500);
		setTitle("Círculo padrão");
		setVisible(true);
	}

	public void plot(int x1, int y1) {
		Graphics g = getGraphics();
		g.drawOval(x1, y1, 1, 1);
//		g.drawOval(x, y, 1, 1);
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
			
			//um tempinho pra fazer graça
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			};
			
			x++;
		}
	}

	public static void main(String[] args) {
		CirculoPadrao p = new CirculoPadrao();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// tempinho
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		}
		;

		p.desenhaQuadrante(0, 0);
		p.desenhaQuadrante(-200, 0);
		p.desenhaQuadrante(0, 200);
		
//		p.eixoXCartesiano();
//		p.eixoYCartesiano();
	}
}
