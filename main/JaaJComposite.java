package main;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.dependencies.*;
import java.awt.image.*;

public class JaaJComposite extends Composite {
	private BufferedImage inputImage; // image to be modified
	private boolean haah, waaw, hooh, woow, one, two, three, turbo; // booleans to see which modes are checked
	private Label statusLabel; // console to see if your memes are ready to be pulled out of the oveen yet
	private String locazione, fileType; // location to save output and file type of input & output

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public JaaJComposite(Composite parent, int style) {
		super(parent, style);

		// vars
		locazione = fileType = null;
		haah = waaw = hooh = woow = one = two = three = turbo = false;

		setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		setLayout(new GridLayout(2, false));
		Label lblNewLabel = new Label(this, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 250;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblNewLabel.setFont(SWTResourceManager.getFont("MS Sans Serif", 24, SWT.BOLD));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblNewLabel.setText("JaaJTool v0.5");

		Label lblGuaranteedToMake = new Label(this, SWT.NONE);
		GridData gd_lblGuaranteedToMake = new GridData(SWT.CENTER, SWT.BOTTOM, false, false, 1, 1);
		gd_lblGuaranteedToMake.widthHint = 222;
		lblGuaranteedToMake.setLayoutData(gd_lblGuaranteedToMake);
		lblGuaranteedToMake.setText("Guaranteed to make you jaja(TM)");
		lblGuaranteedToMake.setFont(SWTResourceManager.getFont("MS Sans Serif", 10, SWT.NORMAL));
		lblGuaranteedToMake.setAlignment(SWT.CENTER);

		// Original Image Label
		Label label = new Label(this, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label.setText("Original Image:");
		label.setFont(SWTResourceManager.getFont("MS Sans Serif", 12, SWT.NORMAL));
		label.setAlignment(SWT.RIGHT);

		// Original Image Chooser Button
		Button chooseFile = new Button(this, SWT.NONE);
		chooseFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				one = true;
				File inputPath = FileOpener.openFile(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
				try {
					inputImage = ImageIO.read(inputPath);
					fileType = FileOpener.getExtension(inputPath.getName());
				} catch (IOException err) {
					err.printStackTrace();
				}
			}
		});
		GridData gd_chooseFile = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_chooseFile.widthHint = 133;
		gd_chooseFile.heightHint = 27;
		chooseFile.setLayoutData(gd_chooseFile);
		chooseFile.setText("Choose...");
		chooseFile.setFont(SWTResourceManager.getFont("MS Sans Serif", 9, SWT.NORMAL));

		// Effect chooser Label
		Label lblEffect = new Label(this, SWT.NONE);
		lblEffect.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblEffect.setText("Effect: (Clicc all that apply):");
		lblEffect.setFont(SWTResourceManager.getFont("MS Sans Serif", 12, SWT.NORMAL));
		lblEffect.setAlignment(SWT.RIGHT);

		// Effect chooser
		ToolBar toolBar = new ToolBar(this, SWT.FLAT | SWT.RIGHT);
		toolBar.setFont(SWTResourceManager.getFont("MS Sans Serif", 9, SWT.NORMAL));
		ToolItem tltmHaah = new ToolItem(toolBar, SWT.CHECK);
		tltmHaah.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				two = haah = true;
			}
		});
		tltmHaah.setText("HaaH");
		ToolItem tltmWaaw = new ToolItem(toolBar, SWT.CHECK);
		tltmWaaw.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				two = waaw = true;
			}
		});
		tltmWaaw.setText("WaaW");
		ToolItem tltmHooh = new ToolItem(toolBar, SWT.CHECK);
		tltmHooh.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				two = hooh = true;
			}
		});
		tltmHooh.setText("HooH");
		ToolItem tltmWoow = new ToolItem(toolBar, SWT.CHECK);
		tltmWoow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				two = woow = true;
			}
		});
		tltmWoow.setText("WooW");

		// Image Destination label
		Label lblWhereToSave = new Label(this, SWT.NONE);
		GridData gd_lblWhereToSave = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblWhereToSave.widthHint = 245;
		lblWhereToSave.setLayoutData(gd_lblWhereToSave);
		lblWhereToSave.setText("Where to save images:");
		lblWhereToSave.setFont(SWTResourceManager.getFont("MS Sans Serif", 12, SWT.NORMAL));
		lblWhereToSave.setAlignment(SWT.RIGHT);

		// Image destination chooser button
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				three = true;
				locazione = FileOpener.openFolder();
			}
		});
		GridData gd_button = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_button.widthHint = 132;
		button.setLayoutData(gd_button);
		button.setText("Choose...");
		button.setFont(SWTResourceManager.getFont("MS Sans Serif", 9, SWT.NORMAL));

		// TURBO MODE checkbox
		Button btnCheckButton = new Button(this, SWT.CHECK);
		btnCheckButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				toggleTurboMode();
			}
		});
		btnCheckButton.setFont(SWTResourceManager.getFont("MS Sans Serif", 11, SWT.NORMAL));
		GridData gd_btnCheckButton = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnCheckButton.widthHint = 285;
		btnCheckButton.setLayoutData(gd_btnCheckButton);
		btnCheckButton.setText("Turbo Mode (NOT Recommended)");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		// Go button
		Button btnGo = new Button(this, SWT.NONE);
		btnGo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// only initialize meming if all prior buttons have been clicked to prevent
				// error\s
				if (one && two && three)
					goPressed();
			}
		});
		GridData gd_btnGo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnGo.heightHint = 256;
		gd_btnGo.widthHint = 282;
		btnGo.setLayoutData(gd_btnGo);
		btnGo.setText("GO");
		btnGo.setFont(SWTResourceManager.getFont("MS Sans Serif", 9, SWT.NORMAL));

		// Console label
		statusLabel = new Label(this, SWT.NONE);
		statusLabel.setFont(SWTResourceManager.getFont("MS Sans Serif", 11, SWT.NORMAL));
		GridData gd_statusLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_statusLabel.widthHint = 298;
		statusLabel.setLayoutData(gd_statusLabel);
		statusLabel.setText("Doing nothing...");
		new Label(this, SWT.NONE);

	}

	protected void goPressed() {
		statusLabel.setText("Working...");
		int num = 1;
		if (turbo)
			num = 100;
		ImageFlipper flipper = new ImageFlipper(inputImage);
		if (waaw) {
			BufferedImage WaaW = flipper.WaaW();
			for (int i = 0; i < num; i++)
				FileOpener.save(WaaW, "WaaW", this.fileType, this.locazione);
		}
		if (haah) {
			BufferedImage HaaH = flipper.HaaH();
			for (int i = 0; i < num; i++)
				FileOpener.save(HaaH, "HaaH", this.fileType, this.locazione);
		}
		if (woow) {
			BufferedImage WooW = flipper.WooW();
			for (int i = 0; i < num; i++)
				FileOpener.save(WooW, "WooW", this.fileType, this.locazione);
		}
		if (hooh) {
			BufferedImage HooH = flipper.HooH();
			for (int i = 0; i < num; i++)
				FileOpener.save(HooH, "HooH", this.fileType, this.locazione);
		}
		statusLabel.setText("All files saved to: " + locazione);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	private void toggleTurboMode() {
		if (turbo)
			turbo = false;
		else
			turbo = true;
	}
}
