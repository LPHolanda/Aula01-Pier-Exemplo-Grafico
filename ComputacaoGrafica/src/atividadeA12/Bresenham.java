package atividadeA12;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Bresenham extends JFrame {
	private static final long serialVersionUID = 1L;

	public Bresenham() {
		setSize(600,600);
		setVisible(true);
	}
	
	public void plot(int x1, int y1) {
		Graphics g = getGraphics();
		g.drawOval(x1, y1, 1, 1);
	}
	
	public void desenhaQuadrante(int x, int y, int raio) {
		int p, i, j;
		int x1 = 10, y1 = 80, x2 = 0, y2 = 650;
		
		boolean primeiraVez = true;
		
		x = 0;
		y = raio;
		p = 1 - raio;
		i = 5;
		j = 0;
		
		plot(x,y);

		while(x < y) {
			x = x + 1;
			if (p < 0) {
				p = p + 2 * x + 1;
			} else {
				y = y - 1;
				p = p + 2 * (x - y) + 1;
			}
			plot(-y + 707, x);
			plot(-x + 707, y);
			
			if (j % 2 == 0 && x1 <= 305) {

				desenhaReta(x1, y1, x2, y2);
				
				if (x1 == 60) {
					y1 = y1 + 15;
					x1 = x1 + 10;
					desenhaReta(x1, y1, x2, y2);
					x1 = x1 + 5;
					
				} else if (x1 >= 80) {
					x1 = x1 + 10;
					
				} else if (x1 == 15 || x1 == 20 || x1 == 30) { 
					//repete x1 uma vez
					
					y1 = y1 + 15;
					desenhaReta(x1, y1, x2, y2);
					x1 = x1 + 5;
					y1 = y1 + 15;
					
					primeiraVez = false;
					
				} else if (x1 < 185){
					x1 = x1 + 5;					
					primeiraVez = true;
					
				} else {
//					y2 = y2 + 100;
				}
				
				if (primeiraVez) {
					y1 = y1 + 15;
					primeiraVez = true;
				}
				
				if (x1 >= 170 && x1 <= 305) {
					desenhaReta(x1, y1, x2, y2);
					
					int z = 1;
					y2 = y2 + 100;
					while (z < 5) {
						x1 = x1 + 15;
						y1 = y1 + 15;
						desenhaReta(x1, y1, x2, y2);
						
						z++;
					}
					
					z = 1;
					x1 = x1 + 15;
					y1 = y1 + 15;
					y2 = y2 + 100;
					
					desenhaReta(x1, y1, x2, y2);
					
					while (z < 5) {
						x1 = x1 + 20;
						y1 = y1 + 15;
						desenhaReta(x1, y1, x2, y2);
						
						z++;
					}
				}
			}
			
			if (j % 11 == 0 && i < 450) {
				desenhaReta(0, i, -y + 707, x);
				
				i = i + 10;
			}

			j = j + 1;
		}
		
		x1 = 0;
		y1 = 455;
		x2 = 212;
		y2 = 496;
		while(y1 < 600) {
			desenhaReta(0, y1, x2, y2);
			
			y1 = y1 + 10;
			x2 = x2 + 13;
			y2 = y2 + 11;
		}
	}
	
	public void desenhaReta(int x1, int y1, int x2, int y2) {
		int dx = x2 - x1;
		int dy = y2 - y1;
		
		if (dx < 0) {
			dx = dx * -1;
		} 
		if (dy < 0) {
			dy = dy * -1;
		}
		
		int x = x1;
		int y = y1;
		
		plot(x, y);
		
		int p = 2 * dy - dx;
		
		while(x <= x2) {
			x = x + 1;
			if (p < 0) {
				p = p + 2 * dy; 
			} else {
				
				if (y2 < y) {
					y = y - 1;
				} else {
					y = y + 1;
				}
				
				p = p + 2 * (dy - dx);
			}
			
			plot(x,y);
		}
		
		while(x > x2) {
			x = x - 1;
			if (p < 0) {
				p = p + 2 * dy; 
			} else {
				
				if (y2 < y) {
					y = y - 1;
				} else {
					y = y + 1;
				}
				p = p + 2 * (dy - dx);
			}
			
			plot(x,y);
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
		
		tarefa1.desenhaReta(200, 200, 350, 50);
		tarefa1.desenhaReta(200, 200, 50, 50);
		tarefa1.desenhaReta(200, 200, 50, 350);
		tarefa1.desenhaReta(200, 200, 350, 350);
		
		tarefa2.desenhaQuadrante(0, 0, 700);		
	}
}
