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
				System.out.println(x1 + ", " + y1);
				System.out.println(primeiraVez);
				
				
				if (x1 == 60) {
					y1 = y1 + 15;
					x1 = x1 + 10;
					desenhaReta(x1, y1, x2, y2);
					System.out.println(x1 + ", " + y1);
					x1 = x1 + 5;
					
				} else if (x1 >= 80) {
					x1 = x1 + 10;
					
				} else if (x1 == 15 || x1 == 20 || x1 == 30) { 
					//repete x1 uma vez
					
					y1 = y1 + 15;
					desenhaReta(x1, y1, x2, y2);
					System.out.println(x1 + ", " + y1);
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
						System.out.println(x1 + ", " + y1 + ", " + y2);
						
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
						System.out.println(x1 + ", " + y1 + ", " + y2);
						
						z++;
					}
				}
			}
			
			if (j % 11 == 0) {
				desenhaReta(0, i, -y + 707, x);
				
//				desenhaReta(i, 0, x, -y + 707);
				i = i + 10;
			}
			
			j = j + 1;
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
				
				desenhaReta(x1, y1, x2, y2);		

			}
			
			i++;
		}
		
	}
	
	public static void main(String[] args) {
		Bresenham tarefa1 = new Bresenham();
		tarefa1.setTitle("Tarefa 1");
		Bresenham tarefa2 = new Bresenham();
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
		// AGORA VAI
//		tarefa2.desenhaReta(10, 80, 0, 650);
//		tarefa2.desenhaReta(15, 95, 0, 650);
//		
//		tarefa2.desenhaReta(15, 110, 0, 650);
//		tarefa2.desenhaReta(20, 125, 0, 650);
//		
//		tarefa2.desenhaReta(20, 140, 0, 650);
//		tarefa2.desenhaReta(25, 155, 0, 650);
//		tarefa2.desenhaReta(30, 170, 0, 650);
//		
//		tarefa2.desenhaReta(30, 185, 0, 650);
//		tarefa2.desenhaReta(35, 200, 0, 650);
//		tarefa2.desenhaReta(40, 215, 0, 650);
//		tarefa2.desenhaReta(45, 230, 0, 650);
//		tarefa2.desenhaReta(50, 245, 0, 650);
//		tarefa2.desenhaReta(55, 260, 0, 650);		
//		tarefa2.desenhaReta(60, 275, 0, 650);
//		
//		tarefa2.desenhaReta(70, 290, 0, 650);
//		tarefa2.desenhaReta(75, 305, 0, 650);
//		
//		tarefa2.desenhaReta(80, 320, 0, 650);		
//		tarefa2.desenhaReta(90, 335, 0, 650);
//		tarefa2.desenhaReta(100, 350, 0, 650);
//		tarefa2.desenhaReta(110, 365, 0, 650);
//		tarefa2.desenhaReta(120, 380, 0, 650);
//		tarefa2.desenhaReta(130, 395, 0, 650);
//		tarefa2.desenhaReta(140, 410, 0, 650);
//		tarefa2.desenhaReta(150, 425, 0, 650);
//		tarefa2.desenhaReta(160, 440, 0, 650);
//		tarefa2.desenhaReta(170, 455, 0, 650);
//		
//		tarefa2.desenhaReta(185, 470, 0, 750);
//		tarefa2.desenhaReta(200, 485, 0, 750);
//		tarefa2.desenhaReta(215, 500, 0, 750);
//		tarefa2.desenhaReta(230, 515, 0, 750);
//		
//		tarefa2.desenhaReta(245, 530, 0, 850);
//		tarefa2.desenhaReta(265, 545, 0, 850);
////		tarefa2.desenhaReta(275, 553, 0, 850);
//		tarefa2.desenhaReta(285, 560, 0, 850);
//		tarefa2.desenhaReta(305, 575, 0, 950);
		
	}
}
