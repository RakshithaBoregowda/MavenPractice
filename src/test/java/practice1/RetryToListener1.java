package practice1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryToListener1 implements IAnnotationTransformer
{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) 
	{
	annotation.setRetryAnalyzer(practice1.RetryImplementation1.class);	
		
	}

}
