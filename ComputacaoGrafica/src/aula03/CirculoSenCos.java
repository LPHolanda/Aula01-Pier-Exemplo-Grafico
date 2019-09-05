package aula03;

import java.awt.Graphics;

import javax.swing.JFrame;

public class CirculoSenCos extends JFrame {
	private static final long serialVersionUID = 1L;

	public CirculoSenCos() {
		setSize(500,500);
		setTitle("Círculo utilizando Seno e Cosceno");
		setVisible(true);
	}
	
	public void plot(int x, int y) {
		Graphics g = getGraphics();
		g.drawOval(x, y, 1, 1);
	}
	
	public void desenhaCirculo(int r) {
		
		int largura = 250, altura = 250;
		double x = 0, y = 0;
		int peta = 0;
		
		while(peta <= 45) {			
			y = r * Math.sin(Math.toRadians(peta));
			x = r * Math.cos(Math.toRadians(peta));
			
			plot((int)x + largura, (int)y + altura);
			plot((int)x + largura, (int)-y + altura);
			plot((int)-x + largura, (int)y + altura);
			plot((int)-x + largura, (int)-y + altura);
			plot((int)y + largura, (int)x + altura);
			plot((int)y + largura, (int)-x + altura);
			plot((int)-y + largura, (int)x + altura);
			plot((int)-y + largura, (int)-x + altura);
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println(e);
			};	
			
			
			peta++;
		}
	}
	
	public static void main(String[] args) {
		CirculoSenCos circulo = new CirculoSenCos();
		circulo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//tempinho
		try {
			Thread.sleep(100);
		} catch(Exception e) {
			System.out.println(e);
		};
		
		circulo.desenhaCirculo(200);
	}
}
