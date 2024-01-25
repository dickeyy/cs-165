// Just like an Employee is a specific kind of Person, a Manager is a specific
// kind of Employee.
public class Manager extends Employee {

    /*
     * YOUR CODE HERE
     * At the moment, this constructor is causing errors.
     * What's wrong with it? Fix it by adding some code.
     */
    public Manager(String name, int age, long salary, String employer) {
        super(name, age, salary, employer);
    }

    /*
     * YOUR CODE HERE
     * This function will properly compile, but it's not very helpful.
     * We should be putting the name of the person, their company, their age,
     * etc. instead of just blank spaces and zeros. Fix this toString by
     * putting relevant information into the string.
     */
    public String toString() {
        return getName() + " is a manager at " + getEmployer() + " who is " + getAge() + " and makes $"
                + getSalary() + " a year.";
    }

    // NOTE: this main will not run in zyLabs, but you can use this for testing in
    // an IDE
    public static void main(String[] args) {
        Manager m = new Manager("Liang", 41, 4_000_000_000L, "Microsoft");
        // Perhaps it's unusual that anyone is being paid a salary of four
        // billion dollars a year, but it's just an example.
        System.out.println(m.toString());
    }

}
