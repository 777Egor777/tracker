package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 09.02.2021
 */
public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.scan("ru.job4j.di");
        context.refresh();
        StartUI ui = context.getBean("startUI", StartUI.class);
        ui.add("Petr Arsentev");
        ui.add("Ivan Ivanov");
        ui.print();
        context.close();
    }
}
