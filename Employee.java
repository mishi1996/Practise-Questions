package org.example;

public class Employee {

    public int id;
    public String name;
    public String address;
    public int salary;

    public Employee(int id, String name, String address, int  salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;

    }

    public Employee() {

    }


        @Override
        public String toString() {
            return "Employee{" +
                   "id=" + id +
                   ", name='" + name + '\'' +
                   ", address='" + address + '\'' +
                    ", salary='" + salary + '\'' +
                   '}';
        }public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int  getSalary() {
        return salary;
    }
    public void setSalary(int  salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }


}
