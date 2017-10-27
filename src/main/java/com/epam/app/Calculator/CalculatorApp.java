package com.epam.app.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.Scanner;

/**
 * Created by Iana_Kasimova on 10/26/2017.
 */

public class CalculatorApp {

    Calculator calc;

    public CalculatorApp(Calculator calc){
        this.calc = calc;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Enter a expression");
            String input = scanner.nextLine();
            scanner.close();

            ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
            Calculator calc = (Calculator) ctx.getBean("calculator");
            try {
                calc.validation(input);
                System.out.println(calc.calculate(input));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("expression is not valid, try again!");
            }
        }
    }
}
