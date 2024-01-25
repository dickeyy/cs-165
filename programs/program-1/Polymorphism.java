import java.util.ArrayList;

public class Polymorphism {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        Person jennifer = new Person("Jennifer", 40);
        Person michael = new Employee("Michael", 56, 370_000, "Dunder Mifflin");
        Person david = new Manager("David", 39, 13_000_000, "Dunder Mifflin");

        people.add(jennifer);
        people.add(michael);
        people.add(david);

        for (int i = 0; i < people.size(); i++) {
            Person p = people.get(i);
            System.out.println(p.toString());
        }

        /*
         * Look at and run the code above, then take a moment to think about the
         * following questions. Write down your answers somewhere.
         *
         * 1. How is it that we were able to store an Employee or a Manager in a
         * variable that has a type Person?
         * Because employee and manager both extend type Person.
         *
         * 2. When we called the toString() method on each of the people in the
         * list, it resulted in something totally different. Why? They're all
         * stored in variables of type Person, so why would they not be the
         * same?
         * Because each class has its own toString() method.
         *
         * 3. We wrote three different versions of toString() across three
         * different classes. When we call p.toString(), which one of these
         * versions does Java use, and why?
         * It uses the toString() method of the class that the object is an instance of.
         */

        // Consider the following code:
        // michael.setSalary(800000);

        /*
         * 4. Will this code cause errors? Uncomment it and see.
         * Yes, it will cause an error.
         *
         * 5. You should have found that the above code results in a
         * compilation error. Why can't Java figure out what to do? Employee
         * has a perfectly valid setSalary method, doesn't it?
         * Because the variable michael is of type Person, not Employee.
         */

        /* Now consider this code: */
        Employee anotherMichael = new Employee("Michael", 56, 370000, "Dunder Mifflin");

        /*
         * This is the exact same person as above, the only difference is that
         * we've stored it in a variable of type Employee instead of a variable
         * of type Person. If we try
         */

        // anotherMichael.setSalary(800000);

        /*
         * Will it work? Make a guess, then uncomment the line and see.
         *
         * 6. You should have found that this code DOES NOT produce a
         * compilation error. Why?
         * Because the variable anotherMichael is of type Employee, so it can access the
         * setSalary() method.
         */

        /*
         * 7. What you have just seen in action from the previous few questions
         * is known as dynamic binding. Describe what dynamic binding is, in
         * your own words.
         * Dynamic binding is when the method that is called is determined at runtime,
         * based on the type of the object that the method is being called on.
         */
    }
}
