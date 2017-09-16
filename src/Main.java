import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Sreelatha
 *
 */
public class Main {

	public static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String args[]) {
		int totalStudents = 10;

		// StudentArrayOperation studentArrayOperation = new StudentGroup(0);
		StudentArrayOperation studentArrayOperation = new StudentGroup(totalStudents);

		testSetStudents(studentArrayOperation);

		testGetStudents(studentArrayOperation);

		testGetStudent(studentArrayOperation, -1);

		testGetStudent(studentArrayOperation, 4);

		testGetNextStudent(studentArrayOperation);

		testGetStudentsWithMaxAvgMark(studentArrayOperation);

		testGetStudentsByAge(studentArrayOperation);

		testGetCurrentAgeByDate(studentArrayOperation);

		testGetByBirthDate(studentArrayOperation);

		testBubbleSort(studentArrayOperation);

		testRemoveUsingIndex(studentArrayOperation);

		testRemoveUsingStudent(studentArrayOperation);
	}

	private static void testRemoveUsingStudent(StudentArrayOperation studentArrayOperation) {

		Student st = null;
		try {
			st = new Student(1, "Sreelatha", df.parse("1997-01-01"), 100);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("Removing the Student using " + st);
		studentArrayOperation.remove(st);

		System.out.println("After Removing students data: ");
		Student students[] = studentArrayOperation.getStudents();
		for (Student stu : students) {
			System.out.println(stu);
		}
		System.out.println();
	}

	private static void testRemoveUsingIndex(StudentArrayOperation studentArrayOperation) {
		System.out.println("Removing the Student using index 0");
		studentArrayOperation.remove(0);

		System.out.println("After Removing students data: ");
		Student students[] = studentArrayOperation.getStudents();
		for (Student stu : students) {
			System.out.println(stu);
		}
		System.out.println();
	}

	private static void testBubbleSort(StudentArrayOperation studentArrayOperation) {
		System.out.println("Sorting the students");

		Student students[] = studentArrayOperation.getStudents();
		System.out.println("\nBefore Sorting");
		for (Student stu : students) {
			System.out.println(stu);
		}

		studentArrayOperation.bubbleSort();

		students = studentArrayOperation.getStudents();
		System.out.println("\nAfter Sorting");
		for (Student stu : students) {
			System.out.println(stu);
		}
		System.out.println();
	}

	private static void testGetByBirthDate(StudentArrayOperation studentArrayOperation) {
		String strDate = "1997-01-01";
		Date date = null;
		try {
			date = df.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Getting the Students based on birthdate " + date);
		Student[] students = studentArrayOperation.getByBirthDate(date);
		for (Student st : students) {
			System.out.println(st);
		}
		System.out.println();
	}

	private static void testGetCurrentAgeByDate(StudentArrayOperation studentArrayOperation) {
		System.out.println("Getting the Current Age of the Student " + studentArrayOperation.getStudent(0));
		int age = studentArrayOperation.getCurrentAgeByDate(0);
		System.out.println("Student Age " + age);
		System.out.println();
	}

	private static void testGetStudentsByAge(StudentArrayOperation studentArrayOperation) {
		int age = 29;
		System.out.println("Getting the Student(s) with age " + age);
		Student students[] = studentArrayOperation.getStudentsByAge(age);
		for (Student st : students) {
			System.out.println(st);
		}
		System.out.println();
	}

	private static void testGetStudentsWithMaxAvgMark(StudentArrayOperation studentArrayOperation) {
		System.out.println("Getting the Student with max avg marks");
		Student students[] = studentArrayOperation.getStudentsWithMaxAvgMark();
		for (Student st : students) {
			System.out.println(st);
		}
		System.out.println();
	}

	private static void testGetNextStudent(StudentArrayOperation studentArrayOperation) {
		try {

			Student student = new Student(1, "Sreelatha", df.parse("1997-01-01"), 100);
			Student nextStudent = studentArrayOperation.getNextStudent(student);
			System.out.println("Displaying the next student value with valid student: " + nextStudent);

			student = new Student(2, "Sreelatha", df.parse("1997-01-01"), 100);
			nextStudent = studentArrayOperation.getNextStudent(student);
			System.out.println("Displaying the next student value with invalid student: " + nextStudent);

		} catch (ParseException e) {
			System.out.println(e);
		}
		System.out.println();
	}

	private static void testGetStudent(StudentArrayOperation studentArrayOperation, int index) {
		System.out.println("Getting the Student with index " + index);
		try {
			Student st = studentArrayOperation.getStudent(index);
			System.out.println("Student value will be " + st);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println();
	}

	private static void testGetStudents(StudentArrayOperation studentArrayOperation) {
		System.out.println("Displaying the all Students.");
		Student students[] = studentArrayOperation.getStudents();
		for (Student st : students) {
			System.out.println(st);
		}
		System.out.println();
	}

	private static void testSetStudents(StudentArrayOperation studentArrayOperation) {
		try {
			Student st1 = new Student(1, "Sreelatha", df.parse("1997-01-01"), 100);
			Student st2 = new Student(2, "Reddy", df.parse("1988-06-01"), 50);
			Student st3 = new Student(3, "Meena", df.parse("1992-02-22"), 80);
			Student st4 = new Student(4, "Bindu", df.parse("1995-04-15"), 10);
			// studentArrayOperation.setStudents(null);

			studentArrayOperation.setStudents(new Student[] { st1, st2, st3, st4 });

		} catch (ParseException e) {
			System.out.println(e);
		}
	}
}
