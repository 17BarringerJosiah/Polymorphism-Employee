import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private String address;
    private int age;
    private String type;

    public Employee(String firstName, String lastName, String socialSecurityNumber, String address, int age, String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.address = address;
        this.age = age;
        this.type = type;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return String.format("%s %s%nsocial security number: %s", this.getFirstName(), this.getLastName(), this.getSocialSecurityNumber(), this.getAddress(), this.age, this.type);
    }


    public abstract double earnings();

}


