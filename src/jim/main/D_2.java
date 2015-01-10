package jim.main;

import java.awt.event.PaintEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class D_2 {

	protected Shell shell;

	Display disp;
	
	////////////////////////////////

	// views

	////////////////////////////////
	Label lbl_Image;
	
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
		
		lbl_Image = new Label(shell, SWT.NONE);
//		Label lbl_Image = new Label(shell, SWT.NONE);
		lbl_Image.setBounds(10, 70, 765, 795);
		lbl_Image.setText("New Label");

		////////////////////////////////

		// image

		////////////////////////////////
		this.set_Image_to_Label();
		
	}

	private void 
	set_Image_to_Label() {
		// TODO Auto-generated method stub
		
		String fpath_Image = "image/img_1.jpg";

      Image image = null;
      try {
        image = new Image(disp, new FileInputStream(fpath_Image));
        
        this.lbl_Image.setImage(image);
//        image.dispose();
        
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
