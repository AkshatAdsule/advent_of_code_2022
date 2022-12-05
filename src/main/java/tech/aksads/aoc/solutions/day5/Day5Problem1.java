package tech.aksads.aoc.solutions.day5;

import java.util.ArrayList;

import tech.aksads.aoc.solutions.Solution;

public class Day5Problem1 extends Solution<String> {

    Stacks stacks = new Stacks();
    ArrayList<Instruction> instructions = new ArrayList<>();
    
    public Day5Problem1() {
        super("d5p1");
    }

    @Override
    public void setup(boolean isTest) {
        int n_stacks = isTest ? 3 : 9;
        int split_index = isTest ? 2 : 7;
        ArrayList<String> lines = readInputFile(isTest);
        stacks.setup(lines.subList(0, split_index + 1), n_stacks);

        for(int i = split_index + 3; i < lines.size(); ++i) {
            instructions.add(Instruction.parse(lines.get(i)));
        }
    }

    @Override
    public String solve() {
        for(Instruction i : instructions) {
            stacks.run_instruction(i);
        }
        return stacks.get_top_containers();
    }

    @Override
    public boolean test() {
        return solve().equals("CMZ");
    }

}
