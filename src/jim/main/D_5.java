package jim.main;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseMotionListener;
import java.awt.event.PaintEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

import javax.imageio.ImageIO;

import jim.utils.CONS;
import jim.utils.CONS.Admin.RGBNames;
import jim.utils.Methods;

import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class D_5 {

	protected Shell shell;

	Display disp;

	// ID for new shells
	int numOf_Shells = 1;

	Image image = null;
	
	////////////////////////////////

	// views

	////////////////////////////////
	Label lbl_Image, lbl_FilePath, lbl_Width, 
			lbl_Height, lbl_W_val, lbl_H_val,
			
			lbl_R_value, lbl_G_value, lbl_B_value,
			lbl_R, lbl_G, lbl_B;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
//		final Display display = new Display();
		
		try {
			D_5 window = new D_5();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		disp = Display.getDefault();
//		Display display = Display.getDefault();
		
		////////////////////////////////

		// contents

		////////////////////////////////
		createContents();
		
		////////////////////////////////

		// listeners

		////////////////////////////////
		this.set_Listeners();
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!disp.readAndDispatch()) {
				disp.sleep();
//				display.sleep();
			}
		}
	}

	private void 
	set_Listeners() {
		// TODO Auto-generated method stub
		
		////////////////////////////////

		// listener

		////////////////////////////////
		KeyListener k = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
				PointerInfo a = MouseInfo.getPointerInfo();
				
				java.awt.Point b = a.getLocation();
				int x = (int) b.getX();
				int y = (int) b.getY();
				
				//log
				String text, fname; int line_Num;
				
				text = String.format(Locale.JAPAN, "x = %d, y = %d\n", x, y);
				
				fname = Thread.currentThread().getStackTrace()[1].getFileName();
				
				line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
				
				System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};

		//REF http://www.java2s.com/Code/Java/SWT-JFace-Eclipse/MouseListenerExample.htm
		MouseListener m = new MouseListener() {

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
			
				//log
				String text, fname; int line_Num;
				
				text = String.format(Locale.JAPAN, "mouse.x = %d, mouse.y = %d\n", e.x, e.y);
				
				fname = Thread.currentThread().getStackTrace()[1].getFileName();
				
				line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
				
				System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

			}

			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		MouseTrackListener mtl = new MouseTrackListener() {

			@Override
			public void mouseEnter(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExit(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseHover(MouseEvent e) {
				// TODO Auto-generated method stub
				
				//log
				String text, fname; int line_Num;
				
				text = String.format(Locale.JAPAN, "mouse.x = %d, mouse.y = %d\n", e.x, e.y);
				
				fname = Thread.currentThread().getStackTrace()[1].getFileName();
				
				line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
				
				System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);
				
			}
			
		};

		//REF http://stackoverflow.com/questions/22197551/giving-a-label-highlight-effect-java-swt answered Mar 5 '14 at 12:31
		Listener mouseHover = new Listener()
	    {
	        @Override
	        public void handleEvent(Event e)
	        {
	        	
	        	//log
	        	String text = null, fname = null; int line_Num = 0;

	        	switch(e.type) {
	        	
	        	case SWT.MouseEnter:
	        		
	        		text = String.format(Locale.JAPAN, 
	        					"[%d, %d] e.type => MouseEnter(%d)\n", 
	        					e.x, e.y, e.type);
	        		
	        		fname = Thread.currentThread().getStackTrace()[1].getFileName();
	        		
	        		line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
	        		
	        		break;
	        		
	        	case SWT.MouseExit:
	        		
	        		text = String.format(Locale.JAPAN, 
        					"[%d, %d] e.type => MouseExit(%d)\n", 
        					e.x, e.y, e.type);
	        		
	        		fname = Thread.currentThread().getStackTrace()[1].getFileName();
	        		
	        		line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
	        		
	        		break;
	        		
	        	case SWT.MouseHover:
	        		
	        		text = String.format(Locale.JAPAN, 
        					"[%d, %d] e.type => MouseHover(%d)\n", 
        					e.x, e.y, e.type);
	        		
	        		fname = Thread.currentThread().getStackTrace()[1].getFileName();
	        		
	        		line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
	        		
	        		D_5.this.show_RGB_values(e.x, e.y);
	        		
	        		break;
	        		
	        	}
				
				
				System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

//	            hovering = e.type == SWT.MouseEnter;
//	            label.redraw();
	        }
	    };

	    MouseMotionListener mml = new MouseMotionListener() {

			@Override
			public void mouseDragged(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub

				//log
				String text, fname; int line_Num;
				
				text = String.format(Locale.JAPAN, 
							"[dragged] mouse.x = %d, mouse.y = %d\n", 
							e.getPoint().x, e.getPoint().y);
				
				fname = Thread.currentThread().getStackTrace()[1].getFileName();
				
				line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
				
				System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);
				
			}

			@Override
			public void mouseMoved(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub

				//log
				String text, fname; int line_Num;
				
				text = String.format(Locale.JAPAN, 
							"[moved] mouse.x = %d, mouse.y = %d\n", 
							e.getPoint().x, e.getPoint().y);
				
				fname = Thread.currentThread().getStackTrace()[1].getFileName();
				
				line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
				
				System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

			}
	    	
	    	
	    	
	    };
	    
		////////////////////////////////

		// label: Image

		////////////////////////////////
