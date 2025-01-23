package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Hasan", "Yılmaz"));
        employees.add(new Employee(2, "Aslı", "Öztürk"));
        employees.add(new Employee(3, "Derya", "Çelik"));
        employees.add(new Employee(1, "Hasan", "Yılmaz"));  // Duplicate
        employees.add(new Employee(5, "Kadir", "Aydın"));
        employees.add(new Employee(3, "Derya", "Çelik"));  // Duplicate


        System.out.println(findDuplicates(employees));

        System.out.println("-----------------------------");


        System.out.println(findUniques(employees));

        System.out.println("-----------------------------");


        System.out.println(removeDuplicates(employees));

    }


    public static List<Employee> findDuplicates(List<Employee> employees) {
        Set<Employee> seen = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee employee : employees) {
            if (!seen.add(employee)) {
                duplicates.add(employee);
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Set<Employee> seen = new HashSet<>();
        Map<Integer, Employee> uniqueEmployees = new HashMap<>();

        for (Employee employee : employees) {
            if (!seen.add(employee)) {
                continue;
            }
            uniqueEmployees.put(employee.getId(), employee);
        }

        return uniqueEmployees;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniqueEmployees = findUniques(employees);
        List<Employee> removeDuplicate = new LinkedList<>();



        for (Employee duplicate : duplicates) {

            uniqueEmployees.remove(duplicate.getId());
        }
        removeDuplicate.addAll(uniqueEmployees.values());
        return removeDuplicate;

    }
}