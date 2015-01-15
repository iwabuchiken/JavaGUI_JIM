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
	get_PixData(Image image, RGBNames rgb_Name) {
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
		
//		//log
		String text, fname; int line_Num;
//		
//		//log
//		text = String.format(Locale.JAPAN, "pixels.length = %d\n", pixels.length);
//		
//		fname = Thread.currentThread().getStackTrace()[1].getFileName();
//		
//		line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
//		
//		System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

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

	public static int[] 
	get_PixData_AllLines(Image image, RGBNames rgb_Name) {
		// TODO Auto-generated method stub
		
		////////////////////////////////
		
		// prep: data
		
		////////////////////////////////
		ImageData data = image.getImageData();
		
		int w_Image = data.width;
		int h_Image = data.height;
		
		int[] pixels = new int[w_Image];
		
		PaletteData palette = null;
		RGB rgb = null;
		
		int limit = 50;
		
		int count = 0;

		int pixels_Values[] = null;
				
		////////////////////////////////
		
		// get: pixel value array
		
		////////////////////////////////
		pixels_Values = new int[w_Image];
		
		int i, j;
		
		for (i = 0; i < h_Image; i++) {
			
			data.getPixels(0, i, w_Image, pixels, 0);
		
//			pixels_Values = new int[pixels.length];
			
			for (j = 0; j < pixels.length; j++) {
				
				palette = data.palette; 
				
				rgb = palette.getRGB(pixels[j]);
				
				////////////////////////////////
				
				// get: values
				
				////////////////////////////////
				switch(rgb_Name) {
				
				case RED: pixels_Values[rgb.red] ++; break;
				case GREEN: pixels_Values[rgb.green] ++; break;
				case BLUE: pixels_Values[rgb.blue] ++; break;
				
				}
				
			}
			
		}//for (int i = 0; i < h_Image; i++)
		
//		pixels_Values = new int[pixels.length];
//		
//		for (int i = 0; i < pixels.length; i++) {
//			
//			palette = data.palette; 
//			
//			rgb = palette.getRGB(pixels[i]);
//			
//			////////////////////////////////
//			
//			// get: values
//			
//			////////////////////////////////
//			switch(rgb_Name) {
//			
//			case RED: pixels_Values[rgb.red] ++; break;
//			case GREEN: pixels_Values[rgb.green] ++; break;
//			case BLUE: pixels_Values[rgb.blue] ++; break;
//			
//			}
//			
//		}
//		
		////////////////////////////////
		
		// report
		
		////////////////////////////////
		for (i = 0; i < pixels_Values.length; i++) {
			
			//log
			String text, fname; int line_Num;

			text = String.format(Locale.JAPAN, "pixels_R[%d] => %d\n", i, pixels_Values[i]);
			
			fname = Thread.currentThread().getStackTrace()[1].getFileName();
			
			line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
			
			System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);
			
		}
		
		return pixels_Values;
		
	}//get_PixData_R
	
	public static int 
	get_Max(int[] pixData_R) {
		
		int len = pixData_R.length;
		
		int max = -1;
		
		for (int i = 0; i < len; i++) {
			
			if (max < pixData_R[i]) {
				
				max = pixData_R[i];
				
			}
			
		}
		
		return max;
		
	}//get_Max

	public static int 
	get_Max(int[] pixData_R, int[] pixData_G, int[] pixData_B) {
		
		int len = pixData_R.length;
		
		int max = -1;
		
		////////////////////////////////

		// red

		////////////////////////////////
		for (int i = 0; i < len; i++) {
			
			if (max < pixData_R[i]) {
				
				max = pixData_R[i];
				
			}
			
		}
		
		////////////////////////////////
		
		// green
		
		////////////////////////////////
		len = pixData_G.length;
		
		for (int i = 0; i < len; i++) {
			
			if (max < pixData_G[i]) {
				
				max = pixData_G[i];
				
			}
			
		}
		
		////////////////////////////////
		
		// blue
		
		////////////////////////////////
		len = pixData_B.length;
		
		for (int i = 0; i < len; i++) {
			
			if (max < pixData_B[i]) {
				
				max = pixData_B[i];
				
			}
			
		}
		
		return max;
		
	}//get_Max

	public static int[] 
	get_RGB_IntVals(int pixVal_R, int pixVal_G, int pixVal_B, int index) {
		// TODO Auto-generated method stub

		int rgb_IntVals[] = new int[3];
		
		////////////////////////////////

		// red

		////////////////////////////////
		if (pixVal_R - index > 0) {
			
			rgb_IntVals[0] = 255;
			
		} else {
			
			rgb_IntVals[0] = 0;
			
		}
		
		////////////////////////////////
		
		// green
		
		////////////////////////////////
		if (pixVal_G - index > 0) {
			
			rgb_IntVals[1] = 255;
			
		} else {
			
			rgb_IntVals[1] = 0;
			
		}
		
		////////////////////////////////
		
		// blue
		
		////////////////////////////////
		if (pixVal_B - index > 0) {
			
			rgb_IntVals[2] = 255;
			
		} else {
			
			rgb_IntVals[2] = 0;
			
		}
		
//		//log
//		String text, fname; int line_Num;
//		
//		text = String.format(Locale.JAPAN, 
//						"pixVal_R = %d, pixVal_G = %d, pixVal_B = %d\n"
//						+ "(index = %d)",
//						pixVal_R, pixVal_G, pixVal_B, index);
//		
//		fname = Thread.currentThread().getStackTrace()[1].getFileName();
//		
//		line_Num = Thread.currentThread().getStackTrace()[1].getLineNumber();
//		
//		System.out.format(Locale.JAPAN, "[%s:%d] %s", fname, line_Num, text);

		return rgb_IntVals;
		
	}//get_RGB_IntVals
	
}//public class Methods
