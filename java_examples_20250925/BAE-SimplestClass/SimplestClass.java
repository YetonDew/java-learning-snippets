  // should be defined in a separate
  // file, probably as public...
class Person {
    String name;
    int     age;
}

public class SimplestClass {
    public static void main(String[] args) {
          // creating object, jane is a reference, not object
        Person jane = new Person();
        jane.name = "Jane";
        jane.age  = 23;
          // another object
        Person bill = new Person();
        bill.name = "Bill";
        bill.age  = 31;
        System.out.println("jane -> name=" + jane.name +
                                  ", age=" + jane.age);
        System.out.println("bill -> name=" + bill.name +
                                  ", age=" + bill.age);
    }
}
