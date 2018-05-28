package Cass.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Customer {
    @PrimaryKey
    private int id;
    private String firstName;
    private String lastName;
    private int age;


    public Customer() {
    }

    public Customer(int id, String fisrtname, String lastname, int age) {
        this.id = id;
        this.firstName = fisrtname;
        this.lastName = lastname;
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFisrtname() {
        return firstName;
    }

    public void setFisrtname(String fisrtname) {
        this.firstName = fisrtname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString (){
        return String.format("Customer[id=%d, firstName=%s, lastName=%s, age=%d]", this.id, this.firstName, this.lastName, this.age);
    }

}
