package pro.sky.java.course2.mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {
    private final StudentValueGenerator studentValueGenerator;

    public University(StudentValueGenerator studentValueGenerator) {
        this.studentValueGenerator = studentValueGenerator;
    }

    Map<Integer, Student> allStudents = new HashMap<Integer, Student>();
    private int countId = 1;

    public void addStudent(Student student) {
        if (allStudents == null) {
            allStudents = new HashMap<Integer, Student>();
        }
        student.setId(countId);
        studentValueGenerator.generateAge();
        student.setAge(studentValueGenerator.generateAge());
        allStudents.put(countId, student);
        countId++;
    }

    public void addStudentInRange(Student student, int minYear, int maxYear) {
        if (allStudents == null) {
            allStudents = new HashMap<Integer, Student>();
        }
        student.setId(countId);
        studentValueGenerator.generateAge();
        studentValueGenerator.generateAge();
        student.setAge(studentValueGenerator.generateAgeInRange(minYear,maxYear));
        allStudents.put(countId, student);
        countId++;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<Student>(allStudents.values());
    }
    public List<Student> getAllStudents(boolean isMale) {
        List<Student> ListAllStudents = new ArrayList<Student>();
        for (Student student:allStudents.values()
        ) {
            if (student.isMale() == isMale) {
                ListAllStudents.add(student);
            }
        }
        return ListAllStudents;
    }
}
