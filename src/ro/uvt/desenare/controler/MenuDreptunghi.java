package ro.uvt.desenare.controler;

import javax.swing.JRadioButtonMenuItem;

import ro.uvt.desenare.data.AppInfo;

public class MenuDreptunghi extends JRadioButtonMenuItem implements Commander{
	public MenuDreptunghi() {
		this.setText("Dreptunghi");
		if (AppInfo.getInstance().isDrepthunghi()) this.setSelected(true);
	}

	@Override
	public void execute() {
		if (this.isSelected()) {
			AppInfo.getInstance().setDreptunghi();
		}
		
	}

}
