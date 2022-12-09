package tech.aksads.aoc;

import com.diogonunes.jcolor.Ansi;

import com.diogonunes.jcolor.Attribute;
import tech.aksads.aoc.solutions.Solution;
import tech.aksads.aoc.solutions.day1.Day1Problem1;
import tech.aksads.aoc.solutions.day1.Day1Problem2;
import tech.aksads.aoc.solutions.day2.Day2Problem1;
import tech.aksads.aoc.solutions.day2.Day2Problem2;
import tech.aksads.aoc.solutions.day3.Day3Problem1;
import tech.aksads.aoc.solutions.day3.Day3Problem2;
import tech.aksads.aoc.solutions.day4.Day4Problem1;
import tech.aksads.aoc.solutions.day4.Day4Problem2;
import tech.aksads.aoc.solutions.day5.Day5Problem1;
import tech.aksads.aoc.solutions.day5.Day5Problem2;
import tech.aksads.aoc.solutions.day6.Day6Problem1;
import tech.aksads.aoc.solutions.day6.Day6Problem2;
import tech.aksads.aoc.solutions.day7.Day7Problem1;
import tech.aksads.aoc.solutions.day7.Day7Problem2;


public class Main {
    private static final Solution<?>[] solutions = new Solution[] {
        new Day1Problem1(),
        new Day1Problem2(),
        new Day2Problem1(),
        new Day2Problem2(),
        new Day3Problem1(),
        new Day3Problem2(),
        new Day4Problem1(),
        new Day4Problem2(),
        new Day5Problem1(),
        new Day5Problem2(),
        new Day6Problem1(),
        new Day6Problem2(),
        new Day7Problem1(),
        new Day7Problem2()
    };

    public static void main(String[] args) {
        boolean test = false;
        boolean runAll = false;
        int currentProblem = solutions.length - 1;
        for(int i = 0; i < args.length; i++) {
            if(args[i].equals("test")) {
                test = true;
            }
            if(args[i].equals("all")) {
                runAll = true;
            }
            if(args[i].equals("prob") && i != args.length - 1) {
               currentProblem = Integer.parseInt(args[i + 1]) - 1;
               i++;
            }
        }
        if(test) {
            if(runAll) {
                for(Solution<?> solution : solutions) {
                    solution.setup(true);
                    boolean passed = solution.test();
                    if(passed) {
                        System.out.println(Ansi.colorize(solution.problem + " passed tests!", Attribute.GREEN_TEXT()));
                    } else {
                        System.err.println(Ansi.colorize(solution.problem + " failed tests!", Attribute.RED_TEXT()));
                    }
                }
            } else {
                Solution<?> solution = solutions[currentProblem];
                solution.setup(true);
                boolean passed = solution.test();
                if(passed) {
                    System.out.println(Ansi.colorize(solution.problem + " passed tests!", Attribute.GREEN_TEXT()));
                } else {
                    System.err.println(Ansi.colorize(solution.problem + " failed tests!", Attribute.RED_TEXT()));
                }
            }
        } else {
            if(runAll) {
                for(Solution<?> solution : solutions) {
                    solution.setup(false);
                    Object output = solution.solve();
                    System.out.println(solution.problem + " returned " + output.toString());
                }
            } else {
                Solution<?> solution = solutions[currentProblem];
                solution.setup(false);
                Object output = solution.solve();
                System.out.println(solution.problem + " returned " + output.toString());
            }
        }

    }
}
