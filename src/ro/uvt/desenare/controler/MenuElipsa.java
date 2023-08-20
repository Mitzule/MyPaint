package ro.uvt.desenare.controler;

import javax.swing.JRadioButtonMenuItem;

import ro.uvt.desenare.data.AppInfo;

public class MenuElipsa extends JRadioButtonMenuItem implements Commander{
	public MenuElipsa() {
		this.setText("Elipsa");
		if (AppInfo.getInstance().isElipsa()) this.setSelected(true);
	}

	@Override
	public void execute() {
		if (this.isSelected()) {
			AppInfo.getInstance().setElipsa();
		}
		
	}

}
