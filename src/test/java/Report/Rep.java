package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Rep {

	static ExtentReports report;

	public static ExtentReports reporter() {
		
		if(report==null) {
		
			ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"./HTML_Reports/ExtentReport.html");
			
			report=new ExtentReports();
			report.attachReporter(htmlreporter);
			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("Browser", "Edge"); htmlreporter.config().setDocumentTitle("Action Items module automation");
			htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlreporter.config().setTheme(Theme.DARK);
			htmlreporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		
		}
	return report;
}
}