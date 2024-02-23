import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class StatePopulations {

    public static ArrayList<StatePair<Integer, String>> fillArray1(ArrayList<StatePair<Integer, String>> statePairs,
            Scanner inFS) {
        StatePair<Integer, String> pair;
        int intValue;
        String stringValue;

        while (inFS.hasNextLine()) {
            intValue = inFS.nextInt();
            stringValue = inFS.next();
            pair = new StatePair<Integer, String>(intValue, stringValue);
            statePairs.add(pair);
        }
        return statePairs;
    }

    public static ArrayList<StatePair<String, String>> fillArray2(ArrayList<StatePair<String, String>> statePairs,
            Scanner inFS) {
        StatePair<String, String> pair;
        String stringValue1;
        String stringValue2;

        while (inFS.hasNextLine()) {
            stringValue1 = inFS.next();
            inFS.nextLine();
            stringValue2 = inFS.nextLine();
            pair = new StatePair<String, String>(stringValue1, stringValue2);
            statePairs.add(pair);
        }
        return statePairs;
    }

    public static ArrayList<StatePair<String, Integer>> fillArray3(ArrayList<StatePair<String, Integer>> statePairs,
            Scanner inFS) {
        StatePair<String, Integer> pair;
        String stringValue;
        int intValue;

        while (inFS.hasNextLine()) {
            stringValue = inFS.nextLine();
            intValue = inFS.nextInt();
            inFS.nextLine();
            pair = new StatePair<String, Integer>(stringValue, intValue);
            statePairs.add(pair);
        }
        return statePairs;
    }

    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        FileInputStream fileByteStream = null; // File input stream
        Scanner inFS = null; // Scanner object
        int myZipCode;
        int i;

        // ZIP code - state abbrev. pairs
        ArrayList<StatePair<Integer, String>> zipCodeState = new ArrayList<StatePair<Integer, String>>();

        // state abbrev. - state name pairs
        ArrayList<StatePair<String, String>> abbrevState = new ArrayList<StatePair<String, String>>();

        // state name - population pairs
        ArrayList<StatePair<String, Integer>> statePopulation = new ArrayList<StatePair<String, Integer>>();

        // Fill the three ArrayLists

        // Try to open zip_code_state.txt file
        fileByteStream = new FileInputStream("zip_code_state.txt");
        inFS = new Scanner(fileByteStream);
        zipCodeState = fillArray1(zipCodeState, inFS);
        fileByteStream.close(); // close() may throw IOException if fails

        // Try to open abbreviation_state.txt file
        fileByteStream = new FileInputStream("abbreviation_state.txt");
        inFS = new Scanner(fileByteStream);
        abbrevState = fillArray2(abbrevState, inFS);
        fileByteStream.close();

        // Try to open state_population.txt file
        fileByteStream = new FileInputStream("state_population.txt");
        inFS = new Scanner(fileByteStream);
        statePopulation = fillArray3(statePopulation, inFS);
        fileByteStream.close();

        // Read in ZIP code from user
        myZipCode = scnr.nextInt();

        for (i = 0; i < zipCodeState.size(); ++i) {
            // TODO: Using ZIP code, find state abbreviation
        }

        for (i = 0; i < abbrevState.size(); ++i) {
            // TODO: Using state abbreviation, find state name
        }

        for (i = 0; i < statePopulation.size(); ++i) {
            // TODO: Using state name, find population. Print pair info.
        }
    }
}