package tech.aksads.aoc.solutions.day4;

public class Job {
    int lower, upper;

    public Job(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public static Job parse(String line, boolean is_first) {
        String[] split = line.split(",")[is_first ? 0 : 1].split("-");
        return new Job(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    public boolean fits_within(Job other) {
        return this.lower >= other.lower && this.upper <= other.upper;
    }

    public boolean overlaps(Job other) {
        return other.lower >= lower && other.lower <= upper; 
    }
}
