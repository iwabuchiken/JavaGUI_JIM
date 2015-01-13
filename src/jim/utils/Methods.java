package jim.utils;

import java.io.File;
import java.util.Locale;

import jim.utils.CONS.Admin.RGBNames;

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
	get_PixData_R(Image image, RGBNames rgb_Name) {
		// TODO Auto-generated method stub

		////////////////////////////////

		// prep: data

		////////////////////////////////
		ImageData data = image.getImageData();
		
		int w_Image = data.width;
		int h_Image = data.height;

		int[] pixels = new int[w_Image];
		
		data.getPixels(0, 0, w_Image, pixels, 0);

		PaletteData palette = null;
		RGB rgb = null;
		
		int limit = 50;
		
		int count = 0;
		
		//log
		String text, fname; int line_Num;
		
		//log
		text = String.format(Locale.JAPAN, "pixels.length = %d\n", pixels.length);
		
		fname = Thread.currentThread().getStackTrace()[1].getFileName();
		
		line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
		
		System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

		////////////////////////////////

		// get: pixel value array

		////////////////////////////////
		int pixels_Values[] = new int[pixels.length];
		
		for (int i = 0; i < pixels.length; i++) {
			
			palette = data.palette; 
			
			rgb = palette.getRGB(pixels[i]);
			
			////////////////////////////////

			// get: values

			////////////////////////////////
			switch(rgb_Name) {
			
			case RED: pixels_Values[rgb.red] ++; break;
			case GREEN: pixels_Values[rgb.green] ++; break;
			case BLUE: pixels_Values[rgb.blue] ++; break;
			
			}
			
		}
		
		////////////////////////////////

		// report

		////////////////////////////////
		for (int i = 0; i < pixels_Values.length; i++) {
			
			//log
			text = String.format(Locale.JAPAN, "pixels_R[%d] => %d\n", i, pixels_Values[i]);
			
			fname = Thread.currentThread().getStackTrace()[1].getFileName();
			
			line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
			
			System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

			
//			////////////////////////////////
//
//			// limit
//
//			////////////////////////////////
//			count ++;
//			
//			if (count > limit) {
//				
//				break;
//				
//			}
			
		}
		
		return pixels_Values;
		
	}//get_PixData_R

}//public class Methods
