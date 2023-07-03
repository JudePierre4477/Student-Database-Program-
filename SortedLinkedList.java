//Jude Pierre 
//SortedListClass
 
public class SortedLinkedList{
    private Node head;

    //Default constructor for head node
    public SortedLinkedList(){
        head = new Node();
    }

    //Checks whether the list is empty by looking at the next reference for head.
    public boolean isEmpty(){
        return head.nextRef == null;
    }

    //Member method used for inserting the student nodes in sorted order.
    public void insertSorted(StudentRecord nextStudent){
        Node current = head.nextRef;
        Node previous = head;
        while(current != null && nextStudent.compareTo(current.data)>0){
            previous = current; 
            current = current.nextRef;
        }
        current = new Node(nextStudent, current);
        previous.nextRef = current;
    }

    //Member method used for printing the data in each node.
    public String toString(String outputFormat){
        String s = "";
        Node current = head.nextRef;
        while(current != null){
            s += current.data.toString(outputFormat);
            current = current.nextRef;
        }
        s+="\n";
        return s;
    }
    
    //Member method used to search for a student object in the list with the full name entered.
    public Student searchSorted(StudentRecord studentToFind) throws Exception{
        Node current = head.nextRef;
        while((current != null) && (studentToFind.compareTo(current.data) != 0)){
            current = current.nextRef;
        }
        if(current == null){
            throw new Exception ("Student not found");
        }
        return current.data;
    }
    //Member method used to search for a specific student given the ID entered
    public StudentRecord searchSortedByID(String ID) throws Exception{
        Node current = head.nextRef;
        while((current != null) && (current.data.compareToByID(ID))!= true){
            current = current.nextRef;
        }
        if(current == null){
            throw new Exception("Student not found");
        }
        return current.data;
    }
    //Method used to remove a student by switching reference variables.
    public void removeStudent(Student studentToFind) throws Exception{
        Node current = head.nextRef;
        Node prev = head;
        while((current != null) && (studentToFind.compareTo(current.data) > 0)){
            prev = current;
            current = current.nextRef;
        }
        if(current == null){
            throw new Exception ("Student not found");
        }
        prev.nextRef = current.nextRef;
    }
    //Method used to return Student data. Had to update all of the Student variables to StudentReference because of this.
    public String returnStudentData(){
        String data= "";
        Node current = head.nextRef;
        while(current != null){
            data+= current.data.returnData();
            current = current.nextRef;
        }
        return data;
    }
}
