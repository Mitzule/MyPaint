package ro.uvt.desenare.view;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ro.uvt.desenare.controler.Commander;
import ro.uvt.desenare.controler.MenuCuloare;
import ro.uvt.desenare.controler.MenuDreptunghi;
import ro.uvt.desenare.controler.MenuElipsa;
import ro.uvt.desenare.controler.MenuFill;
import ro.uvt.desenare.controler.MenuOpenSave;

public class MyPaint extends JFrame{

	public MyPaint() {
		super();
		this.setTitle("My Paint");
		
		buildMenu();
		this.setPreferredSize(new Dimension(700, 500));
		
		
		this.add(new DrawArea());
		this.pack();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}

	private void buildMenu() {
		JMenuBar bar = new JMenuBar();
		
		JMenu mFile = new JMenu("File");
		JMenuItem mSave = new MenuOpenSave(this, MenuOpenSave.TYPE.SAVE);
		mSave.addActionListener((e)->{Commander c= (Commander) e.getSource(); c.execute();});
		mFile.add(mSave);
		
		JMenuItem mOpen = new MenuOpenSave(this, MenuOpenSave.TYPE.OPEN);
		mOpen.addActionListener((e)->{Commander c= (Commander) e.getSource(); c.execute();});
		mFile.add(mOpen);
		
		
		bar.add(mFile);
		
		JMenu mFiguri = new JMenu("Figuri");
		JMenuItem mElipsa = new MenuElipsa();
		mElipsa.addActionListener((e)->{Commander c= (Commander) e.getSource(); c.execute();});
		mFiguri.add(mElipsa);
		
		JMenuItem mDerpt = new MenuDreptunghi();
		mDerpt.addActionListener((e)->{Commander c= (Commander) e.getSource(); c.execute();});
		mFiguri.add(mDerpt);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(mDerpt);
		bg.add(mElipsa);
		
		bar.add(mFiguri);
		
		
		
		JMenu mProprietati = new JMenu("Proprietati");
		JMenuItem mFill = new MenuFill();
		mFill.addActionListener((e)->{Commander c= (Commander) e.getSource(); c.execute();});
		mProprietati.add(mFill);
		
		JMenuItem mCuloare = new MenuCuloare(this);
		mCuloare.addActionListener((e)->{Commander c= (Commander) e.getSource(); c.execute();});
		mProprietati.add(mCuloare);
		
	
		
		bar.add(mProprietati);
		
		this.setJMenuBar(bar);
		
	}
}
