package revision.equalhashcode;

import java.util.*;

public class EqualHashCode {
    public static void main(String[] args) {
        List<Student> stdList = Arrays.asList(
                new Student(UUID.randomUUID(), "James"),
                new Student(UUID.randomUUID(), "John"),
                new Student(UUID.randomUUID(), "Peter"),
                new Student(UUID.randomUUID(), "Andrew"),
                new Student(UUID.randomUUID(), "Thomas"));

        System.out.println("Before sorting: " + stdList);

        List<Student> sortedAlphabet = stdList.stream()
                                              .sorted(Comparator.comparing(Student::getName)
                                                                .reversed())
                                              .toList();
        System.out.println("After sorting: " + sortedAlphabet);

    }
}

class Student {
    private UUID id;
    private String name;

    public Student(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return Objects.equals(id, student.id) && Objects.equals(name, student.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name);
//    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student std = (Student) o;

        return Objects.equals(id, std.id);
    }

    @Override
    public String toString() {
        return String.format("{name: %s}", this.name);
    }
}
