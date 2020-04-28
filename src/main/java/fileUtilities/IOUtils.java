package fileUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class IOUtils {
	
	static BufferedReader reader = null;

		public static JSONObject readFiles() throws IOException, ParseException {
	
			JSONParser jpars = new JSONParser();
			FileReader reader = null;
			try {
				reader = new FileReader(".\\TestData\\authenticate.json");
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Object obj = jpars.parse(reader);

			return (JSONObject) obj;
			
		/*
		 * FileInputStream fis = null; try { //fis = new FileInputStream(
		 * "D:/Rupeek_WorkingDirectory/RupeekCustomerData/TestData/authenticate.json");
		 * // String fileString = fis.toString(); reader = new BufferedReader(new
		 * FileReader(new File(".\\TestData\\authenticate.json"))); } catch
		 * (FileNotFoundException e1) {
		 * 
		 * e1.printStackTrace(); }
		 */
				
}

		
}
