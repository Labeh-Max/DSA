package generics_exercises;

class ListNode<T extends Comparable<T>>{

    //package access members; List can access these directly
    T data; //data for this node
    ListNode<T> nextNode; //reference to the next node in the list

    //constructor creates a ListNode that refers to object
    ListNode(T object){
        this(object, null);
    }

    //constructor creates ListNode that refers to the specified
    //object and to the next ListNode
    ListNode(T object,ListNode<T> node){
        data = object;
        nextNode = node;
    }

    //return reference to data in node
    T getData(){
        return data; //return item in this node
    }

    //return reference to next node in list
    ListNode<T> getNext(){
        return nextNode; //get next node
    }


}//end class ListNode<T>

public class SortedList <T extends Comparable<T>> {
    private ListNode<T> firstNode;
    private ListNode<T> lastNode;
    private String name; //String like "list" used in printing

    //constructor creates empty List with "list" as the name
    public SortedList(){
        this("list");
    }
    //constructor creates an empty SortedList with a name
    public SortedList(String listName){
        name = listName;
        firstNode = lastNode = null;
    }

    //insert item at front of list
    public void insertAtFront(T insertItem){
        if(isEmpty()) {//firstNode and lastNode refer to same object
            firstNode = lastNode = new ListNode<T>(insertItem);
        }
        else { //firstNode refers to new node

            if(firstNode.getData().compareTo(insertItem) >= 0){ //checks first node
                firstNode = new ListNode<>(insertItem, firstNode);
            }else {

                ListNode<T> currentNode = firstNode.nextNode;
                ListNode<T> previousNode = firstNode;

                while (currentNode != null) { //we are traversing the node backwards

                    //we compare the integer data of the first node with our inserted integer
                    if (currentNode.getData().compareTo(insertItem) >= 0) { //current data is larger than value to be inserted
                        previousNode.nextNode = new ListNode<>(insertItem, currentNode);
                        break;

                    } else {
                        previousNode = currentNode;
                        currentNode = currentNode.nextNode;

                    }

                }

                if(currentNode == null){
                    //The item to be inserted is the biggest
                    lastNode = lastNode.nextNode = new ListNode<>(insertItem);
                }

            }


        }


    }//end method insertAtFront

    public void merge(SortedList<T> sortedList){

        //start merging from the first node and order on the fly
        ListNode<T> currentNode = sortedList.firstNode;

        while (currentNode != null){

            this.insertAtFront(currentNode.data);
            currentNode = currentNode.nextNode;

        }



    }

    //determine whether list is empty
    public boolean isEmpty(){
        return firstNode == null; //return true if list is empty
    }

    //output list contents
    public void print(){
        if(isEmpty()){
            System.out.printf("Empty %s\n", name);
            return;
        }

        System.out.printf("The %s is: ", name);
        ListNode<T> current = firstNode;

        //while not at end of list, output current node's data
        while (current != null){
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        } //end while

        System.out.println("\n");
    }

}
