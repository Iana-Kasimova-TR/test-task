package com.epam.app.Chief;

import com.epam.app.Chief.IOStream.InputOutputStream;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.imageio.IIOException;
import java.io.IOException;

/**
 * Created by Iana_Kasimova on 10/30/2017.
 */
public class AppChief {

    private static InputOutputStream stream;

    public static void main( String[] args ){
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        stream = (InputOutputStream) ctx.getBean("stream");

        try {
            stream.read();
            stream.write("Hello!");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
