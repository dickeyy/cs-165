public class Pet {

    protected String name;
    protected int age;

    public void setName(String userName) {
        name = userName;
    }

    public String getName() {
        return name;
    }

    public void setAge(int userAge) {
        age = userAge;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("Pet Information: ");
        System.out.println("   Name: " + name);
        System.out.println("   Age: " + age);
    }

}