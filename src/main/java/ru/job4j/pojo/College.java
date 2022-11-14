package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setFullName("Ivanov Ivan Ivanovich ");
        student1.setGroup("1/12 ");
        student1.setDate("01.09.2016");
        System.out.println(student1.getFullName()
                + "зачислен в ИвГУ, в группу "
                + student1.getGroup()
                + student1.getDate());
    }
}
