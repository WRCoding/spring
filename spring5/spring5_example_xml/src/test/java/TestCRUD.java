import com.lb.pojo.Account;
import com.lb.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author LB
 * @create 2019-06-15 9:50
 */
public class TestCRUD {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
    private AccountService accountService = (AccountService) applicationContext.getBean("proxyAccountService");

    @Test
    public void testTransFer(){
        accountService.transfer("aaa","ccc" ,100 );
    }
}
