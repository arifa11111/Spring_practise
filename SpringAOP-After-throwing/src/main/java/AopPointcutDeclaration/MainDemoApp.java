package AopPointcutDeclaration;

import AopPointcutDeclaration.DAO.AccountDAO;
import AopPointcutDeclaration.DAO.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get membership bean from spring container
		MembershipDAO theMembershipDAO =
				context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method

		theAccountDAO.addAccount("Arifa");
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addMember();
		theMembershipDAO.goToSleep();

		// close the context
		context.close();
	}

}

































