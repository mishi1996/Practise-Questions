//                  JAVA 8 programming Questions to practise
// Lambda & Stream API
//Find the first non-repeated character in a given string using Java 8 features.
//Sort a list of employees by salary and then by name.
//Group employees by department.
//Find the highest paid employee in each department.
//Flatten a list of lists using flatMap().
//Given a list of integers, remove duplicates and return them sorted in descending order.
//Convert a list of strings to uppercase and remove duplicates.
//Calculate the average salary of all employees using Stream API.
//Partition a list of integers into even and odd using partitioningBy().
//Find the second highest salary in a list of employees.

package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practise {


    public static void main(String[] args){

        //Find the first non-repeated character in a given string using Java 8 features.
         String s="Mishikans";
            Character h=s.chars().mapToObj(c->Character.toLowerCase((char)c)).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue()==1)
                .map(e->e.getKey())
                .findFirst().orElse(null) ;
            System.out.println(h);

       //Sort a list of employees by name.
        List<Employee> employee=new ArrayList<Employee>();
        employee.add(new Employee(1,"Mishika","yufyu",874367));
        employee.add(new Employee(2,"Karan","ugdgs",76434));
        employee.add(new Employee(3,"shivam","hdygsd",765327));
            List <Employee> employees= employee.stream().sorted(Comparator.comparing(Employee::getName)).toList();
                System.out.println(employees.toString());

        //Group employees by address
        Set<String> group=employees.stream().map(Employee::getAddress).collect(Collectors.toSet());
            System.out.println(group);

        //Find the highest paid employee
        employees.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

        //Flatten a list of lists using flatMap()
        List<String> test=Arrays.asList("a","dsd","wsd","tfyt");
        List<String> test1=Arrays.asList("ab","dsds","wsdf","tfytr");
            List<String> result=test.stream().flatMap(e->test1.stream()).collect(Collectors.toList());
             System.out.println(result);

        //Given a list of integers, remove duplicates and return them sorted in descending order.
        List<Integer> type=List.of(2,3,5,6,3,7,8,2);
            type.stream().distinct().sorted().toList().forEach(System.out::println);

        //convert a list of strings to uppercase and remove duplicates.
        List<String> types=Arrays.asList("a","dsd","wsd","tfyt","dsd");
             types.stream().map(String::toUpperCase).distinct().forEach(System.out::println);

        // Calculate the average salary of all employees using Stream API.
        Double sum=employee.stream().collect(Collectors.averagingInt(Employee::getSalary));
         System.out.println(sum);

        //Partition a list of integers into even and odd using partitioningBy()
        Map<Boolean,List<Integer>> resultant= type.stream().collect(Collectors.partitioningBy(j->j%2==0));

            System.out.println(resultant);

       //Find the second-highest salary in a list of employees.
        employee.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().ifPresent(System.out::println);


        //Write a function using Predicate to filter names starting with "A".
         List<String> find=List.of("yfdyu","Afdgyu","Adfytfwq");
            Set<String> answer= find.stream().filter(l->l.startsWith("A")).collect(Collectors.toSet());
                System.out.println(answer);

        //Use Function to convert a list of strings into their lengths.
         Set<Integer> findo=find.stream().map(String::length).collect(Collectors.toSet());
            System.out.println(findo);

    }






}