//		this.lbl_Image.addKeyListener(k);
		
//		this.lbl_Image.addMouseListener(m);
		
//		this.lbl_Image.addMouseTrackListener(mtl);
		this.lbl_Image.addListener(SWT.MouseHover, mouseHover);
		this.lbl_Image.addListener(SWT.MouseEnter, mouseHover);
		this.lbl_Image.addListener(SWT.MouseExit, mouseHover);
		
		//REF http://stackoverflow.com/questions/24691217/swt-mousemove-events-not-fired-while-dragging
//		this.lbl_Image.addDragDetectListener(ddl);
//		this.lbl_Image.addMouseMotionListener(mml);
		
		
	}//set_Listeners

	protected void 
	show_RGB_values(int x, int y) {
		// TODO Auto-generated method stub

		////////////////////////////////

		// prep: data

		////////////////////////////////
		ImageData data = image.getImageData();

		int w_Image = data.width;
		int h_Image = data.height;
		
		//log
		String text, fname; int line_Num;
		
		text = String.format(Locale.JAPAN, 
						"x = %d / y = %d / w_Image = %d / h_Image = %d\n", 
						x, y, w_Image, h_Image);
		
		fname = Thread.currentThread().getStackTrace()[1].getFileName();
		
		line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
		
		System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

		
		////////////////////////////////

		// judge

		////////////////////////////////
		int half_Y1 = this.lbl_Image.getSize().y / 2;
		
		int half_Y2 = h_Image / 2;
		
		boolean lessThan_Height = y < (half_Y1 + half_Y2);
		boolean moreThan_BeginningHeight = y > (half_Y1 - half_Y2);
		
		boolean within = false;
		
		if (x < w_Image 
				&& lessThan_Height 
				&& moreThan_BeginningHeight) {
			
			//log
			text = String.format(Locale.JAPAN, "within image boundary\n");
			
			fname = Thread.currentThread().getStackTrace()[1].getFileName();
			
			line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
			
			System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

			within = true;
			
		} else {
			
			//log
			text = String.format(Locale.JAPAN, "out of image boundary\n");
			
			fname = Thread.currentThread().getStackTrace()[1].getFileName();
			
			line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
			
			System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);
			
			within = false;
			
		}
		
		////////////////////////////////

		// set: rgb values

		////////////////////////////////
		int offset_Y = - 1 * half_Y2;
		
		if (within) {
			
			int pixelValue = -1;
			
			try {
				
				pixelValue = data.getPixel(x, y + offset_Y);
//				pixelValue = data.getPixel(x, y);
				
			} catch (Exception e) {

				e.printStackTrace();
				
				return;
				
			}
			
			if (pixelValue != -1) {
				
				PaletteData palette = data.palette; 
				
				RGB rgb = palette.getRGB(pixelValue);
				
				this.lbl_R_value.setText(String.valueOf(rgb.red));
				this.lbl_G_value.setText(String.valueOf(rgb.green));
				this.lbl_B_value.setText(String.valueOf(rgb.blue));
				
			}
			
		}
		
		
		
		
//		//log
//		String text, fname; int line_Num;
//		
//		text = String.format(Locale.JAPAN, "r = %d, g = %d, b = %d\n", rgb.red, rgb.green, rgb.blue);
//		
//		fname = Thread.currentThread().getStackTrace()[1].getFileName();
//		
//		line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
//		
//		System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

	}//show_RGB_values
	

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		//REF http://www.java2s.com/Tutorial/Java/0280__SWT/CreatinganImageFromaFile.htm
//		disp = new Display();	//=> Invalid thread access
		
//		shell = new Shell(disp);
		shell = new Shell(disp);
