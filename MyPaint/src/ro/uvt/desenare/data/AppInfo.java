package ro.uvt.desenare.data;
import java.awt.Color;
import java.util.LinkedList;
import  java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
public class AppInfo {
	
	private static AppInfo instance;
	
	private enum FIG_TYPE {ELIPSA, DREPTUNGHI};
	
	private FIG_TYPE tipFigura;
	private  boolean fill;
	private  Color culoare;
	
	private List<Figura> figs;
	
	private AppInfo() {
		tipFigura = FIG_TYPE.ELIPSA;
		this.fill = false;
		this.culoare = Color.RED;
		figs = new LinkedList<>();
		
	}

	public synchronized static AppInfo getInstance() {
		if (instance == null) {
			instance = new AppInfo();
		}
		return instance;
	}
	
	public void addFigura(Figura f) {
		this.figs.add(f);
	}
	
	public void desenare(Graphics g) {
		for(Figura f:figs) {
			f.desenare(g);
		}
	}
	
	public boolean isFill() {
		return this.fill == true;
	}
	
	public void setFill(boolean b) {
		this.fill = b;
	}
	
	public boolean isElipsa() {
		return this.tipFigura == FIG_TYPE.ELIPSA;
	}
	public boolean isDrepthunghi() {
		return this.tipFigura == FIG_TYPE.DREPTUNGHI;
	}
	
	public  void setDreptunghi() {
		this.tipFigura = FIG_TYPE.DREPTUNGHI;
	}
	
	public void setElipsa() {
		this.tipFigura = FIG_TYPE.ELIPSA;
	}
	
	public Figura createFigura(int x, int y) {
		if (this.isElipsa()) {
			return new Elipsa(x,y,1,1,fill, culoare);
		}else {
			return new Dreptunghi(x,y,1,1,fill, culoare);
		}
	}

	public Color getCuloare() {
		return culoare;
	}

	public void setCuloare(Color culoare) {
		this.culoare = culoare;
	}

	public void openFile(File selectedFile) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(selectedFile))){
			figs = (List<Figura>) ois.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public void saveFile(File selectedFile) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(selectedFile))){
			oos.writeObject( figs );
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
}
