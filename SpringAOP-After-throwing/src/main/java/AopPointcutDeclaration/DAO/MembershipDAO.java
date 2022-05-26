package AopPointcutDeclaration.DAO;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: adding membership account");
    }
    public void goToSleep() {
        System.out.println(getClass() + "sleeping gudnyt");
    }

}
