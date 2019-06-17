import com.lb.config.SpringConfig;
import com.lb.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LB
 * @create 2019-06-17 14:05
 */
public class aopTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.saveAccount();
    }
}
