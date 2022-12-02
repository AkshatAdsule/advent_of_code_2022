package tech.aksads.aoc.solutions.day1;

import tech.aksads.aoc.solutions.Solution;

import java.util.ArrayList;

public class Day1Problem2 extends Solution<Integer> {
    public Day1Problem2() {
        super("d1p2");
    }

    private ArrayList<String> values;

    @Override
    public void setup(boolean isTest) {
        values = readInputFile(isTest);
    }

    @Override
    public Integer solve() {
        int max1 = -1;
        int max2 = -1;
        int max3 = -1;

        int sum = 0;

        for(String line : values) {
            if(line.isEmpty()) {
                if(sum > max1) {
                    max1 = sum;
                    if(sum > max2) {
                        max1 = max2;
                        max2 = sum;
                        if(sum > max3) {
                            max2 = max3;
                            max3 = sum;
                        }
                    }
                }
                sum = 0;
            } else {
                sum += Integer.parseInt(line);
            }
        }

        if(sum != 0) {
            if(sum > max1) {
                max1 = sum;
                if(sum > max2) {
                    max1 = max2;
                    max2 = sum;
                    if(sum > max3) {
                        max2 = max3;
                        max3 = sum;
                    }
                }
            }
        }

        return max1 + max2 + max3;
    }

    @Override
    public boolean test() {
        int value = solve();
        return value == 45000;
    }
}
