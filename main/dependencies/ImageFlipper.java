package main.dependencies;
import java.awt.image.*;
public class ImageFlipper {
	private BufferedImage smee;
	private int width, height, type;
	public ImageFlipper(BufferedImage smee) {
		this.smee = smee;
		this.width = smee.getWidth();
		this.height = smee.getHeight();
		this.type = smee.getType();
	}
	//copy image
	public BufferedImage copy() {
		BufferedImage copy = new BufferedImage(width, height, type);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				copy.setRGB(x, y, smee.getRGB(x, y));
		return copy;
	}
	//copy right half to left half
	public BufferedImage WaaW() {
		BufferedImage waw = copy();
		for (int x = 0; x < width/2; x++)
			for (int y = 0; y < height; y++)
				waw.setRGB(x, y, smee.getRGB(width - 1 - x, y));
		return waw;
	}
	//copy left half to riught half
	public BufferedImage HaaH() {
		BufferedImage hah = copy();
		for (int x = 0; x < width/2; x++)
			for (int y = 0; y < height; y++)
				hah.setRGB(width - 1 -  x, y, smee.getRGB(x, y));
		return hah;
	}
	//copy bottom to top
	public BufferedImage HooH() {
		BufferedImage wow = copy();
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height/2; y++)
				wow.setRGB(x, y, smee.getRGB(x, height - 1 - y));
		return wow;
	}
	//copy bottom to top
	public BufferedImage WooW() {
		BufferedImage wow = copy();
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height/2; y++)
				wow.setRGB(x, height - 1 - y, smee.getRGB(x, y));
		return wow;
	}	
}
