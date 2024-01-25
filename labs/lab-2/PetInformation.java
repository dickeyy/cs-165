import java.util.Scanner;

public class PetInformation {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        Pet myPet = new Pet();
        Dog myDog = new Dog();

        String petName, dogName, dogBreed;
        int petAge, dogAge;

        petName = scnr.nextLine();
        petAge = scnr.nextInt();
        scnr.nextLine();
        dogName = scnr.next();
        dogAge = scnr.nextInt();
        scnr.nextLine();
        dogBreed = scnr.nextLine();

        myPet.setName(petName);
        myPet.setAge(petAge);

        myPet.printInfo();

        myDog.setName(dogName);
        myDog.setBreed(dogBreed);
        myDog.setAge(dogAge);

        myDog.printInfo();

        // TODO: Use getBreed(), to output the breed of the dog
        System.out.println("   Breed: " + myDog.getBreed());

    }
}