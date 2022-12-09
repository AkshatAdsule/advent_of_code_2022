package tech.aksads.aoc.solutions.day7;

import tech.aksads.aoc.solutions.Solution;
import tech.aksads.aoc.solutions.day7.fs.Directory;

public class Day7Problem2 extends Solution<Integer> {

    Directory root;
    int size_needed;

    public Day7Problem2() {
        super("d7p2");
    }

    @Override
    public void setup(boolean isTest) {
        root = new Parser(readInputFile(isTest)).parse();
        size_needed = root.get_size() - 40000000;
    }

    @Override
    public Integer solve() {
        return root.solve_part_2(size_needed);
    }

    @Override
    public boolean test() {
        return solve() == 24933642;
    }
    
}
