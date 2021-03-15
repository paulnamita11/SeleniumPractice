package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
	
	static Properties prop = new Properties();
	public static void main(String[] args) {
		readPropertiesFile();
		writePropertiesFile();
		//readPropertiesFile();
	}
	
	public static void readPropertiesFile(){
		
		
		try {
			InputStream input = new FileInputStream("/Users/namita_pm_pursuitsof/eclipse-workspace/DemoSampleProject/src/main/java/Config/config.properties");
			prop.load(input);
			System.out.println(prop.getProperty("browser"));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void writePropertiesFile() {
		try {
			OutputStream output = new FileOutputStream("/Users/namita_pm_pursuitsof/eclipse-workspace/DemoSampleProject/src/main/java/Config/config.properties");
			//prop.setProperty("browser", "IE");
			prop.setProperty("result", "PASS");
			prop.store(output, null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
