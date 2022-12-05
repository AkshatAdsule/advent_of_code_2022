package tech.aksads.aoc.solutions.day5;

import java.util.ArrayList;
import java.util.List;

public class Stacks {
    private ArrayList<Character>[] stacks;

    public void setup(List<String> lines, int n_stacks) {
        stacks = new ArrayList[n_stacks];
        for(int i = 0; i < stacks.length; ++i) {
            stacks[i] = new ArrayList<Character>();
        }

        for(String line : lines) {
            char c;
            for(int i = 0; i < n_stacks; ++i) {
                c = line.charAt(4 * i + 1);
                if(c != ' ') {
                    stacks[i].add(0, c);
                }
            }
        }
    }

    public void run_instruction(Instruction instruction) {
        char c;
        for(int i = instruction.n_items; i > 0; --i) {
            c = stacks[instruction.from - 1].remove(stacks[instruction.from - 1].size() - 1);
            stacks[instruction.to -1].add(c);
        }
    }

    public void run_instruction_part_2(Instruction instruction) {
        int s = stacks[instruction.from - 1].size();
        List<Character> subList = stacks[instruction.from - 1].subList(s - instruction.n_items, s);
        stacks[instruction.to - 1].addAll(subList);
        // stacks[instruction.from - 1].remove(subList);
        for(int i = 0; i < instruction.n_items; ++i) {
            stacks[instruction.from - 1].remove(stacks[instruction.from - 1].size() - 1);
        }
    }

    public String get_top_containers() {
        StringBuilder builder = new StringBuilder();
        for(ArrayList<Character> stack : stacks) {
            builder.append(stack.get(stack.size() - 1));
        }
        return builder.toString();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        int max_items = stacks[0].size();
        for(int i = 1; i < stacks.length; ++i) {
            max_items = Math.max(max_items, stacks[i].size());
        }

        for(int i = max_items - 1; i >= 0; --i) {
            for(int j = 0; j < stacks.length; ++j) {
                if(i >= stacks[j].size()) {
                    builder.append("   ");
                } else {
                    builder.append("[" + stacks[j].get(i) + "]");
                }
                builder.append(' ');
            }
            builder.append('\n');
        }

        for(int i = 0; i < stacks.length; ++i) {
            builder.append(" " + (i + 1) + "  ");
        }

        return builder.toString();
    }
}
