package coursesRegistration.util;

import java.util.ArrayList;
import java.io.FileWriter;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	public void writeToFile(String s,ArrayList results) {

		/**
		 * https://stackoverflow.com
		 */
		try {
			
			FileWriter writer = new FileWriter(s); 

			for(int i = 0;i<results.size();i++) {
			  
			  writer.write(results.get(i)+System.lineSeparator());

			}

			writer.close();

		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally{}
	}
	
	public void writeToStdout(ArrayList results) {
		
		for(int i = 0;i<results.size();i++) {
			
			System.out.println(results.get(i));
		}
	}
	
}
