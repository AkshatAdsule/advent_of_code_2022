package tech.aksads.aoc.solutions.day3;

import java.util.ArrayList;

import tech.aksads.aoc.solutions.Solution;

public class Day3Problem1 extends Solution<Integer> {

    private ArrayList<String[]> items = new ArrayList<>();

    public Day3Problem1() {
        super("d3p1");
    }

    @Override
    public void setup(boolean isTest) {
        ArrayList<String> lines = readInputFile(isTest);
        int middle;
        for(String line : lines) {
            middle = line.length() / 2;
            items.add(new String[] {line.substring(0,middle), line.substring(middle)});
        }
    }

    int get_common_item(String[] lines) {
        for(char a: lines[0].toCharArray()) {
            for(char b : lines[1].toCharArray()) {
                if(a == b) {
                    if(Character.isUpperCase(a)) {
                        return a - 'A' + 27;
                    } else {
                        return a - 'a' + 1;
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public Integer solve() {
        int sum = 0;
        for(String[] line : items) {
            sum += get_common_item(line);
        }
        return sum;
    }

    @Override
    public boolean test() {
        return solve() == 157;
    }
    
}
