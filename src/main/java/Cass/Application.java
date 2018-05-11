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
        Customer amit_2 = new Customer(4,"Amit","Sawant",40);

        //save customer to Elastic_Search
        customerRepository.save(amit);
        customerRepository.save(sid);
        customerRepository.save(tejas);
        customerRepository.save(amit_2);

    }


    public void lookup(){

        System.out.println("===================Lookup Customers from Cassandra by Firstname===================");
        List<Customer> amits = customerRepository.findByFirstname("Amit");
        amits.forEach(x -> System.out.println(x)); // this is same as amits.forEach(System.out::println);

        System.out.println("===================Lookup Customers from Cassandra by Age===================");
        List<Customer> custsAgeGreaterThan25 = customerRepository.findCustomerHasAgeGreaterThan(25);
        custsAgeGreaterThan25.forEach(System.out::println); // this is same as custsAgeGreaterThan25.forEach(x -> System.out.println(x));

    }

}
