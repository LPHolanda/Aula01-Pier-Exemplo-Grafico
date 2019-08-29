package aula02;

import java.awt.Graphics;

import javax.swing.JFrame;

public class DesafioXYNoCentro extends JFrame {
	private static final long serialVersionUID = 1L;

	public DesafioXYNoCentro() {
		setSize(500, 500);
		setTitle("X e Y no centro da tela");
		setVisible(true);
	}
	
	public void plot(int x1, int y1) {
		Graphics g = getGraphics();
		g.drawOval(x1, y1, 1, 1);
//		g.drawOval(x, y, 1, 1);
	}

	/**
	 * 
	 */
	public void desenha() {		
		int largura = 500;
		int altura = 500;
		
		int x1 = 100;
		int y1 = 100;
		int x2 = 200;
		int y2 = 200;
		
//		int x1 = (largura/2) + tx1;
//		int y1 = (altura/2) + ty1;
//		int x2 = (largura/2) + tx2;
//		int y2 = (altura/2) + ty2;

//		int m = (y2 - y1) / (x2 - x1);
//		int b = y1 - (m * x1);
		
		int m = (y2 - y1) / (x2 - x1);
		if (m <= 1) {
			while(x1 <= x2) {
				plot(x1, y1);
				y1 = y1 + m;
				x1++;
			}
		} else {
			while(x1 <= x2) {
				plot(x2, y2);
				x1 = x1 + (1/m);
				y1++;
			}
		}
	}
	
	public static void main(String[] args) {
		DesafioXYNoCentro p = new DesafioXYNoCentro();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// tempinho
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		};

		p.desenha();
	}
}
