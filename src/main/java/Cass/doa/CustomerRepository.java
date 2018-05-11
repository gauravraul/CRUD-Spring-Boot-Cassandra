package Cass.doa;

import Cass.domain.Customer;
//import org.springframework.data.cassandra.repository.AllowFiltering;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, String> {

    /* for lower version of spring boot*/
    @Query(value="SELECT * from customer WHERE firstname=?0")
    public List<Customer>  findByFirstname(String firstname );

    @Query(value="SELECT * from customer WHERE age > ?0 ALLOW FILTERING")
    public List<Customer> findCustomerHasAgeGreaterThan (int age);


    /* for spring boot 2*/
//    @AllowFiltering
//    public List<Customer> findByFirstname(String firstname);
//
//    @AllowFiltering
//    public List<Customer> findCustomerHasAgeGreaterThan(int age);

}
