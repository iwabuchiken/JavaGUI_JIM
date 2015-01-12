package jim.main;

import java.awt.event.PaintEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import jim.utils.CONS;

import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class D_2 {

	protected Shell shell;

	Display disp;
	
	////////////////////////////////

	// views

	////////////////////////////////
	Label lbl_Image, lbl_FilePath, lbl_Width, lbl_Height, lbl_W_val, lbl_H_val;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
//		final Display display = new Display();
		
		try {
			D_2 window = new D_2();
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
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!disp.readAndDispatch()) {
				disp.sleep();
//				display.sleep();
			}
		}
	}

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
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("&File");
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
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
						  new MessageBox(D_2.this.shell, SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
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
						  new MessageBox(D_2.this.shell, SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
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
		
		////////////////////////////////

		// image

		////////////////////////////////
		this.set_Image_to_Label();
		
	}

	private void 
	_Create__Labels() {
		// TODO Auto-generated method stub

		Group gr_ImageData = new Group(shell, SWT.BORDER | SWT.SHADOW_OUT);
		gr_ImageData.setBounds(950, 420, 290, 380);
		

		lbl_Image = new Label(shell, SWT.NONE);
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
//		mi_Quit.setText("Quit");

	}

	private void 
	set_Image_to_Label() {
		// TODO Auto-generated method stub
		
		String fpath_Image = "image/img_1.jpg";
		
		File f = new File(fpath_Image);

      Image image = null;
      try {
    	  
        image = new Image(disp, new FileInputStream(f));
//        image = new Image(disp, new FileInputStream(fpath_Image));
        
        this.lbl_Image.setImage(image);
//        image.dispose();
        
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

//import org.eclipse.swt.SWT;
//import org.eclipse.swt.widgets.Button;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Event;
//import org.eclipse.swt.widgets.Label;
//import org.eclipse.swt.widgets.Listener;
//import org.eclipse.swt.widgets.Shell;
//import org.eclipse.swt.widgets.Text;
//
//public class D_2 {
////	public class DialogClass {
//  static boolean deleteFlag = false;
//
//  public static void main(String[] args) {
//    Display display = new Display();
//    Shell shell = new Shell(display);
//    shell.setText("Dialog Example");
//    shell.setSize(300, 200);
//    shell.open();
//
//    final Button button = new Button(shell, SWT.PUSH);
//    button.setText("Delete File");
//    button.setBounds(20, 40, 180, 25);
//
//    final Text text = new Text(shell, SWT.SHADOW_IN);
//    text.setBounds(140, 40, 100, 25);
//
//    final Shell dialog = new Shell(shell, SWT.APPLICATION_MODAL
//        | SWT.DIALOG_TRIM);
//    dialog.setText("Delete File");
//    dialog.setSize(250, 150);
//
//    final Button buttonOK = new Button(dialog, SWT.PUSH);
//    buttonOK.setText("OK");
//    buttonOK.setBounds(20, 55, 80, 25);
//
//    Button buttonCancel = new Button(dialog, SWT.PUSH);
//    buttonCancel.setText("Cancel");
//    buttonCancel.setBounds(120, 55, 80, 25);
//
//    final Label label = new Label(dialog, SWT.NONE);
//    label.setText("Delete the file?");
//    label.setBounds(20, 15, 100, 20);
//
//    Listener listener = new Listener() {
//      public void handleEvent(Event event) {
//        if (event.widget == buttonOK) {
//          deleteFlag = true;
//        } else {
//          deleteFlag = false;
//        }
//        dialog.close();
//      }
//    };
//
//    buttonOK.addListener(SWT.Selection, listener);
//    buttonCancel.addListener(SWT.Selection, listener);
//
//    Listener buttonListener = new Listener() {
//      public void handleEvent(Event event) {
//        dialog.open();
//      }
//    };
//
//    button.addListener(SWT.Selection, buttonListener);
//
//    while (!dialog.isDisposed()) {
//      if (!display.readAndDispatch())
//        display.sleep();
//    }
//
//    if (deleteFlag) {
//      text.setText("File deleted.");
//    } else {
//      text.setText("File not deleted.");
//    }
//
//    while (!shell.isDisposed()) {
//      if (!display.readAndDispatch())
//        display.sleep();
//    }
//    display.dispose();
//  }
//}
