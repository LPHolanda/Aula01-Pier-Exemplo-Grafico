package aula02;

import java.awt.Graphics;

import javax.swing.JFrame;

public class DDA extends JFrame{

	public DDA() {
		setSize(800, 600);
		setTitle("DDA");
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
		DDA p = new DDA();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// tempinho
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		};

		p.desenha();
	}
}
