package JavaRevisionDated20_11_23.Day_1_Assignement.IntermediateOOP;

public class AbstractPrinciple {

    /**
     *  Cannot initiate Abstract Class
     **/
//   CheckingAbstractMethod checkingAbstractMethod = new CheckingAbstractMethod();

}

// If any class has any of its method abstract than you must entire class abstract.

abstract class CheckingAbstractMethod {
    abstract void myAbstractMethod();
}

/*
 when we extend an abstract class,
 we must either override all the abstract method in subclass or declare subclass as abstract
 */
class extendAbstract extends CheckingAbstractMethod{
    @Override
    void myAbstractMethod() {

    }
}

// Abstract class cannot be Private

// private abstract class CheckAbstractAsPrivate {
//    abstract void myAbstractMethod();
//}

// Abstract class cannot be final

// final abstract class CheckAbstractClassAsFinal{
//    abstract void myAbstractMethod();
//}

// you can declare a class abstract without having any abstract method
abstract class CheckAbstractClassWithoutHavingAbstractMethod{
    public void myAbstractMethod(){

    }
}


