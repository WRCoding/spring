import com.lb.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author LB
 * @create 2019-06-18 11:05
 */
public class Test {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
    AccountService accountService = (AccountService) applicationContext.getBean("accountService");

    @org.junit.Test
    public void test(){
        accountService.transfer("aaa","ccc" ,100 );
    }
}
