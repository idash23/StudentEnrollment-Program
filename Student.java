import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Student {

    private String firstName;
    private String lastName;
    private String id;
    private int year;
    private List<String> courses; // data members

    private Scanner keyboard = new Scanner(System.in);

    public Student(String MyFirstName, String MyLastName, int MyYear) {
        firstName = MyFirstName;
        lastName = MyLastName;
        year = MyYear;

    } // end of Student Constructor

    private Student(String firstName, String lastName, String id, int year) {
        firstName = "";
        lastName = "";
        id = "";
        year = 0;

    } // default constructor


    //Getters and Setters


    private void setFirstName(String MyfirstName) {
        firstName = MyfirstName;
    }

    private String getName() {
        return firstName + " " + lastName;
    }

    private void setLastName(String MylastName) {
        lastName = MylastName;
    }

    private String getId() {
        return id;
    }

    private void setId(String Myid) {
        id = Myid;
    }

    public void setYear( int MyYear ) { year = MyYear;}

    private int getYear() {return year;}

    private List<String> getCourses() {
        return courses;
    }

    private void setCourses(List<String> MyCourses) {
        courses = MyCourses;
    }

    /**
     * Creates a year using a number from 1 - 4 given by the user and a random string of length 4.
     */

    public void makeID() {
        String setYear;
        boolean checked = false;

        while (!checked) {
            System.out.println("Enter year classification:  1. Freshman, 2. Sophomore, 3.Junior and 4. Senior ");
            setYear = keyboard.nextLine();
            if (setYear.length() == 1 && Integer.parseInt(setYear) > 0 && Integer.parseInt(setYear) < 5) {
                setId(setYear.concat(randomString()));
                checked = true;
            } else {
                System.out.println("The input you enter is incorrect please try again");
            }
        }

    }

    /**
     * Returns a randomly generated 4 character string that will combined with a number entered by the user to make the student id.
     *
     * @return The four character random string
     */
    private String randomString() {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        int great = AB.length();
        int temp;
        String codeword = "";
        for (int i = 0; i < 4; i++) {
            temp = (int) (random.nextFloat() * great);
            codeword = codeword.concat(Character.toString(AB.charAt(temp)));
        }
        return codeword;

    } //to generate random student ID from 0-z



    /**
     * Gives the student the class they entered the corresponding number for a class
     *
     *  classes      - A list that contains the classes a student has at the moment.
     * courseNumber - A number that represent a particular class.
     */
    private void chooseCourses(List<String> classes, int courseNumber) {

        switch (courseNumber) {
            case 1:
                if (checkDups(classes, "History 101"))
                    classes.add("History 101");
                else classes.remove("History 101");
                break;
            case 2:
                if (checkDups(classes, "Calculus 201"))
                    classes.add("Calculus 201");
                else classes.remove(" Calculus 201 ");
                break;
            case 3:
                if (checkDups(classes, "English 103"))
                    classes.add("English 103");
                else classes.remove("English 103");
                break;
            case 4:
                if (checkDups(classes, "Chemistry 301"))
                    classes.add("Chemistry 301");
                else classes.remove("Chemistry 301");
                break;
            case 5:
                if (checkDups(classes, "Physics 402"))
                    classes.add("Physics 402");
                else classes.remove("Physics 402");
                break;
            case 6:
                if (checkDups(classes, "Art 602"))
                    classes.add("Art 601");
                else classes.remove("Art 602");
                break;
            case 7:
                if (checkDups(classes, " Economics 701 "))
                    classes.add(" Economics 701 ");
                else classes.remove(" Economics 701 ");
                break;
            case 8:
                if (checkDups(classes, " Psychology 801 "))
                    classes.add(" Psychology 801 ");
                else classes.remove(" Psychology 801 ");
                break;
            case 9:
                if (checkDups(classes, "Programming 901 "))
                    classes.add(" Programming 901 ");
                else classes.remove(" Programming 901 ");
                break;

            default:
                System.out.println("You gave the wrong input");
                break;
        }
    } //end of ChooseCourses

    /**
     * Allows the user to add classes keeping track of classes they already added
     */
    private void addCourses() {
        List<String> classes = new LinkedList<>();
        setCourses(classes);

        String answer;
        int nextCourse;
        int size;


        System.out.println("Do you want to add any courses? yes or no");
        answer = keyboard.nextLine();

        while (!answer.toLowerCase().equals("no")) {

            if (answer.toLowerCase().equals("yes"))
            {
                System.out.println("Which classes would you like to add now? Please choose from the following selection. " +
                        "Choose the number for the courses ");
                System.out.println("1. History 101");
                System.out.println("2. Calculus 201");
                System.out.println("3. English 103");
                System.out.println("4. Chemistry 301");
                System.out.println("5. Physics 402");
                System.out.println("6. Art 601 ");
                System.out.println("7. Economics 701 ");
                System.out.println("8. Psychology 801");
                System.out.println("9. Programming 901");


                if (keyboard.hasNextInt()) {
                    nextCourse = keyboard.nextInt();
                    keyboard.nextLine();
                    chooseCourses(classes, nextCourse);

                } else {
                    System.out.println("You put in the wrong input: Enter a number 1 - 5 for each class");
                    keyboard.nextLine();
                }

            } else {
                System.out.println("You put in the wrong input: Enter either yes or no next time");
            }

            System.out.println("Do you want to add any more courses?");
            answer = keyboard.nextLine();

        }

    }

    /**
     *  list - The list containing the student's current classes
     *  word - The string that being checked to see if it is unique in the list
     * @return Whether or not the string is already in the list
     */
    private boolean checkDups(List<String> list, String word) {
        for (String temp : list) {
            if (word.equals(temp)) {
                System.out.println("You are already enrolled in that course");
                return false;
            }
        }
        return true;
    }

    /**
     * Prints out each student's name, id ,year and courses
     *
     *  studentList - All the students enrolled and in the list
     */
    private void displayInfo(Student[] studentList) {
        for (Student student : studentList) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student Year: " + student.getYear());

            if (student.getCourses().size() > 0) {
                System.out.println("Student's Current Courses:" + student.getCourses());
            } else {

                System.out.println("Student's Current Courses: The student isn't enrolled in any courses");

                System.out.println();


            }

        }

    }

    public static void main(String[] args) {
        try {

            System.out.println(" --------- Welcome to the College University Enrollment System ---------- ");
            System.out.println();

            int size;
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Please enter the number of student(s) you wish to add to the system");
            size = keyboard.nextInt();
            keyboard.nextLine();

            Student[] students = new Student[ size ];
            Student student;
            String firstName = "";
            String lastName = "";
            String id = "";
            int year = 0;

            for (int i = 0; i < size; i++) {
                student = new Student(firstName, lastName, id, year);
                students[i] = student;

                System.out.println("Please enter first name for Student enrolling ");
                firstName = keyboard.nextLine();
                student.setFirstName(firstName);

                System.out.println("Please enter name");
                lastName = keyboard.nextLine();
                student.setLastName(lastName);

                System.out.println("Please make Student ID? yes or no");
                id = keyboard.nextLine();
                student.setId(id);

                System.out.println("Please make Student Year 1. 1st Year,  2. Second Year. 3. Third Year.  4. Fourth Year.  ");
                year = keyboard.nextInt();
                student.setYear(year);


                student.makeID();
                student.addCourses();

                System.out.println(" Congratulations you have successfully registered!  ");
                System.out.println();

                if (i == size - 1 )
                    student.displayInfo(students);



            }
        } catch (NegativeArraySizeException e) {
            System.out.println("You can't use a negative number for size");


        }
    }// end of main

}  //end of Student class

