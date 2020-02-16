package coursesRegistration.driver;

import java.util.ArrayList;
import java.util.List;
import coursesRegistration.scheduler.Student;
import coursesRegistration.scheduler.Courses;
import coursesRegistration.scheduler.AlgorithmLogic;
import coursesRegistration.util.Results;


/**
 * @author Yash Shingadiya
 *
 */
public class Driver {
	public static void main(String[] args){

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		
		if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 3 argumnets.");
			System.exit(0);
		}


		/**
		 * Restricting the order and name of the input and output files
		 */
		String input1 = "student_coursePrefs.txt";
		String input2 = "courseInfo.txt";
		String output = "registration_results.txt";

		if((args[0].equals(input1)) && (args[1].equals(input2)) && (args[2].equals(output))){
 
			Student s = new Student();
			s.studentProcessing(args[0]);	
		
		

			Courses c = new Courses();
			c.courseProcessing(args[1]);

			/**
			 * ArrayList of objects
			 */
			ArrayList<Student> studentsList = s.getStudentLists();
			ArrayList<Courses> coursesList = c.getCoursesLists();

			/**
			 * Main implementation of the algorithm which uses preprocessed studentsList and coursesList
			 */
			AlgorithmLogic al = new AlgorithmLogic();
			ArrayList<String> finalResults = al.courseScheduler(s,studentsList,c,coursesList);
			
			Results r = new Results();

			/**
			* For writing output to file
			*/
			r.writeToFile(args[2],finalResults);
			
			/**
			* For writing output to screen
			*/
			r.writeToStdout(finalResults);
		
		}
		
		else{

			System.err.println("Please enter first input file as student_coursePrefs.txt, second input file as courseInfo.txt"+" "+
				"and output file as registration_results.txt");
			
			System.exit(0);
		}	
		
	}

}

