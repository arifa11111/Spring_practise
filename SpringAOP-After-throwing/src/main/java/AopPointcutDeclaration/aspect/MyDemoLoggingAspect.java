package AopPointcutDeclaration.aspect;

import AopPointcutDeclaration.Account;
import AopPointcutDeclaration.DAO.AccountDAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

	@Aspect
	@Component
	@Order(2)
	public class MyDemoLoggingAspect {
		@AfterThrowing(
				pointcut = "execution(* AopPointcutDeclaration.DAO.AccountDAO.findAccounts(..))",
				throwing = "e")
		public void afterTrowingFindAccounts(JoinPoint theJointPoint,Throwable e){
			String method=theJointPoint.getSignature().toShortString();
			System.out.println("______________________@After throwable on method "+method);
			System.out.println("++++++++++Exception : "+e);
		}
		// add a new advice for @AfterReturning on the findAccounts method

		@AfterReturning(
				pointcut = "execution(* AopPointcutDeclaration.DAO.AccountDAO.findAccounts(..))",
				returning = "result")
		public void afterReturningFindAccountsAdvice(
				JoinPoint theJoinPoint, List<Account> result) {

			// print out which method we are advising on
			String method = theJoinPoint.getSignature().toShortString();
			System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

			// print out the results of the method call
			System.out.println("\n=====>>> result is: " + result);

			// let's post-process the data ... let's modify it :-)

			// convert the account names to uppercase
			convertAccountNamesToUpperCase(result);

			System.out.println("\n=====>>> result is: " + result);

		}

		private void convertAccountNamesToUpperCase(List<Account> result) {

			// loop through accounts

			for (Account tempAccount : result) {

				// get uppercase version of name
				String theUpperName = tempAccount.getName().toUpperCase();

				// update the name on the account
				tempAccount.setName(theUpperName);
			}

		}



		}





























