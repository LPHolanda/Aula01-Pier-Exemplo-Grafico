package aula06;

import java.awt.Graphics;

import javax.swing.JFrame;

/*
 * Calcular e executar a rotação de 30° de um triângulo em relação ao seu centro.
 * (mostrar figura original e a transformada)
 * */

public class ExercicioRotacao extends JFrame {

	public ExercicioRotacao() {
		setSize(600,600);
		setVisible(true);
	}
	
	public void plot(int x1, int y1, int x2, int y2) {
		Graphics g = getGraphics();
		g.drawLine(x1, y1, x2, y2);
	}
	
	public void desenhaTriangulo(int x1, int y1, int x2, int y2, int x3, int y3) {
		plot(x1, y1, x2, y2);
	}
	
	public void rotacao(int x1, int y1, int x2, int y2, int x3, int y3) {
		double sen = Math.sin(Math.toRadians(30));
		double cos = Math.cos(Math.toRadians(30));
		
		int cx = (x1 + x2 + x3) / 3;
		int cy = (y1 + y2 + y3) / 3;
		
		double xL1 = x1 * cos - y1 * sen + cx - cx * cos + cy * sen;
		double yL1 = x1 * sen + y1 * cos + cy - cx * sen - cy * cos;
		
		double xL2 = x2 * cos - y2 * sen + cx - cx * cos + cy * sen;
		double yL2 = x2 * sen + y2 * cos + cy - cx * sen - cy * cos;
		
		double xL3 = x3 * cos - y3 * sen + cx - cx * cos + cy * sen;
		double yL3 = x3 * sen + y3 * cos + cy - cx * sen - cy * cos;
		
		plot(x1, y1, x2, y2);
		plot(x2, y2, x3, y3);
		plot(x3, y3, x1, y1);
		
		plot((int)xL1, (int)yL1, (int)xL2, (int)yL2);
		plot((int)xL2, (int)yL2, (int)xL3, (int)yL3);
		plot((int)xL3, (int)yL3, (int)xL1, (int)yL1);
	}
	
	public static void main(String[] args) {
		ExercicioRotacao original = new ExercicioRotacao();
		original.setTitle("Desenho Original");
		ExercicioRotacao rotacao = new ExercicioRotacao();
		rotacao.setTitle("Rotação");
		
		original.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rotacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// tempinho
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		};
		
		rotacao.rotacao(100,200, 200,200, 150,150);
	}
}
