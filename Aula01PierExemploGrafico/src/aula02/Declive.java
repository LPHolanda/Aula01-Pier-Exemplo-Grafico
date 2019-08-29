package aula02;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Declive extends JFrame {

	private static final long serialVersionUID = 1L;

	public Declive() {
		setSize(800, 600);
		setTitle("Exemplo");
		setVisible(true);
	}

	public void plot(int x1, int y1) {
		Graphics g = getGraphics();
		g.drawLine(x1, y1, 500, 500);
//		g.drawOval(x, y, 1, 1);
	}

	public void desenha() {
		Graphics g = getGraphics();
		
		int x1 = 100;
		int y1 = 100;
		int x2 = 200;
		int y2 = 200;

		int m = (y2 - y1) / (x2 - x1);
		int b = y1 - (m * x1);
		
		int x = x1; 
		while (x <= x2) {
			int y = m * x + b;
			plot(x, y);
			
			x++;
		}		
	}

	public static void main(String args[]) {
		Declive p = new Declive();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// tempinho
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		};

		p.desenha();
	}
}
