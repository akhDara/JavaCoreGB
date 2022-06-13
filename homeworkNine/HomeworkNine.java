package homeworkNine;

import java.util.List;
import java.util.stream.Collectors;

public class HomeworkNine {

    public static void main(String[] args) {
        List<Student> students = Data.getStudentsList();
        Course randomCourse = Data.getRandomCourse();
        System.out.println(getUnicsCourses(students));
        System.out.println(inquisitiveStudents(students));
        System.out.println(getStudentsFromCourse(students, randomCourse));
    }


    public static List<Course> getUnicsCourses(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getAllCourses().stream())
                .distinct()
                .collect(Collectors.toList());
    }


    public static List<Student> inquisitiveStudents (List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> (s2.getAllCourses().size()) - (s1.getAllCourses().size()))
                .limit(3)
                .collect(Collectors.toList());
    }


    public static List<Student> getStudentsFromCourse(List<Student> students, Course course) {
        System.out.println("Студенты, которые проходят курс " + course);
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }

}
