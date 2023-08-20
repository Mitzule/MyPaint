package ro.uvt.desenare.controler;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

import ro.uvt.desenare.data.AppInfo;

public class MenuCuloare extends JMenuItem implements Commander{

	private JFrame parent;
	
	public MenuCuloare(JFrame parent) {
		super();
		this.setText("Culoare");;
		this.parent = parent;
	}
	
	@Override
	public void execute() {
		Color c = JColorChooser.showDialog(parent, "Alege culoare", AppInfo.getInstance().getCuloare());
		AppInfo.getInstance().setCuloare(c);;
	}

}
