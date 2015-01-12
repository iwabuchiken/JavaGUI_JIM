package jim.main;

import java.util.Locale;

import jim.utils.CONS;
import jim.utils.Methods;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Canvas;

public class ShellRGB extends Shell {

	Label lbl_FilePath;
	
	Menu menu, menu_1;
	
	MenuItem mntmFile, mntmQuit;

	Canvas canvas;

	private String file_Path;

	// colors
	Color red, blue, blue_light, burlywood2, green, yellow, white, black;

	private int numOf_Shells;

	/**
	 * Launch the application.
	 * @param args
	 */

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

	/**
	 * @wbp.parser.constructor
	 */
	public ShellRGB
	(Display display, String file_Path, int numOf_Shells) {
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
		canvas.setBounds(10, 10, 500, 370);
		
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

		////////////////////////////////

		// colors

		////////////////////////////////
		this.init_Colors();
		
		////////////////////////////////

		// ID number

		////////////////////////////////
		this.numOf_Shells = numOf_Shells;
		
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
//		setSize(766, 548);

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

	void draw_RGB() {
		
		GC gc = new GC(this.canvas);
		
//		gc.setForeground(display.getSystemColor(SWT.COLOR_CYAN)); 
		
		//REF http://stackoverflow.com/questions/50064/setting-colors-in-swt answered Sep 8 '08 at 16:49
//		Device device = Display.getCurrent ();
//		Color red = new Color (device, 255, 0, 0);
		
//		gc.setBackground(this.burlywood2); 
		gc.setBackground(blue_light); 
		
		//REF http://www.java2s.com/Tutorial/Java/0300__SWT-2D-Graphics/DrawingPointsLinesandsetlinewidth.htm
		gc.setLineWidth(CONS.Views.lineWidth_Rect);
		
//		gc.fillRectangle(x, y, w, h);
		gc.drawRectangle(10, 10, 100, 100);
		
		gc.dispose();

		
	}

	private void 
	init_Colors() {
		// TODO Auto-generated method stub
		
		//REF http://stackoverflow.com/questions/50064/setting-colors-in-swt answered Sep 8 '08 at 16:49
		Device device = Display.getCurrent ();
		red = new Color (device, 255, 0, 0);
		
		blue = new Color (device, 0, 0, 255);
		
		blue_light = new Color (device, 255, 0, 255);
		
		//REF http://web.njit.edu/~kevin/rgb.txt.html
		burlywood2 = new Color (device, 238, 197, 145);
		
		green = new Color (device, 0, 255, 0);
		
		yellow = new Color (device, 255, 255, 0);
		
		white = new Color (device, 255, 255, 255);
		
		black = new Color (device, 0, 0, 0);
		
	}//_init_Colors

	
}
