public abstract class Animal {
    String name;
    double weight;

    public Animal(String name, double weight) {
        this.name   = name;
        this.weight = weight;
    }

    abstract public String speak();

    @Override
    public String toString() {
        return name + "(" + weight + ") - " + speak();
    }
}
