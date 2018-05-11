package Cass.domain;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Customer {
    @PrimaryKey
    private int id;
    private String firstname;
    private String lastname;
    private int age;


    public Customer() {
    }

    public Customer(int id, String fisrtname, String lastname, int age) {
        this.id = id;
        this.firstname = fisrtname;
        this.lastname = lastname;
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFisrtname() {
        return firstname;
    }

    public void setFisrtname(String fisrtname) {
        this.firstname = fisrtname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString (){
        return String.format("Customer[id=%d, firstname=%s, lastname=%s, age=%d]", this.id, this.firstname, this.lastname, this.age);
    }

}
