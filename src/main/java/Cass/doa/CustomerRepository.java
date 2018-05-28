package Cass.doa;

import Cass.domain.Customer;
//import org.springframework.data.cassandra.repository.AllowFiltering;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, String> {

    /*  comment @Query annotations are for lower version of spring boot*/
//    @Query(value="SELECT * from customer WHERE firstname=?0")
    public List<Customer>  findByFirstName(String firstname );
    @AllowFiltering
    public List<Customer> findByLastName(String lastname);

//   @Query(value="SELECT * from customer WHERE age > ?0")s
    @AllowFiltering
   public List<Customer> findByAgeGreaterThan(int age);  /* this gives error without @Query*/
//    public List<Customer> findByAgeAllowFiletring(int age);


    /* for spring boot 2 we directly use @AllowFiltering with JPA functions*/
//    @AllowFiltering
//    public List<Customer> findByFirstname(String firstname);
//
//    @AllowFiltering
//    public List<Customer> findCustomerHasAgeGreaterThan(int age);

}
