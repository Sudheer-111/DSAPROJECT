import java.util.*;
// ---------- VEHICLE ----------
class Vehicle {
    String number,type,state;
    int penalty=0;
    int priority;
    Vehicle(String n,String t,String s,int p){
    number=n;
    type=t;
    state=s;
    priority=p;
    }
    public String toString(){
    return number + " | " + type + " | " + state +
                " | Penalty: " + penalty +
                " | Priority: " + priority;
    }
}
// ---------- NODE ----------
class Node{
    Vehicle data;
    Node next;
    Node(Vehicle v){
    data=v;
    next=null;
    }
}
// ---------- MAIN CLASS ----------
public class Project{
    // ---------- QUEUE ----------
    static Node front=null,rear=null;
    static void enqueue(Vehicle v){
    Node newNode=new Node(v);
    if(rear==null){
    front=rear=newNode;
    }else{
    rear.next=newNode;
    rear=newNode;
    }
    }
    static Vehicle dequeue(){
    if(front==null){
    System.out.println("Queue Empty");
    return null;
    }
    Vehicle v=front.data;
    front=front.next;
    if(front==null) 
    rear=null;
    return v;
    }
    static void displayQueue(){
    Node temp=front;
    while(temp!=null){
    System.out.println(temp.data);
    temp=temp.next;
    }
    }
    // ---------- STACK ----------
    static Node top=null;
    static void push(Vehicle v){
    Node newNode=new Node(v);
    newNode.next=top;
    top=newNode;
    }
    static Vehicle pop(){
    if(top==null) 
    return null;
    Vehicle v=top.data;
    top=top.next;
    return v;
    }
    // ---------- SEARCH ----------
    static Vehicle search(String number){
    Node temp=front;
    while(temp!=null){
    if(temp.data.number.equalsIgnoreCase(number)){
    return temp.data;
    }
    temp=temp.next;
    }
    return null;
    }
    // ---------- SORT BY PRIORITY ----------
    static void sortByPriority(){
    for (Node i=front;i!=null;i=i.next){
    for(Node j=i.next;j!=null;j=j.next){
    if(i.data.priority<j.data.priority){
    Vehicle temp=i.data;
    i.data=j.data;
    j.data=temp;
    }
    }
    }
    }
    // ---------- SORT BY PENALTY ----------
    static void sortByPenalty(){
    for(Node i=front;i!=null;i=i.next){
    for(Node j=i.next;j!=null;j=j.next){
    if(i.data.penalty<j.data.penalty){
    Vehicle temp=i.data;
    i.data=j.data;
    j.data=temp;
    }
    }
    }
    }
    // ---------- HASHING (FAST SEARCH) ----------
    static HashMap<String, Vehicle>vehicleMap=new HashMap<>();
    static void addToHash(Vehicle v){
    vehicleMap.put(v.number,v);
    }
    static Vehicle searchHash(String number){
    return vehicleMap.get(number);
    }
    // ---------- PRIORITY QUEUE (HEAP) ----------
    static PriorityQueue<Vehicle> pq = new PriorityQueue<>((a,b)->b.priority-a.priority);
    static void addToPriorityQueue(Vehicle v){
    pq.add(v);
    }
    static void displayPriorityQueue(){
    System.out.println("\nPriority Queue (Heap):");
    for(Vehicle v:pq){
    System.out.println(v);
    }
    }
    // ---------- MAIN ----------
    public static void main(String[] args){
    // Create Vehicles
    Vehicle v1=new Vehicle("AP123","Car","AP",2);
    Vehicle v2=new Vehicle("TS456","Bike","TS",5);
    Vehicle v3=new Vehicle("KA789","Truck","KA",3);
    // ---------- QUEUE APPLICATION ----------
    enqueue(v1);
    enqueue(v2);
    enqueue(v3);
    System.out.println("Initial Queue:");
    displayQueue();
    // ---------- HASHING ----------
    addToHash(v1);
    addToHash(v2);
    addToHash(v3);
    System.out.println("\nSearch using HashMap:");
    System.out.println(searchHash("TS456"));
    // ---------- SEARCH ----------
    System.out.println("\nSearch using Linked List:");
    System.out.println(search("KA789"));
    // ---------- STACK APPLICATION ----------
    push(v1);
    push(v2);
    push(v3);
    System.out.println("\nStack Pop (LIFO):");
    System.out.println(pop());
    // ---------- PRIORITY QUEUE ----------
    addToPriorityQueue(v1);
    addToPriorityQueue(v2);
    addToPriorityQueue(v3);
    displayPriorityQueue();
    // ---------- SORTING ----------
    System.out.println("\nSorted by Priority:");
    sortByPriority();
    displayQueue();
    // Assign penalties
    v1.penalty=50;
    v2.penalty=20;
    v3.penalty=80;
    System.out.println("\nSorted by Penalty:");
    sortByPenalty();
    displayQueue();
    // ---------- DEQUEUE ----------
    System.out.println("\nAfter Dequeue:");
    dequeue();
    displayQueue();
    }
}
