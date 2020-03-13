package ru.job4j.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class College {
    public static void main(String[] args) throws ParseException {
        Student student = new Student();
        student.setFio("Гераськин Егор Владимирович");
        student.setGroup(393);
        student.setAdmissionDate(new SimpleDateFormat("dd-MM-yyyy").parse("03-08-2013"));
        System.out.println("ФИО: " + student.getFio());
        System.out.println("Группа: " + student.getGroup());
        System.out.println("Дата поступления: " + new SimpleDateFormat("dd-MM-yyyy").
                format(student.getAdmissionDate()));
    }
}
