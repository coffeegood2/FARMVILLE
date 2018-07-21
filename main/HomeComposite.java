package main;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
public class HomeComposite extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public HomeComposite(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		setLayout(new GridLayout(1, false));
		
		Label lblWelcomeToFarmotron = new Label(this, SWT.NONE);
		GridData gd_lblWelcomeToFarmotron = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblWelcomeToFarmotron.widthHint = 406;
		gd_lblWelcomeToFarmotron.heightHint = 76;
		lblWelcomeToFarmotron.setLayoutData(gd_lblWelcomeToFarmotron);
		lblWelcomeToFarmotron.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblWelcomeToFarmotron.setForeground(SWTResourceManager.getColor(255, 20, 147));
		lblWelcomeToFarmotron.setFont(SWTResourceManager.getFont("MS Sans Serif", 19, SWT.NORMAL));
		lblWelcomeToFarmotron.setText("Welcome to \r\nFARM-O-TRON 1000");
		
		Label lblByFarmvilleSoftware = new Label(this, SWT.NONE);
		lblByFarmvilleSoftware.setText("By FarmVille Software");
		lblByFarmvilleSoftware.setFont(SWTResourceManager.getFont("MS Sans Serif", 12, SWT.NORMAL));
		lblByFarmvilleSoftware.setAlignment(SWT.RIGHT);
		
		Label lblEnjoyYourStay = new Label(this, SWT.NONE);
		GridData gd_lblEnjoyYourStay = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblEnjoyYourStay.widthHint = 441;
		gd_lblEnjoyYourStay.heightHint = 227;
		lblEnjoyYourStay.setLayoutData(gd_lblEnjoyYourStay);
		lblEnjoyYourStay.setText("Requirements to run this soft-ware:\r\n-56k modem\r\n-3.5 inch floppy drive\r\n-Windows 95\r\n-America On-Line \r\n-Dot-Matrix printer for output");
		lblEnjoyYourStay.setForeground(SWTResourceManager.getColor(255, 20, 147));
		lblEnjoyYourStay.setFont(SWTResourceManager.getFont("MS Sans Serif", 18, SWT.NORMAL));
		lblEnjoyYourStay.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
