package demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {
	
	//we can also define pointcuts to use it in different aspects
	@Pointcut("within(demo..*)") //use this pointcut for all classes and methods in demo package
	public void authenticatingPointcut() {
		//nothing here, its just a pointcut
	}
	
	@Pointcut("within(demo..*)") //for all methods in ShoppingCart class
	public void authorizationPointcut() {
		//nothing here, its just a pointcut
	}
	
	//we can use && or || to combine pointcuts
	@Before("authenticatingPointcut() && authorizationPointcut()") //use the predefined pointcuts here
	public void auth() {
		System.out.println("auth request");
	}

}
