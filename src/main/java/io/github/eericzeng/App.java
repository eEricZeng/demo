package io.github.eericzeng;

public class App {

    public static void main(String[] args) {
        Student std = new Student();
        std.setId(10001);
        std.setAge(18);
        std.setName("小明");
        std.setGender("male");
        System.out.println(std.toString());

        // builder pattern
        Student s = new Student.Builder().id(10001).age(18).name("小明").gender("male").build();
        System.out.println(s.toString());
    }

}
