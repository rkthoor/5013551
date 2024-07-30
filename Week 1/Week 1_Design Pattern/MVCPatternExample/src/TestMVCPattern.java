// src/TestMVCPattern.java
public class TestMVCPattern {
    public static void main(String[] args) {
        // Student model
        Student student = new Student("Harsh", 101, "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Kumar");
        controller.setStudentId(201);
        controller.setStudentGrade("B");

        controller.updateView();
    }
}
