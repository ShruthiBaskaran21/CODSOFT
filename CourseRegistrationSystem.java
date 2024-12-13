import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    int enrolled;

    Course(String courseCode, String title, String description, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0; // No students enrolled initially
    }

    // Check if there are available slots in the course
    boolean hasAvailableSlots() {
        return enrolled < capacity;
    }

    // Enroll a student in the course
    void enrollStudent() {
        if (hasAvailableSlots()) {
            enrolled++;
        }
    }

    // Drop a student from the course
    void dropStudent() {
        if (enrolled > 0) {
            enrolled--;
        }
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + "\n" +
               "Title: " + title + "\n" +
               "Description: " + description + "\n" +
               "Capacity: " + capacity + "\n" +
               "Enrolled: " + enrolled + "\n" +
               "Available Slots: " + (capacity - enrolled);
    }
}

class Student {
    String studentID;
    String name;
    ArrayList<Course> registeredCourses;

    Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    // Register for a course
    void registerForCourse(Course course) {
        if (course.hasAvailableSlots()) {
            course.enrollStudent();
            registeredCourses.add(course);
            System.out.println("Successfully registered for " + course.title);
        } else {
            System.out.println("Sorry, no available slots in " + course.title);
        }
    }

    // Drop a course
    void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            course.dropStudent();
            registeredCourses.remove(course);
            System.out.println("Successfully dropped " + course.title);
        } else {
            System.out.println("You are not registered for this course.");
        }
    }

    // Display the registered courses
    void displayRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered yet.");
        } else {
            System.out.println("Registered Courses:");
            for (Course course : registeredCourses) {
                System.out.println(course.title);
            }
        }
    }
}

public class CourseRegistrationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some sample courses
        Course course1 = new Course("CS101", "Introduction to Programming", "Learn the basics of programming.", 3);
        Course course2 = new Course("CS102", "Data Structures", "Introduction to data structures.", 2);
        Course course3 = new Course("CS103", "Database Systems", "Learn about relational databases.", 4);

        // Add courses to a list
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        // Create a student
        System.out.print("Enter your student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter your name: ");
        String studentName = scanner.nextLine();
        Student student = new Student(studentID, studentName);

        boolean exit = false;

        // Main program loop
        while (!exit) {
            System.out.println("\n1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Display available courses
                    System.out.println("\nAvailable Courses:");
                    for (Course course : courses) {
                        System.out.println(course);
                        System.out.println("------------------------------------------------------");
                    }
                    break;

                case 2:
                    // Register for a course
                    System.out.println("\nEnter the course code to register:");
                    String courseCodeToRegister = scanner.nextLine();
                    Course courseToRegister = null;
                    for (Course course : courses) {
                        if (course.courseCode.equals(courseCodeToRegister)) {
                            courseToRegister = course;
                            break;
                        }
                    }
                    if (courseToRegister != null) {
                        student.registerForCourse(courseToRegister);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 3:
                    // Drop a course
                    System.out.println("\nEnter the course code to drop:");
                    String courseCodeToDrop = scanner.nextLine();
                    Course courseToDrop = null;
                    for (Course course : courses) {
                        if (course.courseCode.equals(courseCodeToDrop)) {
                            courseToDrop = course;
                            break;
                        }
                    }
                    if (courseToDrop != null) {
                        student.dropCourse(courseToDrop);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 4:
                    // View registered courses
                    student.displayRegisteredCourses();
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting the system...");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
