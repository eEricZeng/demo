package io.github.eericzeng;

public class Student {

    private int id;

    private String name;

    private int age;

    private String gender;

    public Student() {
    }

    public Student(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }

    public static Student.StudentBuilder builder() {
        return new StudentBuilder();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static class StudentBuilder {

        private int id;

        private String name;

        private int age;

        private String gender;

        public StudentBuilder id(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Student build() {
            return new Student(this.id, this.name, this.age, this.gender);
        }
    }
}
