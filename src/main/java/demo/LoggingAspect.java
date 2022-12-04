package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component //this is needed for spring to detect component
public class LoggingAspect {

	@Before("execution(* demo.ShoppingCart.checkout(..))") //the string in @Before() is a pointcut -> * = any return type. to get this work we need to enable aspect j in BeanConfig.class
	//checkout(..) means any input param
	public void beforeLogger(JoinPoint jp) {
		//with JoinPoint object, we can get information of the JoinPoint at runtime, in this case the checkoutMethod
		System.out.println("--------"+jp.getSignature());
		System.out.println("---------"+jp.getArgs()[0].toString()); //get the arg of checkout(String status)
		System.out.println("before logger");
	}
	
	@After("execution(* *.*.checkout(..))") //* *.*. -> any return type, any package + any class
	public void afterLogger() {
		System.out.println("after logger"); //this is a pointcut
	}
	
	//if the joinpoint has a return type, we can use @AfterReturning and access the returned value
	@AfterReturning(pointcut = "execution(* demo.ShoppingCart.quantity(..))", returning = "retVal")
	public void afterReturningLogger(Object retVal) {
		System.out.println("after returning logger, return value = "+retVal);
	}
}
