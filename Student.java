//Jude Pierre 
//StudentClass

public class Student implements Comparable<Student> {
    //protected variables to allow easy access for the StudentRecord class.
    protected String firstName;
    protected String lastName;
    protected String studentID;

    //Default constructor
    Student(){
        firstName = null;
        lastName = null;
        studentID = "0";
    }

    //Constructor
    Student(String firstname, String lastname, String student_ID){
        firstName = firstname;
        lastName = lastname;
        studentID = student_ID;
    }

    //Mutators
    public void setFirstName(String firstname){
        firstName = firstname;
    }
    public void setLastName(String lastname){
        lastName = lastname;
    }
    public void setStudentID(String student_ID){
        this.studentID = student_ID;
    }

    //Accessors
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getStudentID(){
        return studentID;
    }
    //Member method that prints the object's data in various ways given an input.
    public String toString(String outputType){
        String Format;
        if (outputType.equals("first name")){
            Format = String.format("first name: %-15s last name: %-15s ID#: %-15s", firstName, lastName, studentID);
            return Format;
        }else if(outputType.equals("last name")){
            Format = String.format("last name: %-15s first name: %-15s ID#: %-15s", lastName, firstName, studentID);
            return Format;
        }else if(outputType.equals("ID#")){
             Format = String.format("ID#: %-15s first name: %-15s last name: %-15s", studentID, firstName, lastName);
            return Format;
        }
        return "Invalid output type: " + outputType;
    }

    //Member method that compares the first names and last names of two student objects for sorting.
    public int compareTo(Student other){ 
		int value = this.lastName.compareTo(other.lastName);
		if (value == 0){
			value = this.firstName.compareTo(other.firstName);
        }
		return value;
	}
    //Member method that compares the ID passed to the current ID stored in the student object. 
    //Updated, previous submission used compareTo.
    public boolean compareToByID(String ID){
        if(this.studentID.equals(ID))
        return true;
        return false;
    }
}
