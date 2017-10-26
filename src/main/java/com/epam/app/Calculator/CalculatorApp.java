package com.epam.app.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Iana_Kasimova on 10/26/2017.
 */
public class CalculatorApp {

    public static void main(String[] args) {
        BufferedReader br = null;
        String input ="";
        try {


            while (true) {
                System.out.println("Enter a expression");
                input = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Calculator calc = ctx.getBean("calc");
        try{
            calc.validation(input);
        }catch (Exception e){
            System.out.println("expression is not valid, try again!");
        }
        calc.calculate(input);
    }
}
