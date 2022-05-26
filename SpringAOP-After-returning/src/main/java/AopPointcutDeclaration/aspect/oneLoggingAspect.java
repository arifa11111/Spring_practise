package AopPointcutDeclaration.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class oneLoggingAspect {

	@Pointcut("execution(* AopPointcutDeclaration.DAO.*.*(..))")
	private void forDaoPackage() {}

	// create pointcut for getter methods
	@Pointcut("execution(* AopPointcutDeclaration.DAO.*.get*(..))")
	private void getter() {}

	// create pointcut for setter methods
	@Pointcut("execution(* AopPointcutDeclaration.DAO.*.set*(..))")
	private void setter() {}

	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analytics");
	}

}




























