package jim.utils;

import java.io.File;
import java.util.Locale;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;

public class Methods {

	public static String 
	get_BaseName(String file_Path) {
		// TODO Auto-generated method stub
		
		////////////////////////////////

		// validate

		////////////////////////////////
		File f = new File(file_Path);
		
		if (!f.exists()) {
			
			//log
			String text, fname; int line_Num;
			
			text = String.format(Locale.JAPAN, "file => doesn't exist: %s\n", f.getAbsolutePath());
			
			fname = Thread.currentThread().getStackTrace()[1].getFileName();
			
			line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
			
			System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);
			
			return null;
			
		}
		
		////////////////////////////////

		// return

		////////////////////////////////
		return f.getName();
		
	}//get_BaseName

	/*******************************
		@return
		1 => (0, 0)<br>
		2 => (1, 0)<br>
		3 => (0, 1)<br>
		4 => (1, 1)<br>
	 *******************************/
	public static Point 
	get_Point(int numOf_Shells) {
		// TODO Auto-generated method stub
		
		int residue = numOf_Shells % 4;
		
		switch(residue) {
		
		case 1: return new Point(0, 0);
		case 2: return new Point(1, 0);
		case 3: return new Point(0, 1);
		case 0: return new Point(1, 1);
		
		}
		
		return null;
		
	}//get_Point(int numOf_Shells)

	public static int[] 
	get_PixData_R(Image image) {
		// TODO Auto-generated method stub
		
		ImageData data = image.getImageData();
		
		int w_Image = data.width;
		int h_Image = data.height;

		//log
		String text, fname; int line_Num;
		
		text = String.format(Locale.JAPAN, "image width = %d, image height = %d\n", w_Image, h_Image);
		
		fname = Thread.currentThread().getStackTrace()[1].getFileName();
		
		line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
		
		System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

		
		int[] pixels = new int[w_Image];
		
		data.getPixels(0, 0, w_Image, pixels, 0);
		
		//log
		text = String.format(Locale.JAPAN, "pixels.length = %d\n", pixels.length);
		
		fname = Thread.currentThread().getStackTrace()[1].getFileName();
		
		line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
		
		System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

		
		PaletteData palette = null;
		RGB rgb = null;
		
		int limit = 200;
		
		int count = 0;
		
		for (int i = 0; i < pixels.length; i++) {
			
			palette = data.palette; 
			
			rgb = palette.getRGB(pixels[i]);
			
			//log
			text = String.format(Locale.JAPAN, 
						"pixels[%d] => r = %d, g = %d, b = %d\n", 
						i, rgb.red, rgb.green, rgb.blue);
			
			fname = Thread.currentThread().getStackTrace()[1].getFileName();
			
			line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
			
			System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

//			// limitter
//			count ++;
//			
//			if (count >= limit) {
//				
//				break;
//				
//			}
			
		}
		
		return null;
		
	}//get_PixData_R

}//public class Methods
