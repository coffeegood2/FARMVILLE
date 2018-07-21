package main.dependencies;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
public class FileOpener {
	public static String openFolder() {
		String outputPath = null;
		JFileChooser bowser = new JFileChooser();
		bowser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		bowser.setAcceptAllFileFilterUsed(false);
		while (outputPath == null) {
	    	int num = bowser.showDialog(null, "JaJaJa");
	    	if (num == JFileChooser.APPROVE_OPTION)
	    		outputPath = bowser.getSelectedFile().toString();
		}
	    return outputPath;
	}
	public static File openFile(FileFilter filter) {
		File inputPath = null;
		JFileChooser bowser = new JFileChooser();
		bowser.addChoosableFileFilter(filter);
		bowser.setAcceptAllFileFilterUsed(false);
		while (inputPath == null) {
			int num = bowser.showDialog(null, "JaJaJa");
			if(num == JFileChooser.APPROVE_OPTION)
				inputPath = bowser.getSelectedFile();
		}
		return inputPath;
	}
	public static void save(BufferedImage img, String type, String fileType, String directory) {
		File output = new File(directory + "/" + type + "_" + Math.random() * 10000000 + 1 + "." + fileType);
		try {
			ImageIO.write(img, fileType, output);
		} catch (IOException err) {
			err.printStackTrace();
		}	
	}
	public static String getExtension(String fileName) throws IllegalArgumentException {
        if (fileName != null)
        	return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        throw new IllegalArgumentException();
    }
}