package coursesRegistration.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import coursesRegistration.scheduler.levelCompare;
import coursesRegistration.util.FileProcessor;

/**
 * Class that cotains all the information related to Student
 */
public class Student {
	
	/**
	 * data members
	 */
	private int studentId;
	private String courseList;
	private String studentLevel;
	public String[] studentPreferences;
	private ArrayList<Student> studentsList;
	
	/**
	 * setters
	 */
	public void setStudentId(int studentId){
		this.studentId = studentId;
	}
	public void setCourseList(String courseList){
		this.courseList = courseList;
	}
	public void setStudentLevel(String studentLevel){
		this.studentLevel = studentLevel;
	}
	
	/**
	 * getters
	 */
	public int getStudentId(){
		return this.studentId;
	}
	public String getCourseList(){
		return this.courseList;
	}
	public String getStudentLevel(){
		return this.studentLevel;
	}
	public String getStudentPreferences(int index){
		return this.studentPreferences[index];
	}	
	
	public ArrayList getStudentLists(){
		return this.studentsList;
	}	

	/**
	 * Extracting the contents from file and storing it in an ArrayList of objects
	 */
	public void studentProcessing(String studentsFile){

		FileProcessor fp = new FileProcessor(studentsFile);
		
		String studentsInfo = null;
		this.studentsList = new ArrayList<Student>();

		String[] studentId;
		String[] courseList;

		/**
		 * Calling method of FileProcessor to read the courses file
		 */
		while ((studentsInfo = fp.readLineFromFile()) != null){
			
			/**
			 * Preprocessing student file and splitting them into proper attributes
			 */
			studentId = studentsInfo.split(" ");
			courseList = studentId[1].split("::");


			try{

				/**
            	 * Creating an arraylist of objects of type students whihc holds all data related to student info
	             */
				Student s = new Student();
				s.setStudentId(Integer.parseInt(studentId[0]));
				s.setCourseList(courseList[0]);
				s.setStudentLevel(courseList[1]);
				s.studentPreferences = courseList[0].split(",");
				
				this.studentsList.add(s);	
			
			}
			
			catch(Exception e){

				System.err.println("Index is out of bounds. Please check the formatting of input file");
				System.exit(0);
			}
			
			finally{}		

		}

		/**
		 * Sorting arrayList in such a way that all the third year student comes first then second year and then so on
		 */
		Collections.sort(this.studentsList, new levelCompare());
		Collections.reverse(this.studentsList);
		
	}

}

