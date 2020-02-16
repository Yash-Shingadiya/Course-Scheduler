package coursesRegistration.scheduler;

import java.util.ArrayList;
import coursesRegistration.scheduler.levelCompare;
import coursesRegistration.util.FileProcessor;


/**
 * Class that contains all info related to courses
 */
public class Courses{
	
	/**
	 * data members
	 */
	private String courseName;
	private int courseCapacity;
	private int courseTiming;
	private ArrayList<Courses> coursesList;
	
	/**
	 * setters
	 */
	public void setCourseName(String courseName){
		this.courseName = courseName;
	}
	public void setCourseCapacity(int courseCapacity){
		this.courseCapacity = courseCapacity;
	}
	public void setCourseTiming(int courseTiming){
		this.courseTiming = courseTiming;
	}

	/**
	 * getters
	 */
	public String getCourseName(){
		return this.courseName;
	}
	public int getCourseCapacity(){
		return this.courseCapacity;
	}
	public int getCourseTiming(){
		return this.courseTiming;
	}	
	public int getDecrementedCourseCapacity(){
		return this.courseCapacity--;
	}

	public ArrayList getCoursesLists(){
		return this.coursesList;
	}	

	/**
	 * Method for extracting all the contents from the file
	 */
	public void courseProcessing(String coursesFile){
		
		FileProcessor fp = new FileProcessor(coursesFile);
		 
	 	String courses = null;
	 	this.coursesList = new ArrayList<Courses>();

		String[] courseName;
		String[] courseCapacity;
		String[] courseStrength;
		String[] timing;	
		
		/**
		 * Calling method of FileProcessor to read the courses file
		 */
		while ((courses = fp.readLineFromFile()) != null){
			
			/**
			 * Preprocessing student file and splitting them into proper attributes
			 */
			courseName = courses.split(" ");
			courseStrength = courseName[1].split(";");
			courseCapacity = courseStrength[0].split(":");
			timing = courseStrength[1].split(":");

			try{

				/**
				 * Creating an arraylist of objects of type Courses which holds all the info related to Courses class
				 */
				Courses c = new Courses();
				c.setCourseName(courseName[0]);
				c.setCourseCapacity(Integer.parseInt(courseCapacity[1]));
				c.setCourseTiming(Integer.parseInt(timing[1]));
				this.coursesList.add(c);	
			
			}
			
			catch(Exception e){

				System.err.println("Index is out of bounds. Please check the formatting of input file");
				System.exit(0);
			}
			
			finally{}			


		}
			
	}

}
