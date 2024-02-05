package Lesson1;

public class Student {
    private String name;
    private String email;
    private String comments;
    public Teacher teacher;

    public Student() {
    }

    public Student(String name, String email, String comments, Teacher teacher) {
        this.name = name;
        this.email = email;
        this.comments = comments;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
