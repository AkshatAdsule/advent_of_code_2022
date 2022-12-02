package tech.aksads.aoc.solutions.day1;

import tech.aksads.aoc.solutions.Solution;

import java.util.ArrayList;

public class Day1Problem1 extends Solution<Integer> {

    public Day1Problem1() {
        super("d1p1");
    }

    private ArrayList<String> values;

    @Override
    public void setup(boolean isTest) {
        values = readInputFile(isTest);
    }

    @Override
    public Integer solve() {
        int max =  -1;
        int sum = 0;

        for(String line : values) {
            if(line.isEmpty()) {
                max = sum > max ? sum : max;
                sum = 0;
            } else {
                sum += Integer.parseInt(line);
            }
        }

        return max;
    }

    @Override
    public boolean test() {
        int value = solve();
        return value == 24000;
    }
}
