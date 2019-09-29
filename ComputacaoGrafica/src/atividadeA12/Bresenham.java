package atividadeA12;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


public class Bresenham extends JFrame {
	private static final long serialVersionUID = 1L;

	public Bresenham() {
		setSize(500,500);
		setVisible(true);
	}
	
	public void plot(int x1, int y1) {
		Graphics g = getGraphics();
		g.setColor(Color.RED);
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
			
			plot( (int)x , (int)y );
		}
		
	}
	
	public void desenho(int raio) {
		int p, i, j;
		
		int x = 0;
		int y = raio;
		p = 1 - raio;
		i = 20;
		j = 0;
		int z = 700;
		
		plot(x,y);
		while(x < y) {
			x = x + 1;
			if (p < 0) {
				p = p + 2 * x + 1;
			} else {
				y = y - 1;
				p = p + 2 * (x - y) + 1;
			}
			
			if (j % 10 == 0) {
				desenhaLinha(-y+z, x, i, 600);
				i = i + 15;
				z = z - 5;
			}

			j++;
		}
	}

	
	public static void main(String[] args) {
		Bresenham tarefa1 = new Bresenham();
		Bresenham tarefa2 = new Bresenham();
		tarefa1.setTitle("Tarefa 1");
		tarefa2.setTitle("Tarefa 2");
		
		tarefa1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tarefa2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// tempinho
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		};
		
		tarefa1.desenhaLinha(200, 200, 350, 50);
		tarefa1.desenhaLinha(200, 200, 50, 50);
		tarefa1.desenhaLinha(200, 200, 50, 350);
		tarefa1.desenhaLinha(200, 200, 350, 350);
	
		tarefa2.desenho(700);
	}
}
