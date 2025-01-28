package singlylinkedlist.studentrecordmanagement;

class StudentLinkedList {
    private Student head;

    public void addStudentAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addStudentAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addStudentAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        Student newStudent = new Student(rollNumber, name, age, grade);

        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }

        Student temp = head;
        for (int i = 1; i < position - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }

        if (temp != null) {
            newStudent.next = temp.next;
            temp.next = newStudent;
        } else {
            System.out.println("Position out of bounds.");
        }
    }

    public void deleteStudentByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Student record deleted.");
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student record not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student record deleted.");
        }
    }

    public void searchStudentByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student record not found.");
    }

    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public void updateStudentGrade(int rollNumber, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Student grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student record not found.");
    }
}
