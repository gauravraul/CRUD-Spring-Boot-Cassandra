package Cass;

import Cass.doa.CustomerRepository;
import Cass.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... strings) throws Exception {
        clearData();
        saveData();
        lookup();
    }

    public void clearData() {
            customerRepository.deleteAll();
    }

    public void saveData() {

        System.out.println("=========== Save Data to Cassandara ============");
        Customer amit = new Customer(1,"Amit","Waghmare",24);
        Customer sid  = new Customer(2,"Siddhesh","Lad", 25);
        Customer tejas = new Customer(3,"Tejas","Gowda",27);
        Customer anurag = new Customer(5,"Anurag","Mishra",27);

        //save customer to Elastic_Search
        customerRepository.save(amit);
        customerRepository.save(sid);
        customerRepository.save(tejas);
        customerRepository.save(anurag);

    }


    public void lookup(){

        System.out.println("===================Lookup Customers from Cassandra by Firstname===================");
        List<Customer> amits = customerRepository.findByFirstName("Amit");
        amits.forEach(x -> System.out.println(x)); // this is same as amits.forEach(System.out::println);


        System.out.println("=================looking by lastname===============");
        List<Customer> last = customerRepository.findByLastName("Gowda");
        last.forEach(System.out::println);

        System.out.println("===================Lookup Customers from Cassandra by Age===================");
        List<Customer> custsAgeGreaterThan25 = customerRepository.findByAgeGreaterThan(25);
//        List<Customer> custsAgeGreaterThan25 = customerRepository.findByAgeAllowFiletring(25); // JPA FUNCTIONAL
        custsAgeGreaterThan25.forEach(System.out::println); // this is same as custsAgeGreaterThan25.forEach(x -> System.out.println(x));

    }

}
