package mcqspractice;

public class DoSelect1{
 public static void main(String args[]){
  if(Move.getSpeed() > 10){
System.out.println("Run");
}
 else{
System.out.println("Walk");
 }
 }
 interface Move{
public static int getSpeed(){
 return 10;
 }
public default String toyString(){
 return "Move";
 }
 }
}