//		shell = new Shell();
		shell.setSize(1295, 945);
		shell.setText("D_2");

		////////////////////////////////

		// labels

		////////////////////////////////
		_Create__Labels();

		////////////////////////////////

		// menues

		////////////////////////////////
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem menu_File = new MenuItem(menu, SWT.CASCADE);
		menu_File.setText("&File");
		
		Menu menu_1 = new Menu(menu_File);
		menu_File.setMenu(menu_1);
		
		MenuItem mntmLoadImage = new MenuItem(menu_1, SWT.NONE);
		mntmLoadImage.setText("Load image");
		
		MenuItem mntmSaveImage = new MenuItem(menu_1, SWT.NONE);
		mntmSaveImage.setText("Save image");
		
		MenuItem menuItem = new MenuItem(menu_1, SWT.SEPARATOR);
		menuItem.setText("extra");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mi_Quit = new MenuItem(menu_1, SWT.NONE);
		mi_Quit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				////////////////////////////////

				// dialog

				////////////////////////////////
				//REF http://www.vogella.com/tutorials/EclipseDialogs/article.html
				MessageBox dialog = 
						  new MessageBox(D_5.this.shell, SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
									dialog.setText(CONS.Strings.title_Confirm);
									dialog.setMessage(CONS.Strings.msg_QuitApp);

//						# open dialog and await user selection
				int returnCode = dialog.open();


				//REF return code http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fswt%2Fwidgets%2FMessageBox.html
				if (returnCode == SWT.OK) {
					
					System.exit(0);
					
				}

				
			}
		});
		
		mi_Quit.setText("&Quit");
		
		MenuItem menu_Options = new MenuItem(menu, SWT.CASCADE);
		menu_Options.setText("&Options");
		
		Menu menu_2 = new Menu(menu_Options);
		menu_Options.setMenu(menu_2);
		
		MenuItem mi_ShowR = new MenuItem(menu_2, SWT.NONE);
		mi_ShowR.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				D_5.this.show_RGB(CONS.Admin.RGBNames.RED);
//				D_5.this.show_RGB();
				
			}
		});
		mi_ShowR.setText("Show &R");
		
		MenuItem mi_ShowG = new MenuItem(menu_2, SWT.NONE);
		mi_ShowG.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				D_5.this.show_RGB(CONS.Admin.RGBNames.GREEN);
				
			}
		});
		mi_ShowG.setText("Show &G");
		
		MenuItem mi_ShowB = new MenuItem(menu_2, SWT.NONE);
		mi_ShowB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				D_5.this.show_RGB(CONS.Admin.RGBNames.BLUE);
				
			}
		});
		mi_ShowB.setText("Show &B");
		
		Group gr_Controls = new Group(shell, SWT.BORDER | SWT.SHADOW_ETCHED_OUT);
		gr_Controls.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		gr_Controls.setBounds(944, 30, 280, 90);
		
		Button bt_Quit = new Button(gr_Controls, SWT.NONE);
		bt_Quit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				////////////////////////////////

				// dialog

				////////////////////////////////
				//REF http://www.vogella.com/tutorials/EclipseDialogs/article.html
				MessageBox dialog = 
						  new MessageBox(D_5.this.shell, SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
									dialog.setText(CONS.Strings.title_Confirm);
									dialog.setMessage(CONS.Strings.msg_QuitApp);

//						# open dialog and await user selection
				int returnCode = dialog.open();


				//REF return code http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fswt%2Fwidgets%2FMessageBox.html
				if (returnCode == SWT.OK) {
					
					System.exit(0);
					
				}
				
			}
		});
		bt_Quit.setImage(SWTResourceManager.getImage("C:\\WORKS\\WS\\Eclipse_Luna2\\Java_GUI\\JIM\\image\\bt_quit.png"));
		bt_Quit.setBounds(190, 15, 75, 64);
		bt_Quit.setText("bt_Quit");
		
		Button bt_Choose = new Button(shell, SWT.NONE);
		bt_Choose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
