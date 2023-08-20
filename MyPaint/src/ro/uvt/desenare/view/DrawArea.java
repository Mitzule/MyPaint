package ro.uvt.desenare.view;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import ro.uvt.desenare.data.AppInfo;
import ro.uvt.desenare.data.Figura;

import java.awt.Graphics;

public class DrawArea extends JPanel implements MouseInputListener{
	
	int startx, starty, stopx, stopy;
	private Figura fig= null;
	
	public DrawArea() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		AppInfo.getInstance().desenare(g);
		
		if (fig!= null) {
			fig.desenare(g);
		}
		
		System.out.println("paint");
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.startx = e.getX();
		this.starty = e.getY();
		fig  = AppInfo.getInstance().createFigura(startx, starty);
		repaint();
		System.out.println("presed");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.stopx = e.getX();
		this.stopy = e.getY();
		
		modificaDreptDesenare();
		AppInfo.getInstance().addFigura(fig);
		this.repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.stopx = e.getX();
		this.stopy = e.getY();
		modificaDreptDesenare();
		this.repaint();
		
	}
	
	
	private void modificaDreptDesenare() {
		int x = startx < stopx? startx : stopx;
		int y = starty < stopy? starty : stopy;
		int h = Math.abs(starty-stopy);
		int w =  Math.abs(startx-stopx);
		
		fig.setInfo(x, y, w, h);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
