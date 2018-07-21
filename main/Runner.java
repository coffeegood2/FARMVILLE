package main;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class Runner {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Runner window = new Runner();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(758, 650);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBounds(5, 5, 619, 559);
		tabFolder.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		
		TabItem tbtmHome = new TabItem(tabFolder, SWT.NONE);
		tbtmHome.setText("Home");
		
		HomeComposite homeComposite = new HomeComposite(tabFolder, SWT.NONE);
		tbtmHome.setControl(homeComposite);
		
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Hidden Messages");
		
		MessagesComposite messages = new MessagesComposite(tabFolder, SWT.NONE);
		tabItem.setControl(messages);
		
		TabItem tbtmJaajtoolV = new TabItem(tabFolder, SWT.NONE);
		tbtmJaajtoolV.setText("JaaJTool v0.5");
		
		JaaJComposite jaaJComposite = new JaaJComposite(tabFolder, SWT.NONE);
		tbtmJaajtoolV.setControl(jaaJComposite);
		
		Label lblCopyright = new Label(shell, SWT.NONE);
		lblCopyright.setBounds(103, 570, 418, 31);
		lblCopyright.setText("\u00A9 1996 Microsoft Corporation. This Farmville software was designed to run on\r\n         Windows 95 using the 3.5 inch floppy that this software was sold on.");

	}
}
