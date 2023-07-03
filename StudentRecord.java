//Jude Pierre 
//StudentRecordCLASS

public class StudentRecord extends Student{
    //Private members
    private double gpa;
    private int credits;
    //Default constructor
    public StudentRecord(){
        gpa = 0;
        credits = 0;
    }
    //Constructor for just the two data members
    public StudentRecord(double gpa, int credits){
        this.gpa = gpa;
        this.credits = credits;
    }
    // Constructor for both student and StudentRecord data members
    public StudentRecord(String firstname, String lastname, String student_ID, double gpa, int credits){
        super(firstname, lastname, student_ID);
        this.gpa = gpa;
        this.credits = credits;
    }
    public StudentRecord(String firstname, String lastname, String student_ID){
        super(firstname,lastname,student_ID);
    }  
    //Mutators
    public void setGpa(double gpa){
        this.gpa = gpa;
    }
    public void setCredits(int credits){
        this.credits += credits;
    }
    //Accessors
    public int getCredits(){
        return credits;
    }
    public double getGpa(){
        return gpa;
    }
    //Override print function and used super to print data members from Student as well as the ones from this class.
    @Override
    public String toString(String output){
        String Format = String.format("gpa: %-10.2f credits: %-15s \n",gpa,credits);
        return super.toString(output) + Format;
    } 
    // Method to calculate the gpa and credits earned from a course. Adds on to existing data of the student.
    public void calculateGPA(int credits, double gpa){
       this.gpa = ((this.credits * this.gpa) + (credits * gpa)) / (this.credits + credits);
       setCredits(credits);
    }
    //Method used to convert the student data to a string and returns it for saving to file.
    public String returnData(){
        return firstName + " " + lastName + " " + studentID + " " + gpa + " " + credits + " "  + gpa + "\n";
    }

}
