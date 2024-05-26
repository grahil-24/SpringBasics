package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //create spring context instance
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        //when there are more than one bean of same type, we need to refer them
        //by the method name
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        Parrot x = new Parrot();
        x.setName("kiki");
        Supplier<Parrot> parrotSupplier = () -> x;
        context.registerBean("parrot4", Parrot.class, parrotSupplier);
        Parrot parrot2 = context.getBean("parrot4", Parrot.class);

        Person person = context.getBean(Person.class);
        System.out.println(person.getParrot().getName());
    }
}
