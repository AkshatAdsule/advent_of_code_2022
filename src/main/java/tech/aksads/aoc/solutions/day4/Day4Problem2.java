package tech.aksads.aoc.solutions.day4;

import java.util.ArrayList;

import tech.aksads.aoc.solutions.Solution;

public class Day4Problem2 extends Solution<Integer> {

    private ArrayList<Job[]> jobs = new ArrayList<>();
    
    public Day4Problem2() {
        super("d4p2");
    }

    @Override
    public void setup(boolean isTest) {
        ArrayList<String> lines = readInputFile(isTest);
        for(String line : lines) {
            Job[] job = new Job[2];
            job[0] = Job.parse(line, true);
            job[1] = Job.parse(line, false);
            jobs.add(job);
        }
    }

    @Override
    public Integer solve() {
        int count = 0;

        for(Job[] job : jobs) {
            if(job[0].overlaps(job[1]) || job[1].overlaps(job[0])) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean test() {
        return solve() == 4;
    }
}
