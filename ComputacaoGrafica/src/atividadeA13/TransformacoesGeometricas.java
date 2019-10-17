package atividadeA13;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Professor Pier
 * Leandro Pinheiro de Holanda	816113762
 */

public class TransformacoesGeometricas extends JFrame {
	private static final long serialVersionUID = 1L;

	public int[] pontos;
	int[] auxPontos;
	boolean primeiraVez = false;
	private boolean translacao=false, rotacao=false, escala=false;
	private double raio = 1;
	private double sx = 1;
	private double sy = 1;
	
	public TransformacoesGeometricas(int[] pontos, int[] auxPontos) {
		Graphics g = null;
		setTitle("Atividade A13");
		setSize(600,600);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);

		this.pontos = pontos;
		this.auxPontos = auxPontos;
		for (int i = 0; i < this.pontos.length; i++) {
			this.auxPontos[i] = auxPontos[i];
		}
		
        KeyListener listener = new KeyListener() {
				
			public void keyTyped(KeyEvent e) {}
		
			public void keyPressed(KeyEvent e) {
//				System.out.println("Tecla: " + KeyEvent.getKeyText(e.getKeyCode()));
//		        System.out.println("Tecla:  "+ e.getKeyCode());
				
		        int captura = e.getKeyCode();
		
		        if (captura == 84) {
		        	translacao = true;
		        	rotacao = false;
		        	escala = false;
		        	primeiraVez = true;
		        } else if (captura == 82) {
		        	raio = 1;
		        	rotacao = true;
		        	translacao = false;
		        	escala = false;
		        	primeiraVez = true;
		        } else if (captura == 83) {
		        	sx = 1;
		        	sy = 1;
		        	escala = true;
		        	translacao = false;
		        	rotacao = false;
		        	primeiraVez = true;
		        }
		        
		        if(translacao) {
			        switch(captura) {
			            case 40: // move para baixo
			                mudaY(pontos, 40, g);
			                break;
			            case 38: // move para cima
			            	mudaY(pontos, 38, g);
			                break;
			            case 37: // move para esquerda
			            	mudaX(pontos, 37, g);
			                break;
			            case 39: // move para direita
			            	mudaX(pontos, 39, g);
			                break;
			        }
			        repaint();
			        
		        } else if (rotacao) {
		        	if(primeiraVez) {
		        		for(int i = 0; i < auxPontos.length; i++ ) {
		        			auxPontos[i] = pontos[i];
		        		}
		        		
		        		primeiraVez = false;
		        	}
		        	switch(captura) {
			            case 37: // move para esquerda
			            	rotacao(pontos, 37, g);
			                break;
			            case 39: // move para direita
			            	rotacao(pontos, 39, g);
			                break;
			        }
			        repaint();
		        	
		        } else if (escala) {
		        	if(primeiraVez) {
		        		for(int i = 0; i < auxPontos.length; i++ ) {
		        			auxPontos[i] = pontos[i];
		        		}
		        		
		        		primeiraVez = false;
		        	}
		        	switch(captura) {
			            case 40: // move para baixo
			            	escala(pontos, 40, g);
			                break;
			            case 38: // move para cima
			            	escala(pontos, 38, g);
			                break;
			        }
			        repaint();
		        }
			}
		
			public void keyReleased(KeyEvent e) {}
		
		};
		addKeyListener(listener);
		setFocusable(true);
	}
	
	public void mudaX(int[] pontos, int tecla, Graphics g) {
		for (int i = 0; i < pontos.length; i ++) {
			if (i % 2 == 0) {
				if(tecla == 39) {
					pontos[i] = pontos[i] + 1;
					auxPontos[i] = auxPontos[i] + 1; 
				} else {
					pontos[i] = pontos[i] - 1;
					auxPontos[i] = auxPontos[i] - 1; 
				}
			}
		}
	}
	
	public void mudaY(int[] pontos, int tecla, Graphics g) {
		for (int i = 0; i < pontos.length; i ++) {
			if (i % 2 != 0) {
				if(tecla == 40) {
					pontos[i] = pontos[i] + 1;
					auxPontos[i] = auxPontos[i] + 1; 
				} else {
					pontos[i] = pontos[i] - 1;
					auxPontos[i] = auxPontos[i] - 1; 
				}
			}
		}
	}
	
	public void plot(int x1, int y1, Graphics g) {
		g = getGraphics();
		g.drawOval(x1, y1, 1, 1);
	}
	
	public void plot2(int x1, int y1, int x2, int y2, Graphics g) {
		super.paint(g);
		g = getGraphics();
		g.drawLine(x1, y1, x2, y2);
	}
	
	public void paint(Graphics g) {
        super.paint(g);
        desenharPoligono(pontos, g);
    }
	
	public void desenhaLinha(int x1, int y1, int x2, int y2, Graphics g) {
		
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
			
			plot( (int)x, (int)y, g);
		}
		
	}
	
	
	public void rotacao(int[] pontos, int tecla, Graphics g) {
		
		for(int i = 0; i < this.auxPontos.length; i++ ) {
			pontos[i] = auxPontos[i];
		}
		
		double sen;
		double cos;		
		
		if(tecla == 37) {
			sen = Math.sin(Math.toRadians(raio));
			cos = Math.cos(Math.toRadians(raio));	
			raio = raio + 1;
		} else {
			sen = Math.sin(Math.toRadians(raio));
			cos = Math.cos(Math.toRadians(raio));
			raio = raio - 1;
		}
		
		int cx = 0;
		int cy = 0;
		int x = 0;
		int y = 0;
		int j = 0;
		
		for(int i = 0; i < pontos.length; i++) {
			if (i % 2 == 0) {
				cx = cx + pontos[i];
				
			} else {
				cy = cy + pontos[i];
			}
		}
		
		cx = cx / (pontos.length / 2);
		cy = cy / (pontos.length / 2);
		
		for(int i = 0; i < pontos.length; i++) {
			if (i % 2 == 0) {
				x = pontos[i];
			} else {
				y = pontos[i];
				double xL = x * cos - y * sen + cx - cx * cos + cy * sen;
				double yL = x * sen + y * cos + cy - cx * sen - cy * cos;
				j = i - 1;
				
				pontos[j] = (int)xL;
				pontos[i] = (int)yL;
			}
		}
	}
	
	public void escala(int[] pontos, int tecla, Graphics g) {
		
		for(int i = 0; i < this.auxPontos.length; i++ ) {
			pontos[i] = auxPontos[i];
		}
		
		int cx = 0;
		int cy = 0;
		int x = 0;
		int y = 0;
		int j = 0;
		
		if(tecla == 38) {
			sx = sx + 0.01;
			sy = sy + 0.01;
		} else {
			sx = sx - 0.01;
			sy = sy - 0.01;
		}
		
		for(int i = 0; i < pontos.length; i++) {
			if (i % 2 == 0) {
				cx = cx + pontos[i];
				
			} else {
				cy = cy + pontos[i];
			}
		}
		
		cx = cx / (pontos.length / 2);
		cy = cy / (pontos.length / 2);
		
		for(int i = 0; i < pontos.length; i++) {
			if (i % 2 == 0) {
				x = pontos[i];
			} else {
				y = pontos[i];
				double xL = (-cx * sx) + cx + (x * sx);
				double yL = (-cy * sy) + cy + (y * sy);
				j = i - 1;
				
				pontos[j] = (int)xL;
				pontos[i] = (int)yL;
			}
		}
	}
	
	
	public void desenharPoligono (int[] pontos, Graphics g) {
		
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
				
				desenhaLinha(x1, y1, x2, y2, g);
			}
			
			i++;
		}
		
	}
	
	
	
	public static void main(String[] args) {		
		Graphics g = null;
		
		// tempinho
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		};


		//triangulo do exercício (300,350, 250,300, 350,300, 300,350)

		int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantos vértices tem o seu poligono"));
		int pontos[] = new int[qtd*2+2];
		int auxPontos[] = new int[qtd*2+2];
		
		for(int i = 0; i < (qtd*2+2); i++) {
			if(i % 2 == 0) {
				int x = Integer.parseInt(JOptionPane.showInputDialog("Insira valor de x do seu poligono"));
				pontos[i] = x;
				
			} else {
				int y = Integer.parseInt(JOptionPane.showInputDialog("Insira valor de y do seu poligono"));
				pontos[i] = y;		
			}
		}
		
		for (int i = 0; i < pontos.length; i++) {
			auxPontos[i] = pontos[i];
		}
		
		TransformacoesGeometricas tg = new TransformacoesGeometricas(pontos, auxPontos);
		tg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tg.desenharPoligono(pontos, g);
	}
}
