package tech.aksads.aoc.solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Solution<T> {
    public final String problem;

    protected Solution(String problem) {
        this.problem = problem;
    }

    /**
     * Converts the raw file input into a data structure to be used to solve the problem
     * @param isTest If the solution should be initialized to run the test case.
     */
    public abstract void setup(boolean isTest);

    /**
     * Solves the problem, and returns the solution
     * @return The solution to the problem
     */
    public abstract T solve();

    /**
     * Tests the solution and determines if it works
     * @return If the solution works against the test case
     */
    public abstract boolean test();

    /**
     * Reads the input file and returns it as an ArrayList of Strings representing each line of the file
     * @param isTest If the test input should be read
     * @return an ArrayList of Strings representing each line of the file
     */
    protected ArrayList<String> readInputFile(boolean isTest) {
        try {
            File file = new File("inputs/" + problem.substring(0,2) + (isTest ? ".test": "") + ".txt");
            Scanner reader = new Scanner(file);
            ArrayList<String> lines = new ArrayList<>(100);
            while(reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
            reader.close();
            return lines;
        } catch (IOException e) {
            System.err.println("Could not open file!");
            return null;
        }
    }
}
