import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Utility class for Student CRUD Operations
 * 
 * @author Sreelatha
 *
 */

public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	int totalStudents;
	int currentIndex = 0;

	/**
	 * @param length
	 */
	public StudentGroup(int length) {
		if (length <= 0)
			throw new IllegalArgumentException("Length value must be > 0 ");

		this.students = new Student[length];
		this.totalStudents = length;
	}

	/**
	 * Returns the array of students
	 * 
	 * @return the array of students
	 * 
	 */
	@Override
	public Student[] getStudents() {
		return students;
	}

	/**
	 * Sets the array of students if students == null method should throw
	 * IllegalArgumentException
	 *
	 * @param students
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public void setStudents(Student[] students) {

		if (students == null)
			throw new IllegalArgumentException("Students must not be null.");

		this.students = students;
		this.currentIndex = currentIndex + students.length;
	}

	/**
	 * if index lower than 0 or index higher/equal students.length method should
	 * throw IllegalArgumentException
	 *
	 * @param index
	 */

	@Override
	public Student getStudent(int index) {
		checkStudentRangeForInvalidRange(index);
		if (index < currentIndex) {
			return students[index];
		}
		return null;
	}

	/**
	 * Replaces the element at the specified position in this array with the
	 * specified element. if student == null method should throw
	 * IllegalArgumentException if index lower than 0 or index higher/equal
	 * students.length method should throw IllegalArgumentException
	 *
	 * @param student
	 *            the student to be stored at the specified position
	 * @param index
	 *            the index of the element to replace
	 * 
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public void setStudent(Student student, int index) {
		checkStudentRangeForInvalidRange(index);
		students[index] = student;
	}

	/**
	 * Appends the specified element to the specified position of this array if
	 * student == null method should throw IllegalArgumentException if index
	 * lower than 0 or index higher/equal students.length method should throw
	 * IllegalArgumentException
	 *
	 * @param student
	 *            the element to be appended to this array at the specified
	 *            position
	 * @param index
	 *            the specified position
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public void add(Student student, int index) {
		checkStudent(student);
		checkStudentRangeForInvalidRange(index);
		students[index] = student;
	}

	/**
	 * Inserts the specified element at the beginning of this array if student
	 * == null method should throw IllegalArgumentException
	 *
	 * @param student
	 *            the element to add
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public void addFirst(Student student) {
		checkStudent(student);

		Student tempStu[] = students;
		students = new Student[totalStudents];
		students[0] = student;
		for (int i = 1; i <= tempStu.length; i++) {
			students[i] = tempStu[i - 1];
		}
	}

	/**
	 * Appends the specified element to the end of this array. if student ==
	 * null method should throw IllegalArgumentException
	 *
	 * @param student
	 *            the element to add
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public void addLast(Student student) {
		checkStudent(student);
		students[totalStudents - 1] = student;
	}

	/**
	 * Removes the element at the specified position in this array if index
	 * lower than 0 or index higher/equal students.length method should throw
	 * IllegalArgumentException
	 *
	 * @param index
	 *            the index of the element to be removed
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public void remove(int index) {
		checkStudentRange(index);
		List<Student> studentList = new ArrayList<>(Arrays.asList(students));
		studentList.remove(index);
		students = studentList.toArray(new Student[0]);
		currentIndex = students.length;
	}

	/**
	 * Removes the first occurrence of the specified element from this array, if
	 * it is present. If this array does not contain the element, it is
	 * unchanged and should throw IllegalArgumentException with "Student not
	 * exist" message if student == null method should throw
	 * IllegalArgumentException
	 *
	 * @param student
	 *            the element to remove
	 * 
	 * @throws IllegalArgumentException
	 */

	@Override
	public void remove(Student student) {
		checkStudent(student);
		for (int index = 0; index < currentIndex; index++) {
			if (students[index].equals(student)) {
				remove(index);
			}
		}
	}

	/**
	 * Removes all elements from the specified index (except the element with
	 * specified index) from this array if index lower than 0 or index
	 * higher/equal students.length method should throw IllegalArgumentException
	 *
	 * @param index
	 *            the index elements from should be removed
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public void removeFromIndex(int index) {
		checkStudentRangeForInvalidRange(index);
		// currentIndex = totalStudents - currentIndex - index;

		// System.arraycopy(students, index, students, 0, length);
	}

	/**
	 * Removes all elements from the specified element (except the specified
	 * element) from this array if student == null method should throw
	 * IllegalArgumentException
	 *
	 * @param student
	 *            the element from elements should be removed
	 * 
	 * @throws IllegalArgumentException
	 */

	@Override
	public void removeFromElement(Student student) {
		checkStudent(student);

	}

	/**
	 * Removes all elements to the specified index (except the element with the
	 * specified index) from this array if index lower than 0 or index
	 * higher/equal students.length method should throw IllegalArgumentException
	 *
	 * @param index
	 *            the index elements to should be removed
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public void removeToIndex(int index) {
		checkStudentRangeForInvalidRange(index);
	}

	/**
	 * Removes all elements to the specified element (except the specified
	 * element) from this array if student == null method should throw
	 * IllegalArgumentException
	 *
	 * @param student
	 *            the element to elements should be removed
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public void removeToElement(Student student) {
		checkStudent(student);

	}

	/**
	 * Performs Bubble Sort to this array
	 *
	 */
	@Override
	public void bubbleSort() {
		for (int i = 0; i < currentIndex - 1; i++) {
			for (int j = 0; j < currentIndex - i - 1; j++) {
				if (students[j].compareTo(students[j + 1]) > 0) {
					Student tmp = students[j];
					students[j] = students[j + 1];
					students[j + 1] = tmp;
				}

			}
		}
	}

	/**
	 * Returns all students with birthday to the specified date if date == null,
	 * method should throw IllegalArgumentException
	 * 
	 * @param date
	 *            the date that specify birthday to find students who was born
	 *            before that date and in that date
	 * 
	 * @return the array of students who was born before/in specified date
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public Student[] getByBirthDate(Date date) {

		if (date == null)
			throw new IllegalArgumentException("Date must not be null");

		List<Student> stuByBirthDate = new ArrayList<>();
		for (int i = 0; i < currentIndex; i++) {
			Student student = students[i];
			Date dob = student.getBirthDate();
			if (dob.compareTo(date) == 0) {
				stuByBirthDate.add(student);
			}
		}
		return stuByBirthDate.toArray(new Student[0]);
	}

	/**
	 * Returns all students with birthday to the specified range of dates
	 * including specified dates if firstDate == null or lastDate == null,
	 * method should throw IllegalArgumentException
	 * 
	 * @param firstDate
	 *            the date that specify birthday to find students from
	 * @param lastDate
	 *            the date that specify birthday to find students to
	 * 
	 * @return the array of students who was born in specified range of dates
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {

		return null;
	}

	/**
	 * Returns all students with birthday to the specified date and in several
	 * days after the specified date if date == null, method should throw
	 * IllegalArgumentException
	 * 
	 * @param date
	 *            the date that specify birthday to find students from
	 * @param days
	 *            the number of days that specify the end date
	 * 
	 * @return the array of students who has birthday in specified date and
	 *         several days after
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		if (date == null)
			throw new IllegalArgumentException("Date must not be null");

		return null;
	}

	/**
	 * Find student at the specified position and calculate his age (total
	 * years) if indexOfStudent == 0, method should throw
	 * IllegalArgumentException
	 * 
	 * @param indexOfStudent
	 *            the index to find student and calculate age
	 * 
	 * @return student full years
	 * 
	 * @throws IllegalArgumentException
	 */

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		checkStudentRangeForInvalidRange(indexOfStudent);
		Student student = students[indexOfStudent];
		return getAge(student.getBirthDate());
	}

	/**
	 * Returns all students with age equal the specified age
	 * 
	 * @param age
	 *            the age to find students
	 * 
	 * @return the array of students of the specified age
	 */
	@Override
	public Student[] getStudentsByAge(int age) {
		List<Student> stuByAge = new ArrayList<>();
		for (int i = 0; i < currentIndex; i++) {
			Student student = students[i];
			Date dob = student.getBirthDate();
			int stuAge = getAge(dob);
			if (stuAge == age) {
				stuByAge.add(student);
			}
		}
		return stuByAge.toArray(new Student[0]);
	}

	public static int getAge(Date date) {

		int age = 0;

		Calendar now = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();
		dob.setTime(date);
		if (dob.after(now)) {
			throw new IllegalArgumentException("Can't be born in the future");
		}

		int year1 = now.get(Calendar.YEAR);
		int year2 = dob.get(Calendar.YEAR);
		age = year1 - year2;

		int month1 = now.get(Calendar.MONTH);
		int month2 = dob.get(Calendar.MONTH);

		if (month2 > month1) {
			age--;
		} else if (month1 == month2) {
			int day1 = now.get(Calendar.DAY_OF_MONTH);
			int day2 = dob.get(Calendar.DAY_OF_MONTH);
			if (day2 > day1) {
				age--;
			}
		}
		return age;
	}

	/**
	 * Finds the maximum average mark for all students in this array and returns
	 * all students who has the maximum average mark
	 * 
	 * @return the array of students who has maximum average mark
	 * 
	 */
	@Override
	public Student[] getStudentsWithMaxAvgMark() {

		List<Student> maxAvgStudents = new ArrayList<>();
		double totalAvg = 0;

		for (int i = 0; i < currentIndex; i++) {
			totalAvg = totalAvg + students[i].getAvgMark();
		}

		double maxAvgMarks = totalAvg / currentIndex;
		System.out.println("Total Avg marks: " + totalAvg + "\nMax Avg Marks: " + maxAvgMarks);

		for (Student st : students) {
			if (st.getAvgMark() >= maxAvgMarks) {
				maxAvgStudents.add(st);
			}
		}
		return maxAvgStudents.toArray(new Student[0]);
	}

	/**
	 * Finds element which is the next to the specified element if student ==
	 * null, method should throw IllegalArgumentException
	 * 
	 * @param student
	 *            the element to which take the next element
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public Student getNextStudent(Student student) {
		checkStudent(student);

		int nextStudentIndex = -1;
		for (int i = 0; i < currentIndex; i++) {
			if (students[i].equals(student)) {
				nextStudentIndex = i + 1;
				break;
			}
		}
		if (nextStudentIndex == -1) {
			return null;
		}
		return getStudent(nextStudentIndex);
	}

	private void checkStudentRangeForInvalidRange(int index) {
		if (index > totalStudents || index < 0)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private void checkStudentRange(int index) {
		if (index >= totalStudents)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private String outOfBoundsMsg(int index) {
		return "Student Index: " + index + ", Total Students: " + totalStudents;
	}

	private void checkStudent(Student student) {
		if (student == null)
			throw new IllegalArgumentException("Student value must not be null.");
	}
}
