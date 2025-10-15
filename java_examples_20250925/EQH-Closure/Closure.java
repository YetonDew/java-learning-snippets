public class Closure {
    public static void main(String[] args) {
        String meow = "Meow-meow";
        Dog dog = new Dog("Kitty") {
            @Override
            public void voice() {
                System.out.println(name + ": " + meow);
            }
        };
        dog.voice();  // prints 'Kitty: Meow-meow'
    }
}

class Dog {
    protected String name;
    public Dog(String n) { name = n; }
    public void voice() {
        System.out.println(name + ": " + "bow-wow");
    }
}
