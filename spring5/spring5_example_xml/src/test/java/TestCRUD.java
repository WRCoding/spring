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
    private AccountService accountService = (AccountService) applicationContext.getBean("accountService");
    @Test
    public void TestFind(){
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }
    @Test
    public void TestFindById(){
        Account account = accountService.findById(2);
        System.out.println(account);
    }
    @Test
    public void TestSave(){
       Account account = new Account();
       account.setName("林北");
       account.setMoney(1234F);
       accountService.save(account);
    }
    @Test
    public void TestUpdate(){
        Account account = accountService.findById(2);
        account.setName("林北");
        accountService.update(account);
        System.out.println(account);
    }
    @Test
    public void TestDelete(){
        accountService.delete(4);
    }
}
