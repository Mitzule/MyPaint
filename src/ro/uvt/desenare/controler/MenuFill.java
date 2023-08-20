package ro.uvt.desenare.controler;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;

import ro.uvt.desenare.data.AppInfo;

public class MenuFill extends JCheckBoxMenuItem implements  Commander{
	
	public MenuFill() {
		super();
		setText("Fill");
		if (AppInfo.getInstance().isFill()) this.setSelected(true);
	}

	@Override
	public void execute() {
		AppInfo.getInstance().setFill(this.isSelected());
	}

}
