# CSX42: Assignment 1
## Name: Yash Mukeshbhai Shingadiya

-----------------------------------------------------------------------
## Instruction to clean:
ant -buildfile coursesRegistration/src/build.xml clean

-----------------------------------------------------------------------
## Instruction to compile:
ant -buildfile coursesRegistration/src/build.xml all

-----------------------------------------------------------------------
## Instruction to run: (place input files in the same file as 
ant -buildfile coursesRegistration/src/build.xml run -Darg0=student_coursePrefs.txt -Darg1=courseInfo.txt -Darg2=registration_results.txt

Notes:

- While passing the values of input and output files from the command line please follow the order and names, as mentioned in the above command. 

-----------------------------------------------------------------------
## Description: 
 The driver code takes students info file as first parameter and calls studentProcessing which in turn calls getReadLine to read the students file and then preprocessing of the students file is done in studentProcessing to extract all the contents of file. After that, the contents are stored in form of arraylist of objects of type Student.Once this is done it is sorted in such a way that third year student comes first, then second and so on so as to make assignment of courses more manageable on basis of priority. Similarly, driver code takes courses info as second argument and calls coursesProcessing which in turn calls getReadLine to read courses file and then preprocessing of the courses file is done in courseProcessing.Once this is done the contents are stored in form of arraylist of objects of type Courses.Both these arraylist are returned to driver code and from there driver code calls courseScheduler which passes both these processed arraylist as arguments and implements the whole algorithm along with the boundary conditions.Finally, driver code calls writeToFile to store the processed output to file and calls writeToScreen to print the output on the console.

 Notes:

-Please ignore my first two commits. They were made only for testing purpose and have no meaning.

-The code is designed keeping in mind that all the input files will be formatted

-While creating an algorithm, an assumption has been taken that all the sutdents will have their own unique studentID i.e all the students will appear only
 once and will have their own unique studentID everytime they enter their prefernces.If same student appears multiple times with same studentID then that  student will be allocated courses like a normal student multiple times.No boundary conditions have been applied for this case as nothing has been
 mentioned about this case in the description.

-In case, when students have less than 9 preferences the algorithm will still work and assign the courses to those students who have given 9 preferences and
 will give an error on the console for those students who had given less than 9 preferences. Means the program will not terminate if student gives less than 9 preferences. The algorithm will simply not assign courses to those students who had given less than 9 preferences.For other students it will work normally.

-No error messages are written inside the registration_results.txt. Only those students who get their courses assigned are written to the registration_results.txt file. The error messages are only printed on the screen.   

-----------------------------------------------------------------------
## Data Structures used:
### Array: Mainly used for preprocessing of the file and extracting the contents ready after reading it and, also for storing the assigned courses
### ArrayList: Mainly used for creating ArrayList of objects and storing results and writing it to a file
### HashSet: Mainly used for checking the clash of course timings because of its property of unique keys

-----------------------------------------------------------------------
## References:
### https://www.geeksforgeeks.org: split(), ArrayList, Collection.sort()
### https://stackoverflow.com: read/write operations

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 19 September 2019
Name: Yash Mukeshbhai Shingadiya



