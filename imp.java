import java.util.*;

class Student {
    private String name;
    private int id;
    private List<Boolean> attendance;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.attendance = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Boolean> getAttendance() {
        return attendance;
    }

    public void markAttendance(boolean present) {
        attendance.add(present);
    }
}

public class AttendanceManagementSystem {
    private List<Student> students;

    public AttendanceManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, int id) {
        Student student = new Student(name, id);
        students.add(student);
    }

    public void markAttendance(int studentId, boolean present) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                student.markAttendance(present);
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    public void viewAttendance(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                System.out.println("Attendance for student " + student.getName() + ":");
                List<Boolean> attendance = student.getAttendance();
                for (int i = 0; i < attendance.size(); i++) {
                    System.out.println("Week " + (i + 1) + ": " + (attendance.get(i) ? "Present" : "Absent"));
                }
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    public static void main(String[] args) {
        AttendanceManagementSystem ams = new AttendanceManagementSystem();

        // Adding students
        ams.addStudent("John", 1);
        ams.addStudent("Alice", 2);
        ams.addStudent("Bob", 3);

        // Marking attendance
        ams.markAttendance(1, true);
        ams.markAttendance(2, true);
        ams.markAttendance(3, false);

        // Viewing attendance
        ams.viewAttendance(1);
        ams.viewAttendance(2);
        ams.viewAttendance(3);
    }
}
