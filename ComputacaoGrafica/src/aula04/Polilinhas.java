package aula04;

import java.awt.Graphics;

import javax.swing.JFrame;


public class Polilinhas extends JFrame {
	private static final long serialVersionUID = 1L;

	public Polilinhas() {
		setSize(600,600);
		setTitle("Polilinhas");
		setVisible(true);
	}
	
	public void plot(int x1, int y1) {
		Graphics g = getGraphics();
		g.drawOval(x1, y1, 1, 1);
	}
	
	public void desenhaLinha(int x1, int y1, int x2, int y2) {
		
		int dx, dy;
		float xInc, yInc, x, y, steps;
		
		dy = y1 - y2;
		dx = x1 - x2;
		
		if(dy < dx) {
			steps = Math.abs(dy);
		} else {
			steps = Math.abs(dx);
		}
		
		x = x2;
		y = y2;
		
		yInc = dy / steps;
		xInc = dx / steps;
		
		while (steps != 0) {
			steps--;
			x = x + xInc;
			y = y + yInc;
			
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				System.out.println(e);
			};
			
			plot( (int)x , (int)y );
		}
		
	}
	
	public void pontosDesenho (int[] pontos) {
		
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		
		int countX = 0;
		int countY = 0;
		
		boolean primeiraVezX = true;
		boolean primeiraVezY = true;
		
		int i = 0;
		while (i < pontos.length) {
			
			if (i % 2 == 0 && countX < 1) {
				x1 = pontos[i];
				countX++;
				
				if (primeiraVezX == false) {
					x1 = x2;
				}
				
				primeiraVezX = false;
				continue;
				
			} else if (i % 2 == 0 && countX > 0) {
				x2 = pontos[i];
				countX = 0;
			}
			
			if (i % 2 != 0 && countY < 1){
				y1 = pontos[i];
				countY++;
				
				if (primeiraVezY == false) {
					y1 = y2;
				}
				
				primeiraVezY = false;
				continue;
				
			} else if (i % 2 != 0 && countY > 0) {
				y2 = pontos[i];
				countY = 0;
				
				desenhaLinha(x1, y1, x2, y2);
			}
			
			i++;
		}
		
	}
	
	public static void main(String[] args) {
		Polilinhas poli1 = new Polilinhas();
		Polilinhas poli2 = new Polilinhas();
		poli1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		poli2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// tempinho
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		};

		int[] pontos1 = {300, 300, 400, 200, 150, 100, 250, 450, 450, 180};
		int[] pontos2 = {50, 500, 100, 100, 200, 500, 400, 200, 500, 300, 300, 500};
		
		poli1.pontosDesenho(pontos1);
		poli2.pontosDesenho(pontos2);
		
	}
}
