package tech.aksads.aoc.solutions.day6;

import tech.aksads.aoc.solutions.Solution;

public class Day6Problem2 extends Solution<Integer> {

    public Day6Problem2() {
        super("d6p2");
    }

    char[] line;

    @Override
    public void setup(boolean isTest) {
        line = readInputFile(isTest).get(0).toCharArray();
    }

    @Override
    public Integer solve() {
        String buf = line[0] + "";
        for(int i = 1; i < line.length; ++i) {
            if(buf.indexOf(line[i]) == -1) {
                if(buf.length() == 14) {
                    return i;
                } else {
                    buf += line[i];
                }
            } else {
                i -= (buf.length() - 1);
                buf = line[i] + "";
            }
        }
        return 0;
    }

    @Override
    public boolean test() {
        return solve() == 25;
    }
    
}
