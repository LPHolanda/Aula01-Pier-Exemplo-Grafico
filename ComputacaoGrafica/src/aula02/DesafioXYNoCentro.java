package aula02;

import java.awt.Graphics;

import javax.swing.JFrame;

public class DesafioXYNoCentro extends JFrame {
	private static final long serialVersionUID = 1L;

	public static final int largura = 500;
	public static final int altura = 500;

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

	public void legenda(int x0, int y0) {
		Graphics g = getGraphics();
		g.drawOval(x0, y0, 0, 0);
	}

	/**
	 * 
	 */
	public void desenha() {

		int Userx1 = 1;
		int Usery1 = 1;
		int Userx2 = 200;
		int Usery2 = 200;

		int x1 = (largura / 2) + Userx1;
		int y1 = (altura / 2) - Usery1;
		int x2 = (largura / 2) + Userx2;
		int y2 = (altura / 2) - Usery2;

//		int m = (y2 - y1) / (x2 - x1);
//		int b = y1 - (m * x1);

		int m = (y2 - y1) / (x2 - x1);
		if (m <= 1) {
			while (x1 <= x2) {
				plot(x1, y1);
				y1 = y1 + m;
				x1++;
			}
		} else {
			while (x1 <= x2) {
				plot(x2, y2);
				x1 = x1 + (1 / m);
				y1++;
			}
		}
	}

	public void eixoXCartesiano() {

		int x0 = 0;
		int y0 = altura / 2;

		while (x0 < largura) {
			legenda(x0, y0);
			x0++;
		}
	}

	public void eixoYCartesiano() {

		int x0 = largura / 2;
		int y0 = 0;

		while (y0 < altura) {
			legenda(x0, y0);
			y0++;
		}
	}

	public static void main(String[] args) {
		DesafioXYNoCentro xy = new DesafioXYNoCentro();
		xy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// tempinho
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		}
		;

		xy.desenha();
		xy.eixoXCartesiano();
		xy.eixoYCartesiano();
	}
}
