import com.sunny.domain.Employee;
import com.sunny.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Autowired
    private IEmployeeService service;

    @Test
    public void test1(){
        Employee emp = new Employee();
        emp.setUsername("ggg");
        emp.setPassword("11111");
        emp.setAge(20);
        emp.setHiredate(new Date());
        service.save(emp);
    }

    @Test
    public void test2(){
        Employee employee = service.get(20L);
        System.out.println(employee);
    }

    @Test
    public void test3(){
        List<Employee> employees = service.listAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
