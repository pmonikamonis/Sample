package testscripts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerSample implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount = 3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(!result.isSuccess()) {
		 if (retryCount < maxRetryCount) {
		      retryCount++;
		      return true;
		    }
		}
		return false;
	}
	

}
