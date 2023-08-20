package ro.uvt.desenare.controler;

import java.awt.Color;

import javax.sound.sampled.LineEvent.Type;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import ro.uvt.desenare.data.AppInfo;

public class MenuOpenSave extends JMenuItem implements Commander{

	private JFrame parent;
	public  enum TYPE {OPEN, SAVE};
	TYPE tip;
	
	public MenuOpenSave(JFrame parent,  TYPE type) {
		super();
		this.tip = type;
		this.parent = parent;
		if (tip == TYPE.OPEN) {
			setText("Deschide fis ...");
		}else {
			setText("Salveaza fis ...");
		}
	}
	
	@Override
	public void execute() {
		JFileChooser fc = new JFileChooser(".");
		if (tip == TYPE.OPEN) {
			int opt =  fc.showOpenDialog(this.parent);
			if (opt == JFileChooser.APPROVE_OPTION) {
				AppInfo.getInstance().openFile(fc.getSelectedFile());
				parent.repaint();
			}
		}else {
			int opt =  fc.showSaveDialog(this.parent);
			if (opt == JFileChooser.APPROVE_OPTION) {
				AppInfo.getInstance().saveFile(fc.getSelectedFile());
			}
		}
	}
}
