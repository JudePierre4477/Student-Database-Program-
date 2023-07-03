//MainClass
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class StudentMain {
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        // Input Variables, Head node declaration for list, Student object declaration, hash table initialization. 
        String ID;
        SortedLinkedList STUDENTRECORDS = new SortedLinkedList();
        StudentRecord [] hashTable = new StudentRecord[100];
        Student STUDENT;
        String input="";
        String menuInputs="";
        String fileName;
        // Menu
        System.out.println("MENU");
        System.out.println("1. Load student roster");
        System.out.println("2. Add a new student");
        System.out.println("3. Remove an existing student");
        System.out.println("4. Look up student information");
        System.out.println("5. Add a course to a student");
        System.out.println("6. Display student info");
        System.out.println("7. Save the student roster");
        System.out.println("8. EXIT");
        System.out.println("\n");
        System.out.println("What would you like to do?");
        //While loop to execute program body.
        while(true){
            System.out.println();
            System.out.println("Look at menu key for options");
            System.out.println("Or enter 9 to see options again");
            input = scnr.next();
            //conditional statement to exit.
            if(input .equals("8")){break;}
            //Switch Statement to implement menu and call necessary methods.
            switch(input){
                //Option 1
                case "1":{
                    System.out.println("Enter the record file name you would like to edit");
                    fileName = scnr.next();
                    fileName +=".txt";
                    try{
                        loadStudentFile(fileName ,STUDENTRECORDS, hashTable);
                    }catch(FileNotFoundException Exception){
                        System.out.print(Exception.getMessage());
                    }catch(Exception Exception){
                        System.out.print(Exception.getMessage());
                    }
                    System.out.println("SUCCESS");
                        break;
                }
                //Option 2
                case "2":{
                    try{
                    addNewStudent(STUDENTRECORDS, scnr, hashTable);
                    }
                    catch(InputMismatchException EXCEPTION){
                        System.out.println(EXCEPTION.getMessage());
                    }catch(Exception EXCEPT){
                        System.out.println(EXCEPT.getMessage());
                    }
                    break;            
                }
                //Option 3
                case "3":{
                    try{
                        removeStudent(STUDENTRECORDS, scnr, hashTable);
                    }
                    catch(InputMismatchException except){
                        System.out.println(except.getMessage());
                    }
                    catch(Exception EXCEPT){
                        System.out.println(EXCEPT.getMessage());
                    }
                    break;
                }
                //Option 4
                case "4":{
                    System.out.println("Search for the student:");
                    System.out.println("1. Search by ID");
                    System.out.println("2. Search by first and last names");
                    menuInputs = scnr.next();
                    if(menuInputs.equals("1")){
                        System.out.println("Enter ID#: ");
                        ID = scnr.next();
                        try{
                            STUDENT = searchStudentByID(STUDENTRECORDS,ID, hashTable);
                            System.out.println(STUDENT.toString("ID#"));
                            break;
                        }catch(Exception EXCEPT){
                            EXCEPT.getMessage();
                        }
                    }else if(menuInputs.equals("2")){
                        try{
                            searchStudent(STUDENTRECORDS, scnr);
                            break;
                        }catch(Exception EXCEPT){
                            EXCEPT.getMessage();
                        }
                    }
                    break;
                }
                //Option 5
                case "5":{
                     System.out.println("Enter the ID# of the student you wish to update");
                        ID = scnr.next();
                     try{
                        addCoursetoStudent(STUDENTRECORDS, ID, scnr, hashTable);
                    }catch(Exception EXCEPT){
                        EXCEPT.getMessage();
                    }
                    break;
                }
                //Option 6
                case "6":{
                    try{
                        displayStudentInfo(STUDENTRECORDS, scnr, hashTable);
                    }catch(Exception EXCEPT){
                        EXCEPT.getMessage();
                    } 
                    break;       
                }
                //Option 7
                case "7":{
                    System.out.println("Enter the file name you would like to save to (Note Saving overwrites existing file data with current data)");
                    fileName = scnr.next();
                    fileName +=".txt";
                    try{
                        saveStudentFile(STUDENTRECORDS, fileName);
                    }catch(FileNotFoundException EXCEPTION){
                        System.out.println(EXCEPTION.getMessage());
                    }
                    catch(Exception Except){
                        System.out.println(Except.getMessage());
                    }
                    break;
                }
                //hidden option to reprint menu because of terminal.
                case "9":{
                    System.out.println();
                    System.out.print("1. Load student roster ");
                    System.out.print("2. Add a new student ");
                    System.out.print("3. Remove an existing student ");
                    System.out.println("4. Look up student information ");
                    System.out.print("5. Add a course to a student ");
                    System.out.print("6. Display student info ");
                    System.out.print("7. Save the student roster ");
                    System.out.println("8. EXIT");
                    break;
                }  default:{break;}
            }
        }
    }
    //Method to load the student file to our SortedList
    public static void loadStudentFile(String fileName, SortedLinkedList STUDENTRECORDS, StudentRecord [] hashTable)throws FileNotFoundException, Exception{
        String firstName, lastName, ID;
        double gpa;
        int credits;
        int i = 0;
        File data  = new File (fileName);
       Scanner reader = new Scanner(data);
        while(reader.hasNextLine()){
            firstName = reader.next();
            lastName = reader.next();
            ID = reader.next();
            gpa = reader.nextDouble();
            credits = reader.nextInt();
            StudentRecord  studentRecordData = new StudentRecord (firstName, lastName, ID, gpa, credits);
            STUDENTRECORDS.insertSorted(studentRecordData);
            i = Integer.parseInt(ID);
            i = i % 100;
            System.out.println(i);
            while(hashTable[i]!= null){
                    i = (i+1) % 100;
            }
            //Testing...
            hashTable[i] = STUDENTRECORDS.searchSortedByID(ID);
        }
        reader.close();
    }
    //Method to add a new student to the Sorted List
     public static void addNewStudent(SortedLinkedList STUDENTRECORDS, Scanner scnr, StudentRecord []hashTable)throws InputMismatchException, Exception{ 
        String firstName, lastName, ID;
        double gpa; int credits;
        StudentRecord student;

        System.out.println("Enter the first and last name of the student followed by ID and GPA and credits taken");

        firstName = scnr.next();
        lastName = scnr.next();
        ID = scnr.next();
        gpa = scnr.nextDouble();
        credits = scnr.nextInt();
        student = new StudentRecord(firstName, lastName, ID, gpa, credits);
        STUDENTRECORDS.insertSorted(student);

        System.out.print(STUDENTRECORDS.toString("first name"));
        int i = Integer.parseInt(ID);
        i = i % 100;
        while(hashTable[i]!= null){
            i = (i+1) % 100;
        }
        hashTable[i] = student;
    }
    public static void removeStudent(SortedLinkedList STUDENTRECORDS, Scanner scnr, StudentRecord [] hashTable)throws InputMismatchException, Exception{  
        String firstName, lastName, ID;
        int i;
        StudentRecord student;
        System.out.println("Enter first name: ");
        firstName = scnr.next(); 
        System.out.println("Enter last name: ");
        lastName = scnr.next();
        System.out.println("Enter ID#: ");
        ID = scnr.next(); 
        i = Integer.parseInt(ID);
        i = i % 100;
        student = new StudentRecord(firstName, lastName, ID);
        try{
            STUDENTRECORDS.removeStudent(student);
            while(hashTable[i] != null){
                if(hashTable[i].compareToByID(ID)){
                   break; 
                }
                else{
                    i = (i+1)%100;
                }
            }
            hashTable[i] = null;
        }catch(Exception EXCEPT){
            System.out.println(EXCEPT.getMessage());
        }
    }
        // Method used to search for a specific student in the list given the student's full name.
    public static void searchStudent(SortedLinkedList STUDENTLIST, Scanner scnr)throws Exception{
        String firstName, lastName;
        System.out.println("Enter first name: ");
        firstName = scnr.next(); 
        System.out.println("Enter last name: ");
        lastName = scnr.next();
        Student studentToFind = STUDENTLIST.searchSorted(new StudentRecord(firstName, lastName, " "));
        System.out.print(studentToFind.toString("last name"));
    }
    // Method used to search for a student by ID #.
     public static StudentRecord searchStudentByID(SortedLinkedList STUDENTLIST, String ID, StudentRecord []hashTable)throws Exception{
        StudentRecord studentToFind = null;
        int i=0;
        while(true){
            if(hashTable[i]!=null){
                if(hashTable[i].compareToByID(ID)){
                    studentToFind = hashTable[i];
                    break;
                }
            }
            i++;
        }
        if(studentToFind == null){
            throw new Exception("STUDENT NOT FOUND");
        }
       // System.out.println(studentToFind.toString("ID#"));
       return studentToFind;
    }
    //Method used to add a course and gpa to a specific student.
    public static void addCoursetoStudent(SortedLinkedList STUDENTRECORDS, String ID, Scanner scnr, StudentRecord [] hashTable)throws Exception{
        double gpa;
        int credits;
        StudentRecord student = searchStudentByID(STUDENTRECORDS,ID, hashTable);
        System.out.println("Enter the number of credits and the grade recieved(on 4.0 scale):");
        credits = scnr.nextInt();
        gpa = scnr.nextDouble();
        student.calculateGPA(credits,gpa);
        System.out.println(student.toString("ID#"));
    }
    //Method used to display all the student data in the STUDENTRECORDS list.
    public static void displayStudentInfo(SortedLinkedList STUDENTRECORDS, Scanner scnr, StudentRecord [] hashTable)throws Exception{
        System.out.println("How would you like to display roster information:");
        System.out.println("1. first name");
        System.out.println("2. last name");
        System.out.println("3. ID#");
        String format = scnr.next();
        System.out.println();
        if(format.equals("1")){
            // System.out.print(STUDENTRECORDS.toString("first name"));
            for(int i = 0; i < hashTable.length; i++){
                if(hashTable[i] != null)
                System.out.print(hashTable[i].toString("first name"));
            }
        }
        else if(format.equals("2")){
            // System.out.println(STUDENTRECORDS.toString("last name"));
            // System.out.println();
             for(int i = 0; i < hashTable.length; i++){
                if(hashTable[i] != null)
                System.out.print(hashTable[i].toString("last name"));
            }
        }else if(format.equals("3")){
           // System.out.println(STUDENTRECORDS.toString("ID#"));
           for(int i = 0; i < hashTable.length; i++){
                if(hashTable[i] != null)
                System.out.print(hashTable[i].toString("ID#"));
            }
        }
    }
    //Method used to save the data from the STUDENTRECORDS list to a file.
    public static void saveStudentFile(SortedLinkedList STUDENTRECORDS, String fileName)throws FileNotFoundException , Exception{
        File fileToSaveTo = new File (fileName);
        PrintWriter writer = new PrintWriter (fileToSaveTo);
        writer.print(STUDENTRECORDS.returnStudentData());
        writer.close();
    }
}