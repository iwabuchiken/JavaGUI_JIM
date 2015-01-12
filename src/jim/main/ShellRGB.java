package jim.main;

import java.util.Locale;

import jim.utils.Methods;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Canvas;

public class ShellRGB extends Shell {

	Label lbl_FilePath;
	
	Menu menu, menu_1;
	
	MenuItem mntmFile, mntmQuit;

	Canvas canvas;

	private String file_Path;
	
	/**
	 * Launch the application.
	 * @param args
	 */
//	public static void main(String args[]) {
//		try {
//			Display display = Display.getDefault();
//			ShellRGB shell = new ShellRGB(display);
//			shell.open();
//			shell.layout();
//			while (!shell.isDisposed()) {
//				if (!display.readAndDispatch()) {
//					display.sleep();
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public ShellRGB(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("&File");
		
		menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		mntmQuit = new MenuItem(menu_1, SWT.NONE);
		mntmQuit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
//				System.exit(0);
				
				ShellRGB.this.close();
				
			}
		});
		mntmQuit.setText("&Quit");
		
		canvas = new Canvas(this, SWT.NONE);
		canvas.setBounds(10, 10, 500, 369);
		
		lbl_FilePath = new Label(this, SWT.NONE);
		lbl_FilePath.setBounds(10, 396, 500, 55);
		lbl_FilePath.setText("New Label");
		createContents();
	}

	public ShellRGB(Display display, String file_Path) {
		// TODO Auto-generated constructor stub
		
		super(display, SWT.SHELL_TRIM);
		
		menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("&File");
		
		menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		mntmQuit = new MenuItem(menu_1, SWT.NONE);
		mntmQuit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
//				System.exit(0);
				
				ShellRGB.this.close();
				
			}
		});
		mntmQuit.setText("&Quit");
		
		canvas = new Canvas(this, SWT.NONE);
		canvas.setBounds(10, 10, 500, 369);
		
		lbl_FilePath = new Label(this, SWT.NONE);
		lbl_FilePath.setBounds(10, 396, 500, 55);
		lbl_FilePath.setText("New Label");
		createContents();

		////////////////////////////////

		// file_Path

		////////////////////////////////
		this.file_Path = file_Path;
		
		//log
		String text, fname; int line_Num;
		
		text = String.format(Locale.JAPAN, "shell => created: file path = %s\n", this.file_Path);
		
		fname = Thread.currentThread().getStackTrace()[1].getFileName();
		
		line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
		
		System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		
		//log
		String text, fname; int line_Num;
		
		text = String.format(Locale.JAPAN, "file path => %s\n", this.file_Path);
		
		fname = Thread.currentThread().getStackTrace()[1].getFileName();
		
		line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
		
		System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

//		setText(Methods.get_BaseName(this.file_Path));
//		setText("ShellRGB");
//		setText("SWT Application");
		setSize(766, 548);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void 
	set_FilePath(String text) {
		// TODO Auto-generated method stub
	
		this.lbl_FilePath.setText(text);
		
	}
}
