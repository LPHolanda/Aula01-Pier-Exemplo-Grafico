import javax.swing.*;


//Solicitar valores de (x1, y1) e (x2,y2) e apresentar: {b, m}
public class Exercicio1 {

	public static void main(String[] args) {
//		double x1 = 10;
//		double y1 = 15;
//		double x2 = 18;
//		double y2 = 22;
		double x1 = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor para x1"));
		double y1 = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor para y1"));
		double x2 = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor para x2"));
		double y2 = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor para y2"));
		
		double m = (y2 - y1) / (x2 - x1) ;
		double b = y1 - (m * x1);   
		
		JOptionPane.showMessageDialog(null, "Valor do coeficiênte angular: " + m + 
				"\nValor do coeficiênte linear: " + b);
	}	
}
