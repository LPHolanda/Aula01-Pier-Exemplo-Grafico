import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Exercicio2 extends JFrame {

	public Exercicio2() {
		setSize(800, 600);
		setTitle("Exemplo");
		setVisible(true);
	}

	public void plot(int x1, int y1, int x2, int y2) {
		Graphics g = getGraphics();
		g.drawLine(x1, y1, x2, y2);
//		g.drawOval(x, y, 1, 1);
	}

	public void desenha() {
		Graphics g = getGraphics();
		
//		int x1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para x1"));
//		int y1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para y1"));
//		int x2 = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para x2"));
//		int y2 = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para y2"));
		int x1 = 10;
		int y1 = 15;
		int x2 = 18;
		int y2 = 22;

		int m = (y2 - y1) / (x2 - x1);
		int b = y1 - (m * x1);
		
		int x = x1; 
		while (x <= x2) {
			int y = m * x + b;
			plot(x1, y1, x2, y2);
		}
	}

	public static void main(String args[]) {
		Exercicio2 p = new Exercicio2();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// tempinho
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		};

		p.desenha();
	}
}
