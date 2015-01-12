package jim.utils;

import java.io.File;
import java.util.Locale;

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

}
