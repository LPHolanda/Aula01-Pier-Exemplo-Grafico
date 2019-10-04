package atividadeA13;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TransformacoesGeometricas extends JFrame {
	private static final long serialVersionUID = 1L;

	public TransformacoesGeometricas() {
		setTitle("Atividade A13");
		setSize(600,600);
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
		TransformacoesGeometricas tg = new TransformacoesGeometricas();
		tg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// tempinho
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		};


		//triangulo do exercício (300,350, 250,300, 350,300, 300,350)

		int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantos vértices tem o seu poligono"));
		int pontos[] = new int[qtd*2+2];
		
		for(int i = 0; i < (qtd*2+2); i++) {
			if(i % 2 == 0) {
				int x = Integer.parseInt(JOptionPane.showInputDialog("Insira valor de x do seu poligono"));
				pontos[i] = x;
				
			} else {
				int y = Integer.parseInt(JOptionPane.showInputDialog("Insira valor de y do seu poligono"));
				pontos[i] = y;		
			}
		}
		
		tg.pontosDesenho(pontos);
	}
}
