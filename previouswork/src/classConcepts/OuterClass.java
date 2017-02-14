package classConcepts;

/*
    All members of outer class irrespecitve of their access specifiers are accessable in inner class
    //Inner class concepts:

     * https://www.tutorialspoint.com/java/java_innerclasses.htm
     *
     * Inner classes are a security mechanism in Java.
     *
     * http://docs.oracle.com/javase/tutorial/java/javaOO/whentouse.html
     *
     * As mentioned in the section Nested Classes, nested classes enable you to logically group
     * classes that are only used in one place, increase the use of encapsulation,
     * and create more readable and maintainable code. Local classes, anonymous classes,
     * and lambda expressions also impart these advantages; however, they are intended to be used for
     * more specific situations:

*/
//Example
public class OuterClass {

    private final String WELCOME = "Welcome to Inner Class Concepts - string in outer class";
    private final static String S_WLECOME = "I am a static Welcome of tht outer class";

    //Nested Inner class
    class InnerClass {
        public void welcome() {
            System.out.println(WELCOME);
        }
    }

    static class InnerClassIsStatic {
        public void welcome() {
            System.out.println("Static Inner class cant take welcome as its not a STATIC member of outer class");
            System.out.println(S_WLECOME);
        }
    }

}

class ExecuteCode {
    public static void main(String args[]) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.welcome();
        OuterClass.InnerClassIsStatic innerClassIsStatic= new OuterClass.InnerClassIsStatic();
        innerClassIsStatic.welcome();
    }
}
