package main.dependencies;
import java.awt.image.*;
import java.awt.Color;
public class MessageEncoder {
	private String msg;
	private BufferedImage img;
	private int height, width;
	public MessageEncoder(String msg, BufferedImage img) {
		this.msg = msg;
		this.height = img.getHeight();
		this.width = img.getWidth();
		this.img = img;
	}
	public BufferedImage encode() {
		int strPos = 0, lnt = msg.length();
		assert(lnt != 0 && lnt <= height * width);
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x += 10) {
				Color tileRGB = new Color(img.getRGB(x, y));
				int red = tileRGB.getRed(), green = (int)msg.charAt(strPos), blue = tileRGB.getBlue();
				Color col = new Color(red, green, blue);
				img.setRGB(x, y, col.getRGB());
				strPos++;
				if (strPos >= lnt)
					return this.img;
			}	
		return this.img;
	}
}
