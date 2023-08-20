package ro.uvt.desenare.data;
import java.awt.Graphics;
import java.io.Serializable;
import java.awt.Color;

public abstract class Figura implements Serializable{
	
	protected int x, y, w, h;
	boolean fill;
	Color culoare;
	
	public Figura(int x, int y, int w, int h, boolean fill, Color culoare) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.fill = fill;
		this.culoare = culoare;
	}
	
	public void setInfo(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
	}
	
	
	public void desenare(Graphics g) {
		g.setColor(culoare);
		draw(g);
	}
	protected abstract void draw(Graphics g);

}
