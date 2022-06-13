package homeworkNine;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Data {

    public static List<Student> getStudentsList() {
        // Список курсов
        Course course1 = new Course("Тестирование");
        Course course2 = new Course("Бизнес-процессы");
        Course course3 = new Course("Программирование");
        Course course4 = new Course("СММ");
        Course course5 = new Course("Автоматизация тестирования на Java");
        Course course6 = new Course("Тестирование backend на Java");


        // Список студентов
        Student student1 = new Student("Анна", Arrays.asList(course2, course3, course5));
        Student student2 = new Student("Дара", Arrays.asList(course1, course2, course3));
        Student student3 = new Student("Саша", Arrays.asList(course1, course6, course1));
        Student student4 = new Student("Маша", Arrays.asList(course2, course4, course2, course1, course3, course5));
        Student student5 = new Student("Ира", Arrays.asList(course3, course5, course4));
        Student student6 = new Student("Валера", Arrays.asList(course1, course3, course5, course3));
        Student student7 = new Student("Егор", Arrays.asList(course2, course6, course1, course5, course3));
        Student student8 = new Student("Сережа", Arrays.asList(course3, course2, course4));
        Student student9 = new Student("Даня", Arrays.asList(course2, course5, course5));
        Student student10 = new Student("Дима", Arrays.asList(course5, course1, course2));



        return Arrays.asList(student1, student2, student3, student4, student5, student6, student7,
                student8, student9, student10);
    }

    public static Course getRandomCourse() {
        Random random = new Random();
        List<Course> courses = getListCourses();
        return courses.get(random.nextInt(courses.size()));
    }

    private static List<Course> getListCourses() {
        return Arrays.asList(new Course("Тестирование"),
                new Course("Бизнес-процесс"),
                new Course("Программирование"),
                new Course("СММ"),
                new Course("Автоматизация тестирования на Java"),
                new Course("Тестирование backend на Java"));
    }
}
