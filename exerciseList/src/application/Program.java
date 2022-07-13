package application;

import entities.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Funcionario> list = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int nFunc = sc.nextInt();
        System.out.println();

        for (int i = 1; i<= nFunc; i++) {
            System.out.println("Employee #" + i + ": ");
            System.out.print("Id: ");
            int id = sc.nextInt();
            while (hasId(list, id)) {
                System.out.println("Id already taken. Try again: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            list.add(new Funcionario(id, name, salary));

        }

        // Parte 2 do exercicio, updating salary

        System.out.println();
        System.out.println("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        Funcionario emp = list.stream().filter(x -> x.getId()== id).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("This id does not exist!");
        }
        else {
            System.out.println("Enter percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        // Parte 3 do exercicio - Listing employees:

        System.out.println();
        System.out.println("List of employees: ");
        for (Funcionario obj : list) {
            System.out.println(obj);
        }

        sc.close();

    }

    private static boolean hasId(List<Funcionario> list, int id) {
        Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
