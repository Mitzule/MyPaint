package ro.uvt.desenare.data;

import java.awt.Color;
import java.awt.Graphics;

public class Dreptunghi extends Figura{

	public Dreptunghi(int x, int y, int w, int h, boolean fill, Color culoare) {
		super(x, y, w, h, fill, culoare);
	}

	@Override
	protected void draw(Graphics g) {
		if (super.fill) {
			g.fillRect(x,y,w,h);
		}else {
			g.drawRect(x,y,w,h);
		}
		
	}

}
