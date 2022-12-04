package tech.aksads.aoc.solutions.day3;

import java.util.ArrayList;

import tech.aksads.aoc.solutions.Solution;

public class Day3Problem2 extends Solution<Integer> {
    
    public Day3Problem2() {
        super("d3p2");
    }

    ArrayList<String[]> elves = new ArrayList<>();

    @Override
    public void setup(boolean isTest) {
        ArrayList<String> lines = readInputFile(isTest);
        for(int i = 0; i < lines.size(); i += 3) {
            String[] group = new String[3];
            group[0] = lines.get(i);
            group[1] = lines.get(i + 1);
            group[2] = lines.get(i + 2);
            elves.add(group);
        }
    }

    @Override
    public Integer solve() {
        int sum = 0;
        for(String[] elve : elves) {
            sum += find_common_item(elve);
        }
        return sum;
    }

    int find_common_item(String[] elves) {
        for(char a : elves[0].toCharArray()) {
            for(char b : elves[1].toCharArray()) {
                for(char c : elves[2].toCharArray()) {
                    if(a == b && b == c) {
                        if(Character.isUpperCase(a)) {
                            return a - 'A' + 27;
                        } else {
                            return a - 'a' + 1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public boolean test() {
        return solve() == 70;
    }
}
