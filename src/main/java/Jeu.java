import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Jeu extends JPanel implements KeyListener {

	TableauDeJeu t1 = new TableauDeJeu();

	static Jeu nouveauJeu = new Jeu();

	static JFrame frame = new JFrame( "2048" );

	static Color green;

	String tableauDeJeu = t1.toString();


	public static void initGUI()
	{
		frame.addKeyListener( nouveauJeu );
		frame.getContentPane().add( nouveauJeu );
		frame.setSize( 600, 400);
		frame.setVisible( true );
		frame.setResizable( false );
	}

	@Override
	public void keyPressed ( KeyEvent e )
	{
		if ( e.getKeyChar() == 'z' || e.getKeyCode() == KeyEvent.VK_UP )
		{
			t1.monter();
			t1.generation();
			tableauDeJeu = t1.toString();
			frame.repaint();
		}
		else if ( e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN )
		{
			t1.descendre();
			t1.generation();
			tableauDeJeu = t1.toString();
			frame.repaint();
		}
		else if ( e.getKeyChar() == 'q' || e.getKeyCode() == KeyEvent.VK_LEFT )
		{
			t1.gauche();
			t1.generation();
			tableauDeJeu = t1.toString();
			frame.repaint();
		}
		else if ( e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT )
		{
			t1.droite();
			t1.generation();
			tableauDeJeu = t1.toString();
			frame.repaint();
		}
		else if ( e.getKeyCode() == KeyEvent.VK_ENTER )
		{
			t1 = new TableauDeJeu();
			t1.generation();
			t1.generation();
			frame.repaint();
		}
	}

	@Override
	public void keyReleased ( KeyEvent e )
	{
		//sert à rien mais nécessaire
	}

	@Override
	public void keyTyped ( KeyEvent e )
	{
		// sert à rien mais nécessaire
	}

	public void paint( Graphics g )
	{
		super.paint( g );
		Graphics2D g2 = (Graphics2D)g;
		g2.drawString( "2048", 250, 20 );
		g2.drawString( "Score: " + t1.getScore(),
				200 - 4 * String.valueOf( t1.getScore() ).length(),
				40 );
		g2.drawString( "Highest Tile: " + t1.getLeCarreeLePlusGros(),
				280 - 4 * String.valueOf( t1.getLeCarreeLePlusGros() ).length(),
				40 );
		g2.drawString( "Press 'Enter' to Start", 210, 315 );
		g2.drawString( "Use 'wasd' or Arrow Keys to move", 180, 335 );
		if ( t1.reset() )
		{
			g2.drawString( "Press 'Enter' to restart", 200, 355 );
		}
		g2.setColor( Color.gray );
		g2.fillRect( 140, 50, 250, 250 );
		for ( int i = 0; i < 4; i++ )
		{
			for ( int j = 0; j < 4; j++ )
			{
				drawTiles( g, t1.tableau[i][j], j * 60 + 150, i * 60 + 60 );
			}
		}
		if ( t1.partieTerminee() )
		{
			g2.setColor( Color.gray );
			g2.fillRect( 140, 50, 250, 250 );
			for ( int i = 0; i < 4; i++ )
			{
				for ( int j = 0; j < 4; j++ )
				{
					g2.setColor( Color.RED );
					g2.fillRoundRect( j * 60 + 150, i * 60 + 60, 50, 50, 5, 5 );
					g2.setColor( Color.black );
					g.drawString( "GAME", j * 60 + 160, i * 60 + 75 );
					g.drawString( "OVER", j * 60 + 160, i * 60 + 95 );
				}
			}
		}
	}

	public void drawTiles( Graphics g, Carree carree, int x, int y )
	{
		int tileValue = carree.getValeur();
		int length = String.valueOf( tileValue ).length();
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor( Color.lightGray );
		g2.fillRoundRect( x, y, 50, 50, 5, 5 );
		g2.setColor( Color.black );
		if ( tileValue > 0 )
		{
			g2.setColor( carree.getCouleur() );
			g2.fillRoundRect( x, y, 50, 50, 5, 5 );
			g2.setColor( Color.black );
			g.drawString( "" + tileValue, x + 25 - 3 * length, y + 25 );
		}
	}

















	public static void main(String[] args) {
		//TableauDeJeu t1 = new TableauDeJeu();
		//System.out.println(t1);
		initGUI();
	}

}
