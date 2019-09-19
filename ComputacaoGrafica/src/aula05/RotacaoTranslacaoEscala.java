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
		

//		g.drawLine(100, 50, 200, 50);
//		g.drawLine(200,50, 200,100);
//		g.drawLine(200,100, 100,100);
//		g.drawLine(100,100, 100,50);
	}
	
	//100,50		200,50
	//100,100		200,100
	
	//R 40º
	//T - T(50,100)
	//S - S(0.5, 2.0)
	
	
	public void rotacao(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		
		double cos = Math.cos(Math.toRadians(45));
		double sin = Math.sin(Math.toRadians(45));
		
		double x1L = (x1 * cos) - (y1 * sin);
		double y1L = (x1 * sin) + (y1 * cos);
		
		double x2L = (x2 * cos) - (y2 * sin);
		double y2L = (x2 * sin) + (y2 * cos);
		
		double x3L = (x3 * cos) - (y3 * sin);
		double y3L = (x3 * sin) + (y3 * cos);
		
		double x4L = (x4 * cos) - (y4 * sin);
		double y4L = (x4 * sin) + (y4 * cos);
		
		
		plot( (int)x1L, (int)y1L, (int)x2L, (int)y2L, (int)x3L, (int)y3L, (int)x4L, (int)y4L);
	}
	
	public void translacao(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		
		double tx1 = 50;
		double tx2 = 100;
		
		//Matriz
		double x1L = (x1 + tx1);
		double y1L = (y1 + tx2);
		
		double x2L = (x2 + tx1);
		double y2L = (y2 + tx2);
		
		double x3L = (x3 + tx1);
		double y3L = (y3 + tx2);
		
		double x4L = (x4 + tx1);
		double y4L = (y4 + tx2);
		
		plot( (int)x1L, (int)y1L, (int)x2L, (int)y2L, (int)x3L, (int)y3L, (int)x4L, (int)y4L);
		
	}
	
	public void escala(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		
		double s1 = 0.5;
		double s2 = 2.0;
		
		//Matriz
		double x1L = (x1 * s1);
		double y1L = (y1 * s2);
		
		double x2L = (x2 * s1);
		double y2L = (y2 * s2);
		
		double x3L = (x3 * s1);
		double y3L = (y3 * s2);
		
		double x4L = (x4 * s1);
		double y4L = (y4 * s2);
		
		
		plot( (int)x1L, (int)y1L, (int)x2L, (int)y2L, (int)x3L, (int)y3L, (int)x4L, (int)y4L);
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
		
		original.plot(200,100, 200,50, 100,50, 100,100);
		rotacao.rotacao(200,100, 200,50, 100,50, 100,100);
		translacao.translacao(200,100, 200,50, 100,50, 100,100);
		escala.escala(200,100, 200,50, 100,50, 100,100);	
	}
}
