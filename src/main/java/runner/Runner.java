package runner;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import settings.Settings;
import webdriver.Driver;

public class Runner {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Settings settings = new Settings();
        CmdLineParser cmdLineParser = new CmdLineParser(settings);
        
        try {
        	cmdLineParser.parseArgument(args);
        	System.out.println("Settings: " + settings);
        	
            Driver.setBrowserName(settings.browserName);
         
        } catch (CmdLineException e) {
            System.out.println("Invalid arguments: " + e.getMessage());
            cmdLineParser.printUsage(System.out);
        }
        
    
        TestNG testng = new TestNG();
        for(XmlSuite suite : new Parser(settings.pathToTestNG).parseToList()) {
            testng.setCommandLineSuite(suite);
        }
        testng.run();

	}

}
