package main.dependencies;
import java.awt.image.*;
import java.awt.Color;
public class MessageEncoder {
	private String msg;
	private Color[][] pixels;
	private int height, width, type;
	public MessageEncoder(String msg, BufferedImage img) {
		this.msg = msg;
		this.height = img.getHeight();
		this.width = img.getWidth();
		this.pixels = buildArray(img);
		this.type = img.getType();
	}
	//redundant to change it into color array and back, but i wrote this before i knew bufferedimages were mutable
	public Color[][] buildArray(BufferedImage img) {
		Color[][] smee = new Color[height][width];
		for (int r = 0; r < height; r++)
			for (int c = 0; c < width; c++)
				smee[r][c] = new Color(img.getRGB(c, r));
		return smee;
	}
	public BufferedImage encode() {
		int r = 0, c = 0, strPos = 0, lnt = msg.length();
		while (strPos < lnt) {
			int newGreenValue = 255 - (int)msg.charAt(strPos);
			pixels[r][c] = new Color(pixels[r][c].getRed(), newGreenValue, pixels[r][c].getBlue());
			strPos++;
			c += 10;
			if (c > pixels[0].length) {
				r++;
				c = 0;
			}
		}
		return buildImage();
	}
	private BufferedImage buildImage() {
		BufferedImage output = new BufferedImage(width, height, type);
		for (int c = 0; c < width; c++)
			for (int r = 0; r < height; r++)
				output.setRGB(c, r, pixels[r][c].getRGB());
		return output;
	}
}
