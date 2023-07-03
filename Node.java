//NodeClass used for making the nodes.
public class Node{
     StudentRecord data;
     Node nextRef;
    
     //Constructors
    public Node(){
        this.data = null;
        this.nextRef = null;
    }
    public Node(StudentRecord data){
        this.data = data;
        this.nextRef = null;
    }
    public Node(StudentRecord data, Node nextRef){
        this.data = data;
        this.nextRef = nextRef;
    }
    //Mutators
    public void setData(StudentRecord nextData){
        this.data = nextData;
    }
    public void setNextRef(Node nextRef){
        this.nextRef = nextRef;
    }
    //Accessors
    public Student getData(){
        return this.data;
    }
    public Node getNextRef(){
        return this.nextRef;
    }
}
