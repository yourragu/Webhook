package sample;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;
import org.testng.xml.XmlSuite;

public class MainClass {

	public static void main(String[] args) {
		/*TestListenerAdapter tla = new TestListenerAdapter();
	    TestNG testng = new TestNG();
	    List<String> suites = Lists.newArrayList();
	    suites.add("./testng.xml");
	    testng.setTestSuites(suites);
	    testng.run();*/
		
		TestListenerAdapter tla = new TestListenerAdapter();		
		TestNG testng = new TestNG();
		testng.setParallel(XmlSuite.ParallelMode.CLASSES);
		testng.setTestClasses(new Class[] { NetMedsTest1.class,NetMedsTest2.class  });
		testng.addListener(tla);
		testng.run();

	}

}
