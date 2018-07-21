package main;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.dependencies.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MessagesComposite extends Composite {
	private Text text;
	private BufferedImage encodeOriginal, decodeOriginal, decodeAltered;
	private boolean decodeOne, decodeTwo, encodeOne, encodeTwo;
	private String locazione, fileType;
	private Label lblDoingNothing;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public MessagesComposite(Composite parent, int style) {
		super(parent, style);
		decodeOne = decodeTwo = encodeOne = encodeTwo = false;
		locazione = fileType = null;

		setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		setLayout(new GridLayout(5, false));

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblNewLabel.setFont(SWTResourceManager.getFont("MS Sans Serif", 19, SWT.NORMAL));
		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 200;
		gd_lblNewLabel.heightHint = 41;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setText("Hidden Messages\r\n");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		Label lblEmbed = new Label(this, SWT.NONE);
		lblEmbed.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblEmbed.setFont(SWTResourceManager.getFont("MS Sans Serif", 15, SWT.NORMAL));
		lblEmbed.setText("Embed");
		new Label(this, SWT.NONE);

		Label label = new Label(this, SWT.SEPARATOR | SWT.VERTICAL);
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 5);
		gd_label.heightHint = 396;
		label.setLayoutData(gd_label);

		// decode button label
		Label lblDecode = new Label(this, SWT.NONE);
		lblDecode.setAlignment(SWT.CENTER);
		GridData gd_lblDecode = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblDecode.widthHint = 142;
		lblDecode.setLayoutData(gd_lblDecode);
		lblDecode.setText("Decode");
		lblDecode.setFont(SWTResourceManager.getFont("MS Sans Serif", 15, SWT.NORMAL));
		new Label(this, SWT.NONE);

		// Original image choose button
		Label lblOriginalImage = new Label(this, SWT.NONE);
		GridData gd_lblOriginalImage = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblOriginalImage.heightHint = 23;
		gd_lblOriginalImage.widthHint = 106;
		lblOriginalImage.setLayoutData(gd_lblOriginalImage);
		lblOriginalImage.setAlignment(SWT.RIGHT);
		lblOriginalImage.setText("Original Image:");
		lblOriginalImage.setFont(SWTResourceManager.getFont("MS Sans Serif", 12, SWT.NORMAL));

		// ENCODE CHOOSE image butTOn
		Button btnChoose = new Button(this, SWT.NONE);
		btnChoose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				encodeOne = true;
				try {
					File origFile = FileOpener
							.openFile(new FileNameExtensionFilter("Lossless Image files", "PNG", "TIFF", "TIF"));
					fileType = FileOpener.getExtension(origFile.toString());
					encodeOriginal = ImageIO.read(origFile);
				} catch (IOException err) {
					err.printStackTrace();
				}
			}
		});
		btnChoose.setFont(SWTResourceManager.getFont("MS Sans Serif", 9, SWT.NORMAL));
		GridData gd_btnChoose = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnChoose.widthHint = 52;
		btnChoose.setLayoutData(gd_btnChoose);
		btnChoose.setText("Choose...");

		// ENCODE Original image choose label
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_1.setText("Original Image:");
		label_1.setFont(SWTResourceManager.getFont("MS Sans Serif", 12, SWT.NORMAL));
		label_1.setAlignment(SWT.RIGHT);

		// DECODE Choose Original Image button
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				decodeOne = true;
				try {
					decodeOriginal = ImageIO.read(FileOpener
							.openFile(new FileNameExtensionFilter("Lossless Image files", "PNG", "TIFF", "TIF")));
				} catch (IOException err) {
					err.printStackTrace();
				}
			}
		});
		button.setFont(SWTResourceManager.getFont("MS Sans Serif", 9, SWT.NORMAL));
		button.setText("Choose...");

		// ENCODE chooseoutputfolder label
		Label lblOutputLocation = new Label(this, SWT.NONE);
		GridData gd_lblOutputLocation = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblOutputLocation.heightHint = 18;
		lblOutputLocation.setLayoutData(gd_lblOutputLocation);
		lblOutputLocation.setText("Output Location:");
		lblOutputLocation.setFont(SWTResourceManager.getFont("MS Sans Serif", 12, SWT.NORMAL));
		lblOutputLocation.setAlignment(SWT.RIGHT);

		// ENCODE choose output folder
		Button button_2 = new Button(this, SWT.NONE);
		GridData gd_button_2 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_button_2.widthHint = 46;
		button_2.setLayoutData(gd_button_2);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				encodeTwo = true;
				locazione = FileOpener.openFolder();
			}
		});
		button_2.setText("Choose...");
		button_2.setFont(SWTResourceManager.getFont("MS Sans Serif", 9, SWT.NORMAL));

		// DECODE choose second image label
		Label lblAlteredImage = new Label(this, SWT.NONE);
		lblAlteredImage.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAlteredImage.setText("Altered Image:");
		lblAlteredImage.setFont(SWTResourceManager.getFont("MS Sans Serif", 12, SWT.NORMAL));
		lblAlteredImage.setAlignment(SWT.RIGHT);

		// DECODE Choose second image button
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				decodeTwo = true;
				try {
					decodeAltered = ImageIO.read(FileOpener
							.openFile(new FileNameExtensionFilter("Lossless Image files", "PNG", "TIFF", "TIF")));
				} catch (IOException err) {
					err.printStackTrace();
				}
			}
		});
		button_1.setFont(SWTResourceManager.getFont("MS Sans Serif", 9, SWT.NORMAL));
		button_1.setText("Choose...");

		// label above tyext box
		Label lblMessageToEncode = new Label(this, SWT.NONE);
		lblMessageToEncode.setText("Message to Encode:");
		lblMessageToEncode.setFont(SWTResourceManager.getFont("MS Sans Serif", 12, SWT.NORMAL));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		// text box
		text = new Text(this, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		text.setFont(SWTResourceManager.getFont("MS Sans Serif", 9, SWT.NORMAL));
		GridData gd_text = new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1);
		gd_text.widthHint = 281;
		gd_text.heightHint = 269;
		text.setLayoutData(gd_text);

		// ENCODE button
		Button btnEncode = new Button(this, SWT.NONE);
		btnEncode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (encodeOne && encodeTwo && text.getText().length() > 0) {
					lblDoingNothing.setText("Encoding Image...");
					encodeImage();
					messagePop("Encoded image saved to: " + locazione, "Message Encoded");
					lblDoingNothing.setText("Doing nothing...");
				}
			}
		});
		GridData gd_btnEncode = new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1);
		gd_btnEncode.widthHint = 45;
		gd_btnEncode.heightHint = 44;
		btnEncode.setLayoutData(gd_btnEncode);
		btnEncode.setText("Encode");
		btnEncode.setFont(SWTResourceManager.getFont("MS Sans Serif", 9, SWT.NORMAL));

		// decoded message label
		Label lblDecodedMessage = new Label(this, SWT.WRAP);
		lblDecodedMessage.setFont(SWTResourceManager.getFont("MS Sans Serif", 7, SWT.NORMAL));
		GridData gd_lblDecodedMessage = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_lblDecodedMessage.heightHint = 276;
		gd_lblDecodedMessage.widthHint = 150;
		lblDecodedMessage.setLayoutData(gd_lblDecodedMessage);
		lblDecodedMessage.setText("Decoded Message: ");

		// DECODE button
		Button btnDecode = new Button(this, SWT.NONE);
		btnDecode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (decodeTwo && decodeOne) {
					lblDoingNothing.setText("Decoding Message...");
					decodeTwo = decodeOne = false;
					String message = decodeImage();
					lblDecodedMessage.setText("Decoded Message: " + message);
					lblDoingNothing.setText("Doing nothing...");
				}
			}
		});
		btnDecode.setFont(SWTResourceManager.getFont("MS Sans Serif", 9, SWT.NORMAL));
		GridData gd_btnDecode = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_btnDecode.heightHint = 43;
		btnDecode.setLayoutData(gd_btnDecode);
		btnDecode.setText("Decode");

		lblDoingNothing = new Label(this, SWT.NONE);
		GridData gd_lblDoingNothing = new GridData(SWT.LEFT, SWT.CENTER, false, false, 5, 1);
		gd_lblDoingNothing.widthHint = 235;
		lblDoingNothing.setLayoutData(gd_lblDoingNothing);
		lblDoingNothing.setText("Doing nothing...");

	}

	// p0p-oop with decoded msg
	private void messagePop(String message, String header) {
		JOptionPane.showMessageDialog(null, message, header, JOptionPane.OK_OPTION);
	}

	private String decodeImage() {
		MessageDecoder decoder = new MessageDecoder(decodeOriginal, decodeAltered);
		return decoder.decode();
	}

	private void encodeImage() {
		MessageEncoder encoder = new MessageEncoder(text.getText(), encodeOriginal);
		FileOpener.save(encoder.encode(), "message", this.fileType, locazione);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
