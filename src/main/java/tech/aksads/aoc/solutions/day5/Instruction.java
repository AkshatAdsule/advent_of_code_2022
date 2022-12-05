package tech.aksads.aoc.solutions.day5;

public class Instruction {
    public final int from, to, n_items;

    public Instruction(int n_items, int from, int to) {
        this.from = from;
        this.to = to;
        this.n_items = n_items;
    }

    public static Instruction parse(String line) {
        String[] split = line.split(" ");
        return new Instruction(Integer.parseInt(split[1]), Integer.parseInt(split[3]), Integer.parseInt(split[5]));
    }

    public String toString() {
        return String.format("move %d from %d to %d", n_items, from, to);
    }
}
