package coursesRegistration.scheduler;

import java.util.ArrayList;
import java.util.HashSet;
import coursesRegistration.scheduler.Student;
import coursesRegistration.scheduler.Courses;
import java.io.IOException;

public class AlgorithmLogic{

	/**
	 * Composition
	 */
	Student s;
	Courses c;


	public ArrayList courseScheduler(Student s,ArrayList students,Courses c,ArrayList courses){

		this.s = s;
		this.c = c;

		ArrayList<Student> studentsList = students;
		ArrayList<Courses> coursesList= courses;

		
		/**
		 * Main Logic part
		 */
		String[] assignCourses = new String[3];		
		ArrayList<String> results = new ArrayList<String>();
		HashSet<Integer> timeClash = new HashSet<Integer>();

		String res = "";
		int noOfCourses = 0;	
		float satisfactionCalc = 0;
		float satisfactionRating = 0;
		float forEachStudent = 0;
		float totalSatisfactionRating = 0;
		float averageSatisfactionRating = 0;
		
		for(int x = 0;x<studentsList.size();x++){

			if(studentsList.get(x).studentPreferences.length < 9){
				
				System.err.println(studentsList.get(x).getStudentId()+":"+"Please provide 9 preferences.");
			}

			else if(studentsList.get(x).getStudentId() < 100 || studentsList.get(x).getStudentId() > 999){

				System.err.println(studentsList.get(x).getStudentId()+":"+"Not a valid Student");	
			}

			else{

				try{

					/**
					 * First loop is for number of student objects in studentList(ArrayList of type Student)
					 */
					res = "";
					res = res + Integer.toString(studentsList.get(x).getStudentId()) + ":";
					
					for(int i=0;i<studentsList.get(x).studentPreferences.length;i++){
						
						/**
						 * Second loop is for considering all the student preferences
						 */
						for(int j = 0;j < coursesList.size(); j++){
						
							/**
							 * Third innermost loop is for searching that particulat student reference in coursesLists(ArrayList of type Courses)
							 */
							if((coursesList.get(j).getCourseName().contains(studentsList.get(x).getStudentPreferences(i)))&&(coursesList.get(j).getCourseCapacity()!=0)&&(noOfCourses<3)){
								
								if(timeClash.add(coursesList.get(j).getCourseTiming())){

									assignCourses[noOfCourses] = coursesList.get(j).getCourseName();						
									//If the course is alloted to student then reduce the capacity of that course
									coursesList.get(j).getDecrementedCourseCapacity();
									//Calculating SatisfactionRating
									satisfactionCalc = 9 - i;
									satisfactionRating = satisfactionRating + satisfactionCalc;
									noOfCourses++;	
								
								}
									
							}
						}
					}
					
				 	res = res + String.join(",", assignCourses);
				 	res = res + "::" + Float.toString(satisfactionRating);
		 			results.add(res);	

					totalSatisfactionRating = totalSatisfactionRating + satisfactionRating;	
					/**
					 * Refreshing all the variables for other students
					 */
					noOfCourses = 0;	
					satisfactionCalc = 0;
					satisfactionRating = 0;
					timeClash.clear();  


					}

					catch(Exception e){

						System.err.println("Index is out of bounds. Please check the size of an array and also the check no. of elements you are trying to access.");
					}

					finally{}
			
			}	
					
		}	

		/**
		 *Not raising an exception of type DivideByZero because when we divide float or double of long by 0 it gives infinity but it does not throw
		 *an exception 
		 */
		if(studentsList.size() == 0){

			System.err.println("Denominator can never be zero. Please check the value of denominator");
		}
		else{
			
			/**
			* AverageSatisfactionRating
			*/
			averageSatisfactionRating = (totalSatisfactionRating/studentsList.size());	
			results.add("Average Satisfaction Rating: " + Float.toString(averageSatisfactionRating));
			
		}
							
		return results;

	}

}


