package ro.uvt.desenare.data;

import java.awt.Color;
import java.awt.Graphics;

public class Elipsa extends Figura{

	public Elipsa(int x, int y, int w, int h, boolean fill, Color culoare) {
		super(x, y, w, h, fill, culoare);
		
	}

	@Override
	protected void draw(Graphics g) {
		if (super.fill) {
			g.fillOval(x,y,w,h);
		}else {
			g.drawOval(x,y,w,h);
		}
		
	}

}
