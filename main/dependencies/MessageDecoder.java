package main.dependencies;
import java.awt.image.*;
import java.awt.*;
public class MessageDecoder {
	private BufferedImage original, altered;
	private int height, width;
	public MessageDecoder(BufferedImage original, BufferedImage altered) {
		this.original = original;
		this.altered = altered;
		this.height = original.getHeight();
		this.width = original.getWidth();
	}
	public String decode() {
		String word = "";
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x += 10) {
				if (original.getRGB(x, y) != altered.getRGB(x, y)) {
					Color pixel = new Color(altered.getRGB(x, y));
					char letter = (char)Math.abs(pixel.getGreen() - 255);
					word += letter;
				}
				else
					return word;
			}
		return word;
	}
}