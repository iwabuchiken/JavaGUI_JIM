package jim.utils;

import java.io.File;
import java.util.Locale;

import org.eclipse.swt.graphics.Point;

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

}//public class Methods
