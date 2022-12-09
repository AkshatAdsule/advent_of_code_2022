package tech.aksads.aoc.solutions.day7;

import tech.aksads.aoc.solutions.Solution;
import tech.aksads.aoc.solutions.day7.fs.*;

public class Day7Problem1 extends Solution<Integer> {

    Directory root;

    public Day7Problem1() {
        super("d7p1");
    }

    @Override
    public void setup(boolean isTest) {
        Parser parser = new Parser(readInputFile(isTest));
        root = parser.parse();
    }

    @Override
    public Integer solve() {
        return root.solve_part_1();
    }

    @Override
    public boolean test() {
        return solve() == 95437;
    }
    
}