//				DirFileSelection dfs = new DirFileSelection();	//=> Invalid thread access
				
				D_5.this.open_FileChooser();
				
				
			}
		});
		bt_Choose.setBounds(850, 760, 80, 40);
		bt_Choose.setText("Choose");
		
		////////////////////////////////

		// image

		////////////////////////////////
		this.set_Image_to_Label();
		
	}

	protected void 
	show_RGB(RGBNames rgb_Name) {
		// TODO Auto-generated method stub
	
		//log
		String text, fname; int line_Num;
		
		text = String.format(Locale.JAPAN, "file path => %s\n", this.lbl_FilePath.getText());
		
		fname = Thread.currentThread().getStackTrace()[1].getFileName();
		
		line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
		
		System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

		
		ShellRGB sh = new ShellRGB(
						Display.getCurrent(), 
						this.lbl_FilePath.getText(),
						this.numOf_Shells);
//		ShellRGB sh = new ShellRGB(Display.getCurrent());
		
		////////////////////////////////

		// set: size and location

		////////////////////////////////
		int w = 770;
		int h = 550;
		
		int x = 0, y = 0;
		
		
		Point p = Methods.get_Point(this.numOf_Shells);
		
		sh.setLocation(p.x * w, p.y * h);
//		sh.setLocation(10, 10);
		
		//log
		text = String.format(Locale.JAPAN, 
						"p.x = %d, p.y = %d (numOf_Shells = %d)\n", 
						p.x, p.y, this.numOf_Shells);
		
		fname = Thread.currentThread().getStackTrace()[1].getFileName();
		
		line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
		
		System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

		
		sh.setSize(w, h);
//		sh.setSize(770, 550);
		
//		sh.setsi
		
		sh.open();
				
		sh.set_FilePath(this.lbl_FilePath.getText());
		
		sh.setText(numOf_Shells + ":" + Methods.get_BaseName(this.lbl_FilePath.getText()));
		
		// update numOf_Shells
		numOf_Shells ++;

		
		sh.draw_RGB(rgb_Name);
//		sh.draw_RGB(CONS.Admin.RGBNames.BLUE);
		
//		Shell shell_RGB = new Shell(Display.getCurrent());
//		
//		shell_RGB.setSize(300, 300);
//		
//		shell_RGB.open();
		
		
	}//show_RGB

	protected void 
	open_FileChooser() {
		// TODO Auto-generated method stub
		
		String fileFilterPath = "image";
		
		FileDialog fileDialog = new FileDialog(shell, SWT.MULTI);

		fileDialog.setFilterPath(fileFilterPath);
		
		fileDialog.setFilterExtensions(new String[]{"*.jpg", "*.jpeg", "*.png", "*.*"});
		fileDialog.setFilterNames(new String[]{ "jpg format", "jpg format", "Any"});
//		fileDialog.setFilterExtensions(new String[]{"*.rtf", "*.html", "*.*"});
//		fileDialog.setFilterNames(new String[]{ "Rich Text Format", "HTML Document", "Any"});
		
		String firstFile = fileDialog.open();

		if(firstFile != null) {
			
			fileFilterPath = fileDialog.getFilterPath();
			
			String[] selectedFiles = fileDialog.getFileNames();
			
			StringBuffer sb = new StringBuffer(
									"Selected files under dir " 
									+ fileDialog.getFilterPath() 
									+ ": \n");
			
			for(int i=0; i<selectedFiles.length; i++) {
			  
			sb.append(selectedFiles[i] + "\n");
			
			}
			
			//log
			String text, fname; int line_Num;
			
			text = String.format(Locale.JAPAN, "selectedFiles => %s\n", sb.toString());
			
			fname = Thread.currentThread().getStackTrace()[1].getFileName();
			
			line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
			
			System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

			////////////////////////////////

			// get: file

			////////////////////////////////
			File f = new File(fileFilterPath, selectedFiles[0]);
			
			////////////////////////////////

			// set image

			////////////////////////////////
			this.set_Image_to_Label(f);
			
//          label.setText(sb.toString());
			
		}

	}//open_FileChooser
	

	private void 
	_Create__Labels() {
		// TODO Auto-generated method stub

		Group gr_ImageData = new Group(shell, SWT.BORDER | SWT.SHADOW_OUT);
		gr_ImageData.setBounds(950, 420, 290, 380);
		

//		lbl_Image = new Label(shell, SWT.BORDER | SWT.SHADOW_IN | SWT.RIGHT);
		lbl_Image = new Label(shell, SWT.BORDER | SWT.SHADOW_IN);
//		lbl_Image = new Label(shell, SWT.SHADOW_IN);
//		lbl_Image = new Label(shell, SWT.BORDER);
		lbl_Image.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
//		Label lbl_Image = new Label(shell, SWT.NONE);
		lbl_Image.setBounds(10, 30, 900, 700);
		lbl_Image.setText("New Label");

		////////////////////////////////

		// 

		////////////////////////////////
		lbl_FilePath = new Label(shell, SWT.NONE);
		lbl_FilePath.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
		lbl_FilePath.setBounds(30, 760, 800, 45);
		lbl_FilePath.setText("lbl_FilePath");

		lbl_Width = new Label(gr_ImageData, SWT.NONE);
		lbl_Width.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
		lbl_Width.setBounds(10, 21, 90, 27);
		lbl_Width.setText("lbl_W");
		
		lbl_Height = new Label(gr_ImageData, SWT.NONE);
		lbl_Height.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
		lbl_Height.setBounds(10, 78, 90, 27);
		lbl_Height.setText("lbl_H");
		
		lbl_W_val = new Label(gr_ImageData, SWT.NONE);
		lbl_W_val.setBounds(121, 21, 90, 27);
		lbl_W_val.setText("lbl_W_val");
		
		lbl_H_val = new Label(gr_ImageData, SWT.NONE);
		lbl_H_val.setBounds(121, 78, 90, 27);
		lbl_H_val.setText("lbl_H_val");
		
		lbl_R = new Label(gr_ImageData, SWT.NONE);
		lbl_R.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		lbl_R.setBounds(10, 133, 90, 27);
		lbl_R.setText("R");
		
		lbl_R_value = new Label(gr_ImageData, SWT.NONE);
		lbl_R_value.setBounds(121, 133, 90, 27);
		lbl_R_value.setText("0");
		
		lbl_G = new Label(gr_ImageData, SWT.NONE);
		lbl_G.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		lbl_G.setBounds(10, 193, 90, 27);
		lbl_G.setText("G");
		
		lbl_G_value = new Label(gr_ImageData, SWT.NONE);
		lbl_G_value.setBounds(121, 193, 90, 27);
		lbl_G_value.setText("0");
		
		lbl_B = new Label(gr_ImageData, SWT.NONE);
		lbl_B.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		lbl_B.setBounds(10, 254, 90, 27);
		lbl_B.setText("B");
		
		lbl_B_value = new Label(gr_ImageData, SWT.NONE);
		lbl_B_value.setBounds(121, 254, 90, 27);
		lbl_B_value.setText("0");
//		mi_Quit.setText("Quit");

	}

	private void 
	set_Image_to_Label() {
		// TODO Auto-generated method stub
		
		String fpath_Image = "image/img_1.jpg";
		
		File f = new File(fpath_Image);

		image = null;
		
		try {
	  	  
			image = new Image(disp, new FileInputStream(f));
	//	  image = new Image(disp, new FileInputStream(fpath_Image));
			
			this.lbl_Image.setImage(image);
	//	  image.dispose();
			
			this.lbl_Image.setAlignment(SWT.BOTTOM);
//			this.lbl_Image.setAlignment(SWT.TOP);
//			this.lbl_Image.setAlignment(SWT.RIGHT|SWT.TOP);	//=> working
//			this.lbl_Image.setAlignment(SWT.LEFT|SWT.TOP);
			
			////////////////////////////////
	
			// image data
	
			////////////////////////////////
			ImageData data = image.getImageData();
			
			int w = image.getImageData().width;
			int h = image.getImageData().height;
			
			this.lbl_W_val.setText(String.valueOf(w));
			this.lbl_H_val.setText(String.valueOf(h));
			
			this.lbl_FilePath.setText(f.getAbsolutePath());
	
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

//		//REF http://www.java2s.com/Tutorial/Java/0280__SWT/LoadimagefromfileCreateaninputstreamandpasstheinputstreamtotheconstructor.htm
//		Canvas canvas = new Canvas(shell, SWT.NONE);
//		
//		 canvas.addPaintListener(new PaintListener() {
//			  public void paintControl(PaintEvent e) {
//				Image image = null;
//				try {
//				  image = new Image(disp, new FileInputStream(fpath_Image));
//				} catch (FileNotFoundException e1) {
//				  // TODO Auto-generated catch block
//				  e1.printStackTrace();
//				}
//
//				e.
//				
//				e.gc.drawImage(image, 10, 10);
//
//				image.dispose();
//			  }
//			});
		
//		GC gc = new GC(canvas);
//		
//		Image image = null;
//		
//		try {
//			
//			image = new Image(disp, new FileInputStream(fpath_Image));
//			
//			gc.drawImage(image, 10, 10);
//			
//			image.dispose();
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			
//			//REF http://www.coderanch.com/t/615221/GUI/java/jpg-image-viewer
////			Image img = ImageIO.read(new File(fpath_Image));
//			BufferedImage img = ImageIO.read(new File(fpath_Image));
//
////			Image img2 = (Image) img;
//			
////			this.lbl_Image.set
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	private void 
	set_Image_to_Label(File file_Image) {
		// TODO Auto-generated method stub
		
//		String fpath_Image = "image/img_1.jpg";
//		
//		File f = new File(fpath_Image);
		
		File f = file_Image;
		
		image = null;
		
		try {
			
			image = new Image(disp, new FileInputStream(f));
//      image = new Image(disp, new FileInputStream(fpath_Image));
			
			this.lbl_Image.setImage(image);
//      image.dispose();
			
			////////////////////////////////
			
			// image data
			
			////////////////////////////////
			ImageData data = image.getImageData();
			
			int w = image.getImageData().width;
			int h = image.getImageData().height;
			
			this.lbl_W_val.setText(String.valueOf(w));
			this.lbl_H_val.setText(String.valueOf(h));
			
			this.lbl_FilePath.setText(f.getAbsolutePath());
			
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		//REF http://www.java2s.com/Tutorial/Java/0280__SWT/LoadimagefromfileCreateaninputstreamandpasstheinputstreamtotheconstructor.htm
//		Canvas canvas = new Canvas(shell, SWT.NONE);
//		
//		 canvas.addPaintListener(new PaintListener() {
//		      public void paintControl(PaintEvent e) {
//		        Image image = null;
//		        try {
//		          image = new Image(disp, new FileInputStream(fpath_Image));
//		        } catch (FileNotFoundException e1) {
//		          // TODO Auto-generated catch block
//		          e1.printStackTrace();
//		        }
//
//		        e.
//		        
//		        e.gc.drawImage(image, 10, 10);
//
//		        image.dispose();
//		      }
//		    });
		
//		GC gc = new GC(canvas);
//		
//		Image image = null;
//		
//		try {
//			
//			image = new Image(disp, new FileInputStream(fpath_Image));
//			
//			gc.drawImage(image, 10, 10);
//			
//			image.dispose();
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			
//			//REF http://www.coderanch.com/t/615221/GUI/java/jpg-image-viewer
////			Image img = ImageIO.read(new File(fpath_Image));
//			BufferedImage img = ImageIO.read(new File(fpath_Image));
//
////			Image img2 = (Image) img;
//			
////			this.lbl_Image.set
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}

class DirFileSelection {
	  Display display = new Display();
	  Shell shell = new Shell(display);
	  
	  // the label used to display selected dir/file.
	  Label label;
	  
	  Button buttonSelectDir;
	  Button buttonSelectFile;
	  
	  String selectedDir = "C:/WORKS/Downloads";
//	  String selectedDir = "C:/WORKS";
//	  String selectedDir;
	  String fileFilterPath = "C:/WORKS/Downloads";
//	  String fileFilterPath = "F:/jdk1.5";

	  public DirFileSelection() {
		  
		////////////////////////////////

		// shell

		////////////////////////////////
		shell.setSize(500, 500);
		  
		  
	    label = new Label(shell, SWT.BORDER | SWT.WRAP);
	    label.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
	    label.setText("Select a dir/file by clicking the buttons below.");
	    
	    buttonSelectDir = new Button(shell, SWT.PUSH);
	    buttonSelectDir.setText("Select a directory");
	    buttonSelectDir.addListener(SWT.Selection, new Listener() {
	      public void handleEvent(Event event) {
	        DirectoryDialog directoryDialog = new DirectoryDialog(shell);
	        
	        directoryDialog.setFilterPath(selectedDir);
	        directoryDialog.setMessage("Please select a directory and click OK");
	        
	        String dir = directoryDialog.open();
	        if(dir != null) {
	          label.setText("Selected dir: " + dir);
	          selectedDir = dir;
	        }
	      }
	    });
	    
	    buttonSelectFile = new Button(shell, SWT.PUSH);
	    buttonSelectFile.setText("Select a file/multiple files");
	    buttonSelectFile.addListener(SWT.Selection, new Listener() {
	      public void handleEvent(Event event) {
	      }
	    });
	    
	    label.setBounds(0, 0, 400, 60);
	    buttonSelectDir.setBounds(0, 65, 200, 30);
	    buttonSelectFile.setBounds(200, 65, 200, 30);

	    shell.pack();
	    shell.open();
	    //textUser.forceFocus();

	    // Set up the event loop.
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        // If no more entries in event queue
	        display.sleep();
	      }
	    }

	    display.dispose();
	  }


//	  public static void main(String[] args) {
//	    new DirFileSelection();
//	  }
}
