package singlylinkedlist.studentrecordmanagement;

public class StudentManagement {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();

        studentList.addStudentAtEnd(1, "Alice", 20, "A");
        studentList.addStudentAtEnd(2, "Bob", 22, "B");
        studentList.addStudentAtBeginning(3, "Charlie", 19, "A+");
        studentList.addStudentAtPosition(2, 4, "Diana", 21, "B+");

        System.out.println("All students:");
        studentList.displayAllStudents();

        System.out.println("\nSearch for student with Roll Number 2:");
        studentList.searchStudentByRollNumber(2);

        System.out.println("\nUpdate grade for student with Roll Number 1:");
        studentList.updateStudentGrade(1, "A+");

        System.out.println("\nAll students after update:");
        studentList.displayAllStudents();

        System.out.println("\nDelete student with Roll Number 3:");
        studentList.deleteStudentByRollNumber(3);

        System.out.println("\nAll students after deletion:");
        studentList.displayAllStudents();
    }
}

