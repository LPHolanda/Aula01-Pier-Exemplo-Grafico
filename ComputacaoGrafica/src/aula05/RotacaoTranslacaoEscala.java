package aula05;

import java.awt.Graphics;

import javax.swing.JFrame;

public class RotacaoTranslacaoEscala extends JFrame {
	private static final long serialVersionUID = 1L;

	public RotacaoTranslacaoEscala() {
		setSize(600,600);
		setVisible(true);
	}
	
	public void plot(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		Graphics g = getGraphics();
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x2, y2, x3, y3);
		g.drawLine(x3, y3, x4, y4);
		g.drawLine(x4, y4, x1, y1);
	}
	
	public void plot2(int x1, int y1, int x2, int y2) {
		Graphics g = getGraphics();
		g.drawLine(x1, y1, x2, y2);
	}
	
	//100,50		200,50
	//100,100		200,100
	
	//R 40º
	//T - T(50,100)
	//S - S(0.5, 2.0)

	
	public void rotacao(int x1, int y1, int x2, int y2) {
		
		double cos = Math.cos(Math.toRadians(45));
		double sin = Math.sin(Math.toRadians(45));
		
		double x1L = (x1 * cos) - (y1 * sin);
		double y1L = (x1 * sin) + (y1 * cos);
		
		double x2L = (x2 * cos) - (y2 * sin);
		double y2L = (x2 * sin) + (y2 * cos);
		
		plot2( (int)x1L, (int)y1L, (int)x2L, (int)y2L);
	}
	
	public void translacao(int x1, int y1, int x2, int y2) {
		
		double tx1 = 50;
		double tx2 = 100;
		
		//Matriz
		double x1L = (x1 + tx1);
		double y1L = (y1 + tx2);
		
		double x2L = (x2 + tx1);
		double y2L = (y2 + tx2);
		
		plot2( (int)x1L, (int)y1L, (int)x2L, (int)y2L);
		
	}
	
	public void escala(int x1, int y1, int x2, int y2) {
		
		double s1 = 0.5;
		double s2 = 2.0;
		
		//Matriz
		double x1L = (x1 * s1);
		double y1L = (y1 * s2);
		
		double x2L = (x2 * s1);
		double y2L = (y2 * s2);
		
		plot2( (int)x1L, (int)y1L, (int)x2L, (int)y2L);
	}
	
	
	public void pontosDesenho (int[] pontos, String processo) {
		
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
				
				if (processo.equals("r")) {
					rotacao(x1, y1, x2, y2);		
					
				} else if (processo.equals("t")) {
					translacao(x1, y1, x2, y2);
					
				} else if (processo.equals("s")) {
					escala(x1, y1, x2, y2);
				}
			}
			
			i++;
		}
		
	}
	
	
	public static void main(String[] args) {
		RotacaoTranslacaoEscala original = new RotacaoTranslacaoEscala();
		original.setTitle("Desenho Original");
		RotacaoTranslacaoEscala rotacao = new RotacaoTranslacaoEscala();
		rotacao.setTitle("Rotação");
		RotacaoTranslacaoEscala translacao = new RotacaoTranslacaoEscala();
		translacao.setTitle("Translação");
		RotacaoTranslacaoEscala escala = new RotacaoTranslacaoEscala();
		escala.setTitle("Escala");
		
		original.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rotacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		translacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		escala.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// tempinho
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		};
		
		int[] pontos = {200,100, 200,50, 100,50, 100,100, 200,100};
		
		original.plot(200,100, 200,50, 100,50, 100,100);
		rotacao.pontosDesenho(pontos, "r");
		translacao.pontosDesenho(pontos, "t");
		escala.pontosDesenho(pontos, "s");	
	}
}
